package com.example.sample_app.ui.theme.model.response

import com.google.gson.annotations.SerializedName

data class SeverStudentdata(

    @SerializedName("users")
    val userlist: List<User>
)

data class User(
    val id: Int,
    @SerializedName("firstName")
    val Name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val mobile: String
)
