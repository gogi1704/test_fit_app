package com.example.test_fit_app.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.test_fit_app.data.model.LessonModel

class LessonsDiffUtil: DiffUtil.ItemCallback<LessonModel>() {
    override fun areItemsTheSame(oldItem: LessonModel, newItem: LessonModel): Boolean {
      return  oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: LessonModel, newItem: LessonModel): Boolean {
        return  oldItem == newItem
    }
}