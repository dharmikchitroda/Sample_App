package com.example.sample_app.ui.theme.reposetry

import android.content.Context
import com.example.sample_app.ui.theme.Retrofit.ApiService
import com.example.sample_app.ui.theme.Retrofit.CharactersService
import com.example.sample_app.ui.theme.model.CharacterListResponse
import com.example.sample_app.ui.theme.model.request.LoginRequestdata
import com.example.sample_app.ui.theme.model.response.LoginResponse
import com.example.sample_app.ui.theme.model.response.SeverStudentdata
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class repoMiniapp @Inject constructor(
    private val api: ApiService,
    private val api2: CharactersService,
    @ApplicationContext private val context: Context
) {

    suspend fun fetchfromApi(): SeverStudentdata {
        return api.getAllStudent()
    }

    suspend fun loginToApi(data: LoginRequestdata): LoginResponse {
        return api.login(data)
    }

    suspend fun CharactersFromApi(): CharacterListResponse {
        return api2.GetCharactes()
    }
}
/*  */