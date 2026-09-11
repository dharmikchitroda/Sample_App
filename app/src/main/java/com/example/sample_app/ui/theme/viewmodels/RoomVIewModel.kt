package com.example.sample_app.ui.theme.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sample_app.ui.theme.LocalData.Room.MyEntity
import com.example.sample_app.ui.theme.reposetry.StudentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomVIewModel @Inject constructor(
    private val repository: StudentRepository
) : ViewModel() {

    fun insert(student: MyEntity) {
        viewModelScope.launch {
            repository.insert(student)
        }
    }
}