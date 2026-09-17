package com.example.sample_app.ui.theme.Retrofit

import com.example.sample_app.ui.theme.model.CharacterListResponse
import com.example.sample_app.ui.theme.model.CharacterResponse
import retrofit2.http.GET

interface CharactersService {

    @GET( "character/")
    suspend fun GetCharactes(): CharacterListResponse

}