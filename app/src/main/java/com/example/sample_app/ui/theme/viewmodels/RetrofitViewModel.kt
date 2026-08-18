package com.example.sample_app.ui.theme.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.sample_app.ui.theme.model.request.LoginRequestdata
import com.example.sample_app.ui.theme.model.response.LoginResponse
import com.example.sample_app.ui.theme.model.response.User
import com.example.sample_app.ui.theme.reposetry.repoRetrofit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RetrofitViewModel @Inject constructor(val repository: repoRetrofit ) : ViewModel() {

    private val _loginResponse = MutableLiveData<LoginResponse>()
    val loginResponse: LiveData<LoginResponse> = _loginResponse


    fun login(data: LoginRequestdata) {
        viewModelScope.launch {
            try {

                val response = repository.loginToApi(data)

                // response mil gaya
                _loginResponse.value = response

                Log.d("responseApi","$response")

            } catch (e: Exception) {
                Log.e("LOGIN_ERROR", e.message ?: "Unknown error")
            }
        }
    }
}

