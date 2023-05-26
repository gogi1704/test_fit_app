package com.example.test_fit_app.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.test_fit_app.data.model.DateItem
import com.example.test_fit_app.data.model.LessonItem
import com.example.test_fit_app.data.model.LessonModel
import com.example.test_fit_app.data.model.ListItems
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
            isLoading = false
            _lessonsLiveData.value = separator(value)

        }


    private val _lessonsLiveData = MutableLiveData<List<ListItems>>()
    val lessonsLiveData: MutableLiveData<List<ListItems>>
        get() = _lessonsLiveData

    private var isLoading = false
        set(value) {
            field = value
            isLoadingLiveData.value = value
        }



    val isLoadingLiveData = MutableLiveData(isLoading)


    private fun getAllLessons() {
        viewModelScope.launch {
            isLoading = true
            val data = repository.getAll()
            lessonsData = data.lessons.map {
                val trainer = data.trainers.filter { trainer ->
                    it.coach_id.isNotEmpty() && it.coach_id == trainer.id
                }
                it.copy(trainerName = if (trainer.isNotEmpty()) trainer[0].name else "")
            }.sortedWith(compareBy { it.date }).reversed()
        }

    }


    private fun separator(list: List<LessonModel>): MutableList<ListItems> {
        val newList = mutableListOf<ListItems>()
        var prevDate: String? = null
        for (it in list) {
            if (prevDate == null) {
                prevDate = it.date
                newList.add(DateItem(date = it.date))
                newList.add(LessonItem(lessonModel = it))
            } else if (it.date == prevDate) {
                newList.add(LessonItem(lessonModel = it))
            } else {
                newList.add(DateItem(date = it.date))
                newList.add(LessonItem(lessonModel = it))
                prevDate = it.date
            }

        }
        return newList
    }

    init {
        getAllLessons()
    }
}