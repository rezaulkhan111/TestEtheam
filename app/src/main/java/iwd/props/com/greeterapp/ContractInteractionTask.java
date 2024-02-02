package iwd.props.com.greeterapp;

import static com.fasterxml.jackson.databind.util.ClassUtil.getPackageName;

import android.os.AsyncTask;
import android.util.Log;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;

import java.io.File;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Objects;

//public class ContractInteractionTask extends AsyncTask<Void, Void, TransactionReceipt> {
//
//    private final String contractAddress = "0x322d4bCaDc587f97B0B735932460486cc25C449a";
//    private String walletFilePath = "";
//    //  private final String walletFile = "file:///android_asset/walletFileJson.txt";
//    private final String walletPassword = "123456Rasel$$";
//    private final String yourPrivateKey = "your_private_key"; // Keep this secure!
//    private final Web3j web3j = Web3j.build(new HttpService("https://sepolia.infura.io/v3/804d4c62a1034819ac69efbea6732426"));
//
//    void setPath(String ppp) {
//        this.walletFilePath = ppp;
//        System.out.println("file " + walletFilePath);
//    }
//
//    @Override
//    protected TransactionReceipt doInBackground(Void... voids) {
//        try {
//            System.out.println("file try" + walletFilePath);
//            Credentials credentials = WalletUtils.loadCredentials(walletPassword, walletFilePath);
//            Greeter yourContract = Greeter.load(contractAddress, web3j, credentials, BigInteger.valueOf(5000000), BigInteger.valueOf(5000000));
////            // Call your contract function with appropriate parameters
//            RemoteCall<TransactionReceipt> remoteCall = yourContract.kill();
////            // Execute the transaction
//            return remoteCall.send();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    protected void onPostExecute(TransactionReceipt transactionReceipt) {
//        if (transactionReceipt != null) {
//            // Transaction successful, handle the receipt
//            System.out.println("Transaction Hash: " + transactionReceipt.getTransactionHash());
//        } else {
//            // Transaction failed or encountered an exception
//            System.out.println("Transaction failed");
//        }
//    }
//}
