package org.ocandroid.di.util

import android.util.Log
import javax.inject.Inject

class Logger @Inject constructor(
    private val uuid: String
) {

    fun logMessage(source: String? = null, message: String) {
        Log.e(source ?: "$uuid Logger", message)
    }

}