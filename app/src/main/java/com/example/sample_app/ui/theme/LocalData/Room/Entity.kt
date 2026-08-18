package com.example.sample_app.ui.theme.LocalData.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val email: String,
    val mobile: String,
    val address: String
)