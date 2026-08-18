package com.example.sample_app.ui.theme.reposetry

import com.example.sample_app.ui.theme.Retrofit.ApiService
import com.example.sample_app.ui.theme.Retrofit.RetrofitModule
import com.example.sample_app.ui.theme.model.request.LoginRequestdata
import com.example.sample_app.ui.theme.model.response.LoginResponse
import com.example.sample_app.ui.theme.model.response.SeverStudentdata
import javax.inject.Inject

class repoRetrofit @Inject constructor( private val api: ApiService ) {

    suspend fun fetchfromApi() : SeverStudentdata {
        return api.getAllStudent()

    }

    suspend fun loginToApi(data : LoginRequestdata) : LoginResponse {
        return api.login(data)
    }

}