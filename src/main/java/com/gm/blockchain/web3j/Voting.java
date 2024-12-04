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
    public static final String BINARY = "608060405234801561001057600080fd5b506040516108673803806108678339810160405280510160005b815181101561010657600480546001019055815160029083908390811061004d57fe5b6020908102909101810151825460018101845560009384529282902090920191909155604080516060810190915260045481528351909182019084908490811061009357fe5b60209081029091018101518252600091018190528351600391908590859081106100b957fe5b602090810291909101810151825281810192909252604090810160002083518155918301516001808401919091559201516002909101805460ff191660ff9092169190911790550161002a565b5050610750806101176000396000f3006080604052600436106100a35763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416631a0478d581146100a85780632f265cf7146100e1578063392e66781461010f5780633bc990db1461013b5780634717f97c1461016257806366acfa4a146102555780637021939f14610283578063b13c744b1461029b578063cc9ab267146102b3578063fd47b368146102cd575b600080fd5b3480156100b457600080fd5b506100c06004356102fb565b60408051938452602084019290925260ff1682820152519081900360600190f35b3480156100ed57600080fd5b506100f960043561031f565b6040805160ff9092168252519081900360200190f35b34801561011b57600080fd5b506101276004356103ad565b604080519115158252519081900360200190f35b34801561014757600080fd5b506101506103fa565b60408051918252519081900360200190f35b34801561016e57600080fd5b50610177610400565b60405180806020018060200180602001848103845287818151815260200191508051906020019060200280838360005b838110156101bf5781810151838201526020016101a7565b50505050905001848103835286818151815260200191508051906020019060200280838360005b838110156101fe5781810151838201526020016101e6565b50505050905001848103825285818151815260200191508051906020019060200280838360005b8381101561023d578181015183820152602001610225565b50505050905001965050505050505060405180910390f35b34801561026157600080fd5b5061012773ffffffffffffffffffffffffffffffffffffffff60043516610572565b34801561028f57600080fd5b506100f9600435610587565b3480156102a757600080fd5b5061015060043561059c565b3480156102bf57600080fd5b506102cb6004356105bb565b005b3480156102d957600080fd5b506102cb73ffffffffffffffffffffffffffffffffffffffff600435166106f3565b60036020526000908152604090208054600182015460029092015490919060ff1683565b600061032a826103ad565b151561039757604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601660248201527f43616e646964617465206973206e6f742076616c696400000000000000000000604482015290519081900360640190fd5b5060009081526001602052604090205460ff1690565b6000805b6002548110156103ef5760028054849190839081106103cc57fe5b60009182526020909120015414156103e757600191506103f4565b6001016103b1565b600091505b50919050565b60045481565b60608060608060608060008060028054905060405190808252806020026020018201604052801561043b578160200160208202803883390190505b50600254604080518281526020808402820101909152919650801561046a578160200160208202803883390190505b506002546040805182815260208084028201019091529195508015610499578160200160208202803883390190505b509250600091505b6002548210156105655760028054839081106104b957fe5b600091825260208083209091015480835260039091526040909120548651919250908690849081106104e757fe5b6020908102909101810191909152600082815260039091526040902060010154845185908490811061051557fe5b6020908102909101810191909152600082815260039091526040902060020154835160ff9091169084908490811061054957fe5b60ff9092166020928302909101909101526001909101906104a1565b5092969195509350915050565b60006020819052908152604090205460ff1681565b60016020526000908152604090205460ff1681565b60028054829081106105aa57fe5b600091825260209091200154905081565b3360009081526020819052604090205460ff16151561063b57604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601e60248201527f596f7520617265206e6f7420617574686f72697a656420746f20766f74650000604482015290519081900360640190fd5b610644816103ad565b15156106b157604080517f08c379a000000000000000000000000000000000000000000000000000000000815260206004820152601660248201527f43616e646964617465206973206e6f742076616c696400000000000000000000604482015290519081900360640190fd5b6000908152600160208181526040808420805460ff8082168601811660ff19928316179092556003909352932060020180548085169093019093169116179055565b73ffffffffffffffffffffffffffffffffffffffff166000908152602081905260409020805460ff191660011790555600a165627a7a723058207934ec2dec1e59021987c8d6c72576fe8ca2a6a7f137e386d0e0a1850bed6b090029";

    private static String librariesLinkedBinary;

    public static final String FUNC_CANDIDATES = "candidates";

    public static final String FUNC_TOTALVOTESFOR = "totalVotesFor";

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
