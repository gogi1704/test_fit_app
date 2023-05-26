package com.example.test_fit_app.data.model

sealed class ListItems {

}

data class LessonItem(
    val lessonModel: LessonModel
) : ListItems()

data class DateItem(
    val date: String
) : ListItems()
