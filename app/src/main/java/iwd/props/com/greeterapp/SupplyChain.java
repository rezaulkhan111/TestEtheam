package iwd.props.com.greeterapp;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.5.0.
 */
@SuppressWarnings("rawtypes")
public class SupplyChain extends Contract {
    public static final String BINARY = "60806040525f600155348015610013575f80fd5b50610ec8806100215f395ff3fe608060405234801561000f575f80fd5b506004361061004a575f3560e01c80633cde01b51461004e578063453bccb61461007e57806389c19ddb146100ae578063a3d835c0146100de575b5f80fd5b61006860048036038101906100639190610796565b61010e565b604051610075919061084b565b60405180910390f35b61009860048036038101906100939190610997565b6103cc565b6040516100a5919061084b565b60405180910390f35b6100c860048036038101906100c391906109f1565b6104de565b6040516100d5919061084b565b60405180910390f35b6100f860048036038101906100f391906109f1565b610660565b6040516101059190610a81565b60405180910390f35b606060015482111561011e575f80fd5b5f6040518060400160405280600e81526020017f50726f64756374204e616d653a2000000000000000000000000000000000000081525090506101fa815f808681526020019081526020015f20600101805461017990610ac7565b80601f01602080910402602001604051908101604052809291908181526020018280546101a590610ac7565b80156101f05780601f106101c7576101008083540402835291602001916101f0565b820191905f5260205f20905b8154815290600101906020018083116101d357829003601f168201915b50505050506104de565b905061023b816040518060400160405280601681526020017f3c62723e4d616e756661637475726520446174653a20000000000000000000008152506104de565b90506102e0815f808681526020019081526020015f20600301805461025f90610ac7565b80601f016020809104026020016040519081016040528092919081815260200182805461028b90610ac7565b80156102d65780601f106102ad576101008083540402835291602001916102d6565b820191905f5260205f20905b8154815290600101906020018083116102b957829003601f168201915b50505050506104de565b90505f5b5f808581526020019081526020015f20600401548110156103c2576103b3825f808781526020019081526020015f206005015f8481526020019081526020015f205f01805461033290610ac7565b80601f016020809104026020016040519081016040528092919081815260200182805461035e90610ac7565b80156103a95780601f10610380576101008083540402835291602001916103a9565b820191905f5260205f20905b81548152906001019060200180831161038c57829003601f168201915b50505050506104de565b915080806001019150506102e4565b5080915050919050565b60606001548311156103dc575f80fd5b5f60405180604001604052808481526020013373ffffffffffffffffffffffffffffffffffffffff168152509050805f808681526020019081526020015f206005015f805f8881526020019081526020015f206004015481526020019081526020015f205f820151815f0190816104539190610c94565b506020820151816001015f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555090505060015f808681526020019081526020015f20600401546104bd9190610d90565b5f808681526020019081526020015f20600401819055508291505092915050565b60605f8390505f8390505f815183516104f79190610d90565b67ffffffffffffffff8111156105105761050f610873565b5b6040519080825280601f01601f1916602001820160405280156105425781602001600182028036833780820191505090505b5090505f8190505f805b85518110156105cd5785818151811061056857610567610dc3565b5b602001015160f81c60f81b83838061057f90610df0565b94508151811061059257610591610dc3565b5b60200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191690815f1a905350808060010191505061054c565b505f5b8451811015610651578481815181106105ec576105eb610dc3565b5b602001015160f81c60f81b83838061060390610df0565b94508151811061061657610615610dc3565b5b60200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff191690815f1a90535080806001019150506105d0565b50819550505050505092915050565b5f805f8060015481526020019081526020015f20905033815f015f6101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505f8160040181905550838160010190816106d19190610c94565b506001548160020181905550828160030190816106ee9190610c94565b50600180546106fd9190610d90565b6001819055507f64a55044d1f2eddebe1b90e8e2853e8e96931cefadbfa0b2ceb34bee36061941600180546107329190610e37565b60405161073f9190610e79565b60405180910390a1600191505092915050565b5f604051905090565b5f80fd5b5f80fd5b5f819050919050565b61077581610763565b811461077f575f80fd5b50565b5f813590506107908161076c565b92915050565b5f602082840312156107ab576107aa61075b565b5b5f6107b884828501610782565b91505092915050565b5f81519050919050565b5f82825260208201905092915050565b5f5b838110156107f85780820151818401526020810190506107dd565b5f8484015250505050565b5f601f19601f8301169050919050565b5f61081d826107c1565b61082781856107cb565b93506108378185602086016107db565b61084081610803565b840191505092915050565b5f6020820190508181035f8301526108638184610813565b905092915050565b5f80fd5b5f80fd5b7f4e487b71000000000000000000000000000000000000000000000000000000005f52604160045260245ffd5b6108a982610803565b810181811067ffffffffffffffff821117156108c8576108c7610873565b5b80604052505050565b5f6108da610752565b90506108e682826108a0565b919050565b5f67ffffffffffffffff82111561090557610904610873565b5b61090e82610803565b9050602081019050919050565b828183375f83830152505050565b5f61093b610936846108eb565b6108d1565b9050828152602081018484840111156109575761095661086f565b5b61096284828561091b565b509392505050565b5f82601f83011261097e5761097d61086b565b5b813561098e848260208601610929565b91505092915050565b5f80604083850312156109ad576109ac61075b565b5b5f6109ba85828601610782565b925050602083013567ffffffffffffffff8111156109db576109da61075f565b5b6109e78582860161096a565b9150509250929050565b5f8060408385031215610a0757610a0661075b565b5b5f83013567ffffffffffffffff811115610a2457610a2361075f565b5b610a308582860161096a565b925050602083013567ffffffffffffffff811115610a5157610a5061075f565b5b610a5d8582860161096a565b9150509250929050565b5f8115159050919050565b610a7b81610a67565b82525050565b5f602082019050610a945f830184610a72565b92915050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52602260045260245ffd5b5f6002820490506001821680610ade57607f821691505b602082108103610af157610af0610a9a565b5b50919050565b5f819050815f5260205f209050919050565b5f6020601f8301049050919050565b5f82821b905092915050565b5f60088302610b537fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff82610b18565b610b5d8683610b18565b95508019841693508086168417925050509392505050565b5f819050919050565b5f610b98610b93610b8e84610763565b610b75565b610763565b9050919050565b5f819050919050565b610bb183610b7e565b610bc5610bbd82610b9f565b848454610b24565b825550505050565b5f90565b610bd9610bcd565b610be4818484610ba8565b505050565b5b81811015610c0757610bfc5f82610bd1565b600181019050610bea565b5050565b601f821115610c4c57610c1d81610af7565b610c2684610b09565b81016020851015610c35578190505b610c49610c4185610b09565b830182610be9565b50505b505050565b5f82821c905092915050565b5f610c6c5f1984600802610c51565b1980831691505092915050565b5f610c848383610c5d565b9150826002028217905092915050565b610c9d826107c1565b67ffffffffffffffff811115610cb657610cb5610873565b5b610cc08254610ac7565b610ccb828285610c0b565b5f60209050601f831160018114610cfc575f8415610cea578287015190505b610cf48582610c79565b865550610d5b565b601f198416610d0a86610af7565b5f5b82811015610d3157848901518255600182019150602085019450602081019050610d0c565b86831015610d4e5784890151610d4a601f891682610c5d565b8355505b6001600288020188555050505b505050505050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52601160045260245ffd5b5f610d9a82610763565b9150610da583610763565b9250828201905080821115610dbd57610dbc610d63565b5b92915050565b7f4e487b71000000000000000000000000000000000000000000000000000000005f52603260045260245ffd5b5f610dfa82610763565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8203610e2c57610e2b610d63565b5b600182019050919050565b5f610e4182610763565b9150610e4c83610763565b9250828203905081811115610e6457610e63610d63565b5b92915050565b610e7381610763565b82525050565b5f602082019050610e8c5f830184610e6a565b9291505056fea26469706673582212201d6e0dbeb79cbad6269347674a11865ef6771cee9a1ea2843648e734e356304964736f6c63430008180033";

    public static final String FUNC_ADDSTATE = "addState";

    public static final String FUNC_NEWITEM = "newItem";

    public static final String FUNC_CONCAT = "concat";

    public static final String FUNC_SEARCHPRODUCT = "searchProduct";

    public static final Event ADDED_EVENT = new Event("Added", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected SupplyChain(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected SupplyChain(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected SupplyChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected SupplyChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static List<AddedEventResponse> getAddedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = staticExtractEventParametersWithLog(ADDED_EVENT, transactionReceipt);
        ArrayList<AddedEventResponse> responses = new ArrayList<AddedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            AddedEventResponse typedResponse = new AddedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.index = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public static AddedEventResponse getAddedEventFromLog(Log log) {
        Contract.EventValuesWithLog eventValues = staticExtractEventParametersWithLog(ADDED_EVENT, log);
        AddedEventResponse typedResponse = new AddedEventResponse();
        typedResponse.log = log;
        typedResponse.index = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
        return typedResponse;
    }

    public Flowable<AddedEventResponse> addedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(log -> getAddedEventFromLog(log));
    }

    public Flowable<AddedEventResponse> addedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ADDED_EVENT));
        return addedEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addState(BigInteger _productId, String info) {
        final Function function = new Function(
                FUNC_ADDSTATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_productId), 
                new org.web3j.abi.datatypes.Utf8String(info)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> newItem(String _text, String _date) {
        final Function function = new Function(
                FUNC_NEWITEM, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_text), 
                new org.web3j.abi.datatypes.Utf8String(_date)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<String> concat(String _a, String _b) {
        final Function function = new Function(FUNC_CONCAT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_a), 
                new org.web3j.abi.datatypes.Utf8String(_b)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> searchProduct(BigInteger _productId) {
        final Function function = new Function(FUNC_SEARCHPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_productId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static SupplyChain load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new SupplyChain(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static SupplyChain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new SupplyChain(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static SupplyChain load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new SupplyChain(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static SupplyChain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new SupplyChain(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<SupplyChain> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SupplyChain.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SupplyChain> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SupplyChain.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<SupplyChain> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(SupplyChain.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<SupplyChain> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(SupplyChain.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class AddedEventResponse extends BaseEventResponse {
        public BigInteger index;
    }
}
