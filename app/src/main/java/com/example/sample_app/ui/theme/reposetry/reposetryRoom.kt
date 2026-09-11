package com.example.sample_app.ui.theme.reposetry

import com.example.sample_app.ui.theme.LocalData.Room.MyDao
import com.example.sample_app.ui.theme.LocalData.Room.MyEntity
import javax.inject.Inject

class StudentRepository @Inject constructor(
    private val dao: MyDao
) {

    suspend fun insert(student: MyEntity) {
        dao.insert(student)
    }
}