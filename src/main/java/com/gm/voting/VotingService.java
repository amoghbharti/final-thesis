package com.gm.voting;

import com.gm.blockchain.web3j.Voting;
import com.gm.blockchain.web3j.Candidate;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
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
        votingContract = Voting.load(
                "0xContractAddress",
                web3j,
                credentials,
                new DefaultGasProvider()
        );
    }
    public void registerVoter(String voterAddress) throws Exception {
        votingContract.authorizeVoter(voterAddress).send();
    }
    public void vote(String voterAddress, int candidateId) throws Exception {
        votingContract.voteForCandidate(BigInteger.valueOf(candidateId).toByteArray()).send();
    }

    public List<Candidate> getResults() throws Exception {
        List<?> rawResults = Collections.singletonList(votingContract.getResults().send());

        List<Candidate> candidates = new ArrayList<>();

        // Manually extract each candidate's fields
        for (Object item : rawResults) {
            List<?> candidateData = (List<?>) item;  // Assuming each candidate is a list of fields

            Uint256 id = (Uint256) candidateData.get(0);            // Extract id
            Bytes32 name = (Bytes32) candidateData.get(1);    // Extract name
            Uint8 voteCount = (Uint8) candidateData.get(2);     // Extract vote count

            candidates.add(new Candidate(id, name, voteCount));
        }

        return candidates;
    }
}
