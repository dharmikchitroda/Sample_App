package com.example.sample_app.ui.theme.LocalData.Room

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface MyDao {

    @Insert
    suspend fun insert(data: MyEntity)
}