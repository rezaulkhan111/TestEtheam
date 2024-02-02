package iwd.props.com.greeterapp

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.web3j.crypto.WalletFile
import org.web3j.crypto.WalletUtils
import org.web3j.protocol.Web3j
import org.web3j.protocol.core.RemoteCall
import org.web3j.protocol.core.methods.response.TransactionReceipt
import org.web3j.protocol.http.HttpService
import java.io.File
import java.math.BigInteger
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths


class MainActivity : AppCompatActivity() {

    private lateinit var toolbar1: Toolbar
    private lateinit var fab: FloatingActionButton
    private val TAG: String = "MA"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar1 = findViewById(R.id.toolbar1)
        fab = findViewById(R.id.fab)
        setSupportActionBar(toolbar1)

        //   val contractAddress = "0x322d4bCaDc587f97B0B735932460486cc25C449a"

        //https://sepolia.infura.io/v3/YOUR-API-KEY (app.infura.io)
        //    val url = "https://sepolia.infura.io/v3/804d4c62a1034819ac69efbea6732426"
        // val web3j = Web3jFactory.build(InfuraHttpService(url))
        //  val web3j: Web3j = Web3j.build(HttpService(url))
        // (HttpService("https://mainnet.infura.io/v3/your_infura_project_id"))
        //   val gasLimit: BigInteger = BigInteger.valueOf(24026L)
        //   val gasPrice: BigInteger = BigInteger.valueOf(23688)

//        val transaction: Transaction = Transaction.createEtherTransaction(
//            contractAddress,  // Sender address
//            BigInteger.valueOf(1),  // Nonce
//            gasPrice,  // Gas price
//            gasLimit,  // Gas limit
//            contractAddress,  // Recipient address
//            BigInteger.valueOf(10)// Value to send
//        )


        /*** HONOR SYSTEM TEST ETHER ACCOUNT (ಠ_ಠ) ***/
        //   val credentials = Credentials.create("0x8E035a6AA14aE4F2A0653AB6Ec3EaC1adE7bBe3E")
        //  val contract = You
        //  val greeter = Greeter.load(contractAddress, web3j, credentials, gasPrice, gasLimit)

        fab.setOnClickListener { _ ->
            val internalStorageDir = filesDir
//            val filePathInInternalStorage =
//                File(internalStorageDir, "walletFileJson.json")
            //  println("MA " + filePathInInternalStorage.absolutePath)
//            val filePath = internalStorageDir.absolutePath + "/walletFileJson.json"
            val externalStorageDir = internalStorageDir
            val assetManager = Utility.getUriFromPath(this, "")
            // Construct the file path within external storage
            println("filePathInSt " + assetManager.path)
            val filePathInSt = File(assetManager.path.toString())
            if (filePathInSt.exists()) {
                val filePathI = File(assetManager.path.toString(), "walletFileJson.json")
                if (filePathI.exists()) {
                    println("exists " + filePathI.path)

                    val cccc = ContractInteractionTask().apply {
                        setPath(filePathI.path)
                    }
                    cccc.execute()
                }
            }
//                println("exists " + filePathInExternalStorage.path)
//                val cccc = ContractInteractionTask().apply {
//                    setPath(filePathInExternalStorage.absolutePath)
//                }
//                cccc.execute()
//            }


//            val mWeb3j = Web3j.build(HttpService("HTTP://127.0.0.1:7545"))
//            mWeb3j.web3ClientVersion().sendAsync().thenAccept { itResponse ->
//                if (itResponse.hasError()) {
//                    println("Error " + itResponse.error.message)
//                } else {
//                    println("Error " + itResponse.result)
//                    println("raw result " + itResponse.rawResponse.toString())
//                }
//            }

            /*** SIMPLE EXECUTION ONLY FOR DEMO PURPOSES.... THIS THREAD INITIALIZATION HERE IS BAD PRACTICE ***/
//            val thread = Thread {
//                try {
//                    // check contract validity
//                    Log.d(TAG, " ${greeter.isValid}")
//                    // read from contract
//                    val greeting: Future<String>? = greeter.greet().sendAsync()
//                    val convertToString: String? = greeting?.get()
//                    Log.d(TAG, "greeting value returned: $convertToString")
//
//                    // write to contract
//                    val transactionReceipt: Future<TransactionReceipt>? =
//                        greeter.changeGreeting("Greeting changed from an Android App (ಠ_ಠ) ")
//                            .sendAsync()
//                    val result =
//                        "Successful transaction. Gas used: ${transactionReceipt?.get()?.blockNumber}  ${transactionReceipt?.get()?.gasUsed}"
//                    Log.d(TAG, result)
//
//                } catch (e: Exception) {
//                    e.printStackTrace()
//                    Log.d(TAG, "error accessing contract: " + e.message)
//                }
//            }
//            thread.start()
        }
    }
}

class ContractInteractionTask :
    AsyncTask<Void?, Void?, TransactionReceipt?>() {
    private val contractAddress = "0x322d4bCaDc587f97B0B735932460486cc25C449a"
    private var walletFilePath = ""

    //  private final String walletFile = "file:///android_asset/walletFileJson.txt";
    private val walletPassword = "123456Rasel$$"
    private val yourPrivateKey = "your_private_key" // Keep this secure!
    private val web3j =
        Web3j.build(HttpService("https://sepolia.infura.io/v3/804d4c62a1034819ac69efbea6732426"))

    fun setPath(ppp: String) {
        walletFilePath = ppp
        println("file $walletFilePath")
    }

    override fun doInBackground(vararg voids: Void?): TransactionReceipt? {
        return try {
            println("file try$walletFilePath")

            val credentials = WalletUtils.loadCredentials(walletPassword, walletFilePath)
//            val yourContract = Greeter.load(
//                contractAddress,
//                web3j,
//                credentials,
//                BigInteger.valueOf(5000000),
//                BigInteger.valueOf(5000000)
//            )
//            val remoteCall: RemoteCall<TransactionReceipt> = yourContract.kill()
//            remoteCall.send()
            return null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override fun onPostExecute(transactionReceipt: TransactionReceipt?) {
        if (transactionReceipt != null) {
            // Transaction successful, handle the receipt
            println("Transaction Hash: " + transactionReceipt.transactionHash)
        } else {
            // Transaction failed or encountered an exception
            println("Transaction failed")
        }
    }
}
