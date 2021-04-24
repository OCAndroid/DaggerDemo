package org.ocandroid.di.login.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.ocandroid.di.login.model.repository.LoginRepository
import org.ocandroid.di.data.Result
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    val viewState = MutableLiveData<ViewState>()

    fun login(username: String?, password: String?) {
        viewState.value = ViewState.Loading
        // can be launched in a separate asynchronous job

        when (val result = loginRepository.login(username, password)) {
            is Result.Success -> {
                viewState.value = ViewState.Success(result.data.displayName, result.data.userId)
            }
            is Result.Error -> {
                viewState.value = ViewState.Error(result.exception.message)
            }
        }
    }

    sealed class ViewState {
        object Loading : ViewState()
        data class Error(val message: String?) : ViewState()
        data class Success(val displayName: String, val id: String) : ViewState()
    }
}