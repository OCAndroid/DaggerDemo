package org.ocandroid.di.util

import android.content.Context
import android.widget.Toast
import javax.inject.Inject

class Toaster @Inject constructor(
    private val context: Context
) {
    fun toastMessage(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}