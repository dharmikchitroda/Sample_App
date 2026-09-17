package com.example.sample_app.ui.theme.LocalData.Room

import androidx.room.Dao
import androidx.room.Insert
// oop used here : interface create
@Dao
interface MyDao {

    @Insert
    suspend fun insert(data: MyEntity)
}