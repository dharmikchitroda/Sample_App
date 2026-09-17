package com.example.sample_app.ui.theme.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sample_app.ui.theme.model.CharacterResponse
import com.example.sample_app.ui.theme.reposetry.repoRetrofit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
public class  MiniAppViewmodel @Inject constructor(  private val reposetry: repoRetrofit ) : ViewModel() {

    private val _UiState = MutableLiveData<uistate>(uistate.isLoading)
    val UiState: LiveData<uistate> = _UiState

    sealed class uistate {
        object isLoading : uistate()

        data class Sucess(val ApiresLIst: List<CharacterResponse>) : uistate()

        data class Eror(val eror: String) : uistate()

    }

    init {
        loadApi()
    }

    fun loadApi() {
        viewModelScope.launch(Dispatchers.IO) {

            try {

                val response = reposetry.CharactersFromApi()
 
                withContext(Dispatchers.Main) {
                    _UiState.value = uistate.Sucess(response.results)

                }

            } catch (e: Exception) {

                _UiState.value = uistate.Eror("eror is ${e.toString()}")

            }
        }
    }
}

//class miniappviewmodel : ViewModel() {
//
//    private lateinit var tempemail: String
//    private lateinit var temppass: String
//
//    fun addmail(mail: String) {
//        tempemail = mail
//    }
//
//
//}