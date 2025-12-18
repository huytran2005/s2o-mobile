package com.example.s2o.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.s2o.core.network.ApiResult
import com.example.s2o.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: AuthRepository
) : ViewModel() {

    private val _state = MutableStateFlow(AuthState())
    val state = _state.asStateFlow()

    fun onEmailChange(value: String) {
        _state.update { it.copy(email = value) }
    }

    fun onPasswordChange(value: String) {
        _state.update { it.copy(password = value) }
    }

    fun login() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }

            when (val result = repository.login(
                state.value.email,
                state.value.password
            )) {
                is ApiResult.Loading -> {
                    _state.value = state.value.copy(isLoading = true)
                }

                is ApiResult.Success -> {
                    _state.value = state.value.copy(
                        isLoading = false,
                        isLoginSuccess = true
                    )
                }

                is ApiResult.Error -> {
                    _state.value = state.value.copy(
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}
