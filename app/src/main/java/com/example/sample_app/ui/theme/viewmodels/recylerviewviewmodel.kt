package com.example.sample_app.ui.theme.viewmodels

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sample_app.ui.theme.model.Studentdata
import com.example.sample_app.ui.theme.model.response.SeverStudentdata
import com.example.sample_app.ui.theme.model.response.User
import com.example.sample_app.ui.theme.reposetry.repoRetrofit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.collections.emptyList

@HiltViewModel
class recylerviewviewmodel @Inject constructor(private val repository: repoRetrofit) : ViewModel() {

    private val _studentdatalive = MutableStateFlow<List<User>>(emptyList())
    val studentdatalive: StateFlow<List<User>> = _studentdatalive

    private val _loading = MutableLiveData<Boolean>(true)
    val loading: LiveData<Boolean> = _loading


    init {
        fetchuser()
    }

    fun fetchuser() {

        viewModelScope.launch {


            try {
                val response = repository.fetchfromApi()
                _studentdatalive.value = response.userlist
                Log.d("responseApi","$response")

            } catch (e: Exception) {

            } finally {
                _loading.value = false
            }

        }
    }

}