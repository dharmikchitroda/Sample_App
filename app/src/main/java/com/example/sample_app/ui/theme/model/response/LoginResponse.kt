package com.example.sample_app.ui.theme.model.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    val id: Int,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("accessToken")
    val accessToken: String,
    @SerializedName("refreshToken")
    val refreshToken: String
)