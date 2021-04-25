package org.ocandroid.di.util

import android.content.Context
import android.widget.Toast
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class Toaster @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun toastMessage(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}