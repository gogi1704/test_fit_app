package com.example.test_fit_app.data.model

sealed class ListItems {
    abstract val id: Int
}

data class LessonItem(
    override val id: Int = -1,
    val lessonModel: LessonModel
) : ListItems()

data class DateItem(
    override val id: Int = -1,
    val date: String
) : ListItems()
