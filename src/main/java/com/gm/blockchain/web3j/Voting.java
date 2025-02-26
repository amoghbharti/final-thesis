package com.gm.blockchain.web3j;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/hyperledger/web3j/tree/main/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.12.1.
 */
@SuppressWarnings("rawtypes")
public class Voting extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5060405161094e38038061094e8339810160405280510160005b815181101561010657600480546001019055815160029083908390811061004d57fe5b6020908102909101810151825460018101845560009384529282902090920191909155604080516060810190915260045481528351909182019084908490811061009357fe5b60209081029091018101518252600091018190528351600391908590859081106100b957fe5b602090810291909101810151825281810192909252604090810160002083518155918301516001808401919091559201516002909101805460ff191660ff9092169190911790550161002a565b5050610837806101176000396000f3006080604052600436106100b95763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416630e30987981146100be5780631a0478d5146100d85780632f265cf71461011157806330a563471461013f578063392e6678146101665780633bc990db146101925780634717f97c146101a757806366acfa4a1461029a5780637021939f146102c8578063b13c744b146102e0578063cc9ab267146102f8578063fd47b36814610310575b600080fd5b3480156100ca57600080fd5b506100d660043561033e565b005b3480156100e457600080fd5b506100f0600435610421565b60408051938452602084019290925260ff1682820152519081900360600190f35b34801561011d57600080fd5b50610129600435610445565b6040805160ff9092168252519081900360200190f35b34801561014b57600080fd5b506101546104bc565b60408051918252519081900360200190f35b34801561017257600080fd5b5061017e6004356104c2565b604080519115158252519081900360200190f35b34801561019e57600080fd5b5061015461050f565b3480156101b357600080fd5b506101bc610515565b60405180806020018060200180602001848103845287818151815260200191508051906020019060200280838360005b838110156102045781810151838201526020016101ec565b50505050905001848103835286818151815260200191508051906020019060200280838360005b8381101561024357818101518382015260200161022b565b50505050905001848103825285818151815260200191508051906020019060200280838360005b8381101561028257818101518382015260200161026a565b50505050905001965050505050505060405180910390f35b3480156102a657600080fd5b5061017e73ffffffffffffffffffffffffffffffffffffffff60043516610687565b3480156102d457600080fd5b5061012960043561069c565b3480156102ec57600080fd5b506101546004356106b1565b34801561030457600080fd5b506100d66004356106d0565b34801561031c57600080fd5b506100d673ffffffffffffffffffffffffffffffffffffffff600435166107da565b610347816104c2565b1561039c576040805160e560020a62461bcd02815260206004820152601860248201527f43616e64696461746520616c7265616479206578697374730000000000000000604482015290519081900360640190fd5b60048054600190810182556002805480830182557f405787fa12a823e0f2b7631cc41b3ba8828b3321ca811111fa75cd3aa3bb5ace01849055604080516060810182529354845260208085018681526000868401818152978152600390925291902093518455519183019190915591519101805460ff191660ff909216919091179055565b60036020526000908152604090208054600182015460029092015490919060ff1683565b6000610450826104c2565b15156104a6576040805160e560020a62461bcd02815260206004820152601660248201527f43616e646964617465206973206e6f742076616c696400000000000000000000604482015290519081900360640190fd5b5060009081526001602052604090205460ff1690565b60045490565b6000805b6002548110156105045760028054849190839081106104e157fe5b60009182526020909120015414156104fc5760019150610509565b6001016104c6565b600091505b50919050565b60045481565b606080606080606080600080600280549050604051908082528060200260200182016040528015610550578160200160208202803883390190505b50600254604080518281526020808402820101909152919650801561057f578160200160208202803883390190505b5060025460408051828152602080840282010190915291955080156105ae578160200160208202803883390190505b509250600091505b60025482101561067a5760028054839081106105ce57fe5b600091825260208083209091015480835260039091526040909120548651919250908690849081106105fc57fe5b6020908102909101810191909152600082815260039091526040902060010154845185908490811061062a57fe5b6020908102909101810191909152600082815260039091526040902060020154835160ff9091169084908490811061065e57fe5b60ff9092166020928302909101909101526001909101906105b6565b5092969195509350915050565b60006020819052908152604090205460ff1681565b60016020526000908152604090205460ff1681565b60028054829081106106bf57fe5b600091825260209091200154905081565b3360009081526020819052604090205460ff161515610739576040805160e560020a62461bcd02815260206004820152601e60248201527f596f7520617265206e6f7420617574686f72697a656420746f20766f74650000604482015290519081900360640190fd5b610742816104c2565b1515610798576040805160e560020a62461bcd02815260206004820152601660248201527f43616e646964617465206973206e6f742076616c696400000000000000000000604482015290519081900360640190fd5b6000908152600160208181526040808420805460ff8082168601811660ff19928316179092556003909352932060020180548085169093019093169116179055565b73ffffffffffffffffffffffffffffffffffffffff166000908152602081905260409020805460ff191660011790555600a165627a7a72305820c2b695998ea11b6b7ca5ca4d4b0bc414fafced4278261649ea79edd4d5f9e3cd0029";

    private static String librariesLinkedBinary;

    public static final String FUNC_REGISTERCANDIDATE = "registerCandidate";

    public static final String FUNC_CANDIDATES = "candidates";

    public static final String FUNC_TOTALVOTESFOR = "totalVotesFor";

    public static final String FUNC_GETCANDIDATECOUNT = "getCandidateCount";

    public static final String FUNC_VALIDCANDIDATE = "validCandidate";

    public static final String FUNC_CANDIDATECOUNTER = "candidateCounter";

    public static final String FUNC_GETRESULTS = "getResults";

    public static final String FUNC_AUTHORIZEDVOTERS = "authorizedVoters";

    public static final String FUNC_VOTESRECEIVED = "votesReceived";

    public static final String FUNC_CANDIDATELIST = "candidateList";

    public static final String FUNC_VOTEFORCANDIDATE = "voteForCandidate";

    public static final String FUNC_AUTHORIZEVOTER = "authorizeVoter";

    @Deprecated
    protected Voting(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Voting(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Voting(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Voting(String contractAddress, Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> registerCandidate(byte[] candidateName) {
        final Function function = new Function(
                FUNC_REGISTERCANDIDATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(candidateName)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<BigInteger, byte[], BigInteger>> candidates(byte[] param0) {
        final Function function = new Function(FUNC_CANDIDATES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Uint8>() {}));
        return new RemoteFunctionCall<Tuple3<BigInteger, byte[], BigInteger>>(function,
                new Callable<Tuple3<BigInteger, byte[], BigInteger>>() {
                    @Override
                    public Tuple3<BigInteger, byte[], BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, byte[], BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (byte[]) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> totalVotesFor(byte[] candidate) {
        final Function function = new Function(FUNC_TOTALVOTESFOR, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(candidate)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> getCandidateCount() {
        final Function function = new Function(FUNC_GETCANDIDATECOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<Boolean> validCandidate(byte[] candidate) {
        final Function function = new Function(FUNC_VALIDCANDIDATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(candidate)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> candidateCounter() {
        final Function function = new Function(FUNC_CANDIDATECOUNTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple3<List<BigInteger>, List<byte[]>, List<BigInteger>>> getResults(
            ) {
        final Function function = new Function(FUNC_GETRESULTS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Bytes32>>() {}, new TypeReference<DynamicArray<Uint8>>() {}));
        return new RemoteFunctionCall<Tuple3<List<BigInteger>, List<byte[]>, List<BigInteger>>>(function,
                new Callable<Tuple3<List<BigInteger>, List<byte[]>, List<BigInteger>>>() {
                    @Override
                    public Tuple3<List<BigInteger>, List<byte[]>, List<BigInteger>> call() throws
                            Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<List<BigInteger>, List<byte[]>, List<BigInteger>>(
                                convertToNative((List<Uint256>) results.get(0).getValue()), 
                                convertToNative((List<Bytes32>) results.get(1).getValue()), 
                                convertToNative((List<Uint8>) results.get(2).getValue()));
                    }
                });
    }

    public RemoteFunctionCall<Boolean> authorizedVoters(String param0) {
        final Function function = new Function(FUNC_AUTHORIZEDVOTERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<BigInteger> votesReceived(byte[] param0) {
        final Function function = new Function(FUNC_VOTESRECEIVED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<byte[]> candidateList(BigInteger param0) {
        final Function function = new Function(FUNC_CANDIDATELIST, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bytes32>() {}));
        return executeRemoteCallSingleValueReturn(function, byte[].class);
    }

    public RemoteFunctionCall<TransactionReceipt> voteForCandidate(byte[] candidate) {
        final Function function = new Function(
                FUNC_VOTEFORCANDIDATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Bytes32(candidate)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> authorizeVoter(String voter) {
        final Function function = new Function(
                FUNC_AUTHORIZEVOTER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, voter)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Voting load(String contractAddress, Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit) {
        return new Voting(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Voting load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Voting(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Voting load(String contractAddress, Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider) {
        return new Voting(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Voting load(String contractAddress, Web3j web3j,
            TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Voting(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Voting> deploy(Web3j web3j, Credentials credentials,
            ContractGasProvider contractGasProvider, List<byte[]> candidateNames) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(candidateNames, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Voting.class, web3j, credentials, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    public static RemoteCall<Voting> deploy(Web3j web3j, TransactionManager transactionManager,
            ContractGasProvider contractGasProvider, List<byte[]> candidateNames) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(candidateNames, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Voting.class, web3j, transactionManager, contractGasProvider, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Voting> deploy(Web3j web3j, Credentials credentials,
            BigInteger gasPrice, BigInteger gasLimit, List<byte[]> candidateNames) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(candidateNames, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Voting.class, web3j, credentials, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Voting> deploy(Web3j web3j, TransactionManager transactionManager,
            BigInteger gasPrice, BigInteger gasLimit, List<byte[]> candidateNames) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Bytes32>(
                        org.web3j.abi.datatypes.generated.Bytes32.class,
                        org.web3j.abi.Utils.typeMap(candidateNames, org.web3j.abi.datatypes.generated.Bytes32.class))));
        return deployRemoteCall(Voting.class, web3j, transactionManager, gasPrice, gasLimit, getDeploymentBinary(), encodedConstructor);
    }

    public static void linkLibraries(List<Contract.LinkReference> references) {
        librariesLinkedBinary = linkBinaryWithReferences(BINARY, references);
    }

    private static String getDeploymentBinary() {
        if (librariesLinkedBinary != null) {
            return librariesLinkedBinary;
        } else {
            return BINARY;
        }
    }
}
