package org.ocandroid.di.login.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import dagger.hilt.android.AndroidEntryPoint
import org.ocandroid.di.auth.view.AuthedActivity
import org.ocandroid.di.databinding.ActivityLoginBinding
import org.ocandroid.di.login.presentation.LoginViewModel
import org.ocandroid.di.util.Logger
import org.ocandroid.di.util.Toaster
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var binding: ActivityLoginBinding

    @Inject lateinit var logger: Logger
    @Inject lateinit var toaster: Toaster
    //@Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //(application as DIApplication).applicationComponent.inject(this)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)


        loginViewModel.viewState.observe(this@LoginActivity, { viewState ->
            when (viewState) {
                is LoginViewModel.ViewState.Loading -> {
                    binding.loading.visibility = View.VISIBLE
                }
                is LoginViewModel.ViewState.Error -> {
                    binding.loading.visibility = View.GONE
                    showLoginFailed(viewState.message)
                }
                is LoginViewModel.ViewState.Success -> {
                    binding.loading.visibility = View.GONE
                    updateUiWithUser(viewState.displayName, viewState.id)
                }
            }
        })

        binding.apply {
            login.setOnClickListener {
                loginViewModel.login(username.text.toString(), password.text.toString())
            }
        }
    }

    private fun updateUiWithUser(displayName: String, userId: String) {
        logger.logMessage(this.javaClass.simpleName, "Login success: $displayName")
        toaster.toastMessage("Welcome $displayName!")
        AuthedActivity.startActivity(this, displayName, userId)
    }

    private fun showLoginFailed(errorString: String?) {
        logger.logMessage(this.javaClass.simpleName, "Login error: $errorString")
        toaster.toastMessage(errorString)
    }
}