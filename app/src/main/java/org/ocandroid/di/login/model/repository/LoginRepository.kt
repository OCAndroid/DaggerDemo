package org.ocandroid.di.login.model.repository

import org.ocandroid.di.data.Result
import org.ocandroid.di.login.model.LoggedInUser
import org.ocandroid.di.util.Logger
import java.io.IOException
import java.lang.RuntimeException
import java.util.UUID.randomUUID
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val logger: Logger
) {

    fun login(username: String?, password: String?): Result<LoggedInUser> {
        logger.logMessage(this.javaClass.simpleName, message = "login: $username - $password")
        return try {
            if (username.isNullOrEmpty() || password.isNullOrEmpty()) {
                throw RuntimeException("Login Fields Empty")
            }

            val user = LoggedInUser(randomUUID().toString(), "John Doe")
            logger.logMessage(this.javaClass.simpleName, message = "login success: $user")
            Result.Success(user)
        } catch (e: Throwable) {
            logger.logMessage(this.javaClass.simpleName, message = "login error: $e")
            Result.Error(IOException("Error logging in", e))
        }
    }
}