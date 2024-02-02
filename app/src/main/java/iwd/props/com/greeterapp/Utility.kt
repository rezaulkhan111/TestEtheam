package iwd.props.com.greeterapp

import android.content.Context
import android.net.Uri

object Utility {
    fun getUriFromPath(context: Context, fileNameExtension: String): Uri {
        return Uri.parse(context.filesDir.absolutePath  + fileNameExtension)
    }
}