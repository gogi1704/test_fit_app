package com.example.test_fit_app.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.test_fit_app.data.model.ListItems

class LessonsDiffUtil: DiffUtil.ItemCallback<ListItems>() {
    override fun areItemsTheSame(oldItem: ListItems, newItem: ListItems): Boolean {
      return  oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ListItems, newItem: ListItems): Boolean {
        return  oldItem == newItem
    }
}