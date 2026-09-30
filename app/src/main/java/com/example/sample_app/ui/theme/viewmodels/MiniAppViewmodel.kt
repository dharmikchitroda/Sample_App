package com.example.sample_app.ui.theme.viewmodels

import android.content.Context
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sample_app.PreferenceManager
import com.example.sample_app.ui.theme.model.CharacterResponse
import com.example.sample_app.ui.theme.reposetry.repoMiniapp
import com.example.sample_app.utils.saveImageToInternalStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject

@HiltViewModel
public class MiniAppViewmodel @Inject constructor(
    private val repository: repoMiniapp,
    private val preferenceManager: PreferenceManager
) : ViewModel() {

    private val _UiState = MutableLiveData<uistate>(uistate.isLoading)
    val UiState: LiveData<uistate> = _UiState

    private val _LocaleUri = MutableStateFlow<Uri?>(null)
    val LocaleUri: StateFlow<Uri?> = _LocaleUri


    sealed class uistate {
        object isLoading : uistate()

        data class Sucess(val ApiresLIst: List<CharacterResponse>) : uistate()

        data class Eror(val eror: String) : uistate()

    }

    init {
        loadApi()
        getImgFromLocal()
    }

    fun loadApi() {
        viewModelScope.launch(Dispatchers.IO) {

            try {

                val response = repository.CharactersFromApi()

                withContext(Dispatchers.Main) {
                    _UiState.value = uistate.Sucess(response.results)

                }

            } catch (e: Exception) {

                _UiState.value = uistate.Eror("eror is ${e.toString()}")

            }
        }
    }

    fun saveImgUri(context: Context, Img: Uri) {

        val path = saveImageToInternalStorage(context, Img)

        if (path != null) {
            preferenceManager.saveinprefernce("profile_img", path)
            getImgFromLocal()
        }
    }

    fun getImgFromLocal() {

        val path = preferenceManager.sharedPreferences.getString(
            "profile_img",
            ""
        )

        if (!path.isNullOrEmpty() && File(path).exists()) {
            _LocaleUri.value = Uri.fromFile(File(path))
        } else {
            _LocaleUri.value = null
        }
    }

}
