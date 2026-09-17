package com.example.sample_app.ui.theme.model

import com.google.gson.annotations.SerializedName

data class CharacterListResponse(
    @SerializedName("results")
    val results: List<CharacterResponse>
)
data class CharacterResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("image")
    val image: String
)