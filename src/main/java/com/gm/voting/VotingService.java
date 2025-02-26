package com.gm.voting;

import com.gm.blockchain.web3j.Voting;
import com.gm.blockchain.web3j.Candidate;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class VotingService {
    @Autowired
    private Web3j web3j;
    @Autowired
    private Credentials credentials;
    private Voting votingContract;

    @PostConstruct
    public void init() throws Exception {
        final BigInteger CHAIN_ID = BigInteger.valueOf(1337);

        // Define custom gas price and limit
        final BigInteger GAS_PRICE = BigInteger.valueOf(22_000_000_000L); // 22 Gwei
        final BigInteger GAS_LIMIT = BigInteger.valueOf(4_700_000);

        // Use StaticGasProvider to ensure correct gas settings
        ContractGasProvider gasProvider = new StaticGasProvider(GAS_PRICE, GAS_LIMIT);

        // Use RawTransactionManager with explicit CHAIN_ID (fixes EIP-155 error)
        TransactionManager transactionManager = new RawTransactionManager(web3j, credentials, CHAIN_ID.longValue());

        // Load contract with the custom transaction manager
        votingContract = Voting.load(
                "0xbfd998d50974d48c35d12b1f6489a2661bc66b00",
                web3j,
                transactionManager, // Ensures EIP-155 transactions
                gasProvider
        );

        System.out.println("Loaded contract at: " + votingContract.getContractAddress());

        // Register candidates dynamically with EIP-155-compatible transactions
        String[] candidates = {"Alice", "Bob", "Charlie"};
        for (String candidate : candidates) {
            byte[] candidateBytes32 = Arrays.copyOf(candidate.getBytes(StandardCharsets.UTF_8), 32);
            votingContract.registerCandidate(candidateBytes32).send();
        }
    }
    public void registerVoter(String voterAddress) throws Exception {
        votingContract.authorizeVoter(voterAddress).send();
    }
    public void vote(String voterAddress, int candidateId) throws Exception {
        votingContract.voteForCandidate(BigInteger.valueOf(candidateId).toByteArray()).send();
    }

    public List<Candidate> getResults() throws Exception {
        List<Candidate> candidates = new ArrayList<>();
    
        // Fetch results from the smart contract
        Tuple3<List<BigInteger>,List<byte[]>,List<BigInteger>> results = votingContract.getResults().send();
    
        List<BigInteger> ids = results.component1();  // Candidate IDs
        List<byte[]> names = results.component2();   // Candidate names (bytes32)
        List<BigInteger> votes = results.component3(); // Vote counts
    
        for (int i = 0; i < ids.size(); i++) {
            BigInteger id = ids.get(i);
            String name = new String(names.get(i)).trim(); // Convert bytes32 to String
            BigInteger voteCount = votes.get(i);
    
            candidates.add(new Candidate(id.intValue(), name, voteCount.intValue()));
        }
    
        return candidates;
    }
}
