package com.example.sample_app.ui.theme.Retrofit

import com.example.sample_app.ui.theme.model.request.LoginRequestdata
import com.example.sample_app.ui.theme.model.response.LoginResponse
import com.example.sample_app.ui.theme.model.response.SeverStudentdata
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("users")
    suspend fun getAllStudent(): SeverStudentdata

    @POST("user/login")
    suspend fun login( @Body request: LoginRequestdata): LoginResponse


}