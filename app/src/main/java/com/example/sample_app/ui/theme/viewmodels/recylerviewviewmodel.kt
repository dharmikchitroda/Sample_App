package com.example.sample_app.ui.theme.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sample_app.ui.theme.model.response.User
import com.example.sample_app.ui.theme.reposetry.repoRetrofit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecylerViewViewModel @Inject constructor(private val repository: repoRetrofit) : ViewModel() {


    private val _uiState = MutableStateFlow<ApiResult>(ApiResult.Loading)
    val uiState: StateFlow<ApiResult> = _uiState




    init {
        fetchuser()
    }

    sealed class ApiResult() {
        object Loading : ApiResult()

        data class Success(val data: List<User>) : ApiResult()
        data class Error(val message: String) : ApiResult()
    }


    fun fetchuser() {

        viewModelScope.launch {
            _uiState.value = ApiResult.Loading

            try {
                val response = repository.fetchfromApi()

                _uiState.value = ApiResult.Success(response.userlist)

                Log.d("responseApi", "$response")

            } catch (e: Exception) {
                ApiResult.Error("eror is $e")

            }

        }
    }

}