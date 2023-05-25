package com.example.test_fit_app.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.test_fit_app.data.model.LessonModel
import com.example.test_fit_app.data.repository.LessonsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LessonsViewModel @Inject constructor(
    application: Application,
    private val repository: LessonsRepository
) : AndroidViewModel(application) {

    private var lessonsData = emptyList<LessonModel>()
        set(value) {
            field = value
            _lessonsLiveData.value = value
        }

    private val _lessonsLiveData = MutableLiveData(lessonsData)
    val lessonsLiveData: MutableLiveData<List<LessonModel>>
        get() = _lessonsLiveData

    private fun getAllLessons() {
        viewModelScope.launch {
            val data = repository.getAll()
            lessonsData = data.lessons.map {
                val trainer = data.trainers.filter { trainer ->
                    it.coach_id.isNotEmpty() && it.coach_id == trainer.id
                }
                it.copy(trainerName = if (trainer.isNotEmpty()) trainer[0].name else "")
            }
        }
    }

    init {
        getAllLessons()
    }
}