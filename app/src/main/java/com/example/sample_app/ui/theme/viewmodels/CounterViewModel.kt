package com.example.sample_app.ui.theme.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {


    private val _count = MutableLiveData<Int>(0)
    val count: LiveData<Int> = _count

    fun inc() {
        _count.value = (_count.value ?: 0) + (1)
    }

    fun dec() {
        _count.value = (_count.value ?: 0) - (1)
    }

}