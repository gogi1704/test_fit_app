package com.example.test_fit_app.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.test_fit_app.data.repository.LessonsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LessonsViewModel @Inject constructor(
    application: Application,
    private val repository: LessonsRepository
) : AndroidViewModel(application) {

    fun getAllLessons() {
        viewModelScope.launch {
            val data = repository.getAll().lessons
            println(data)
        }
    }
}