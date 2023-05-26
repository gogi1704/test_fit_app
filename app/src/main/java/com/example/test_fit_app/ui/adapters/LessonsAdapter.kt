package com.example.test_fit_app.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_fit_app.data.model.*
import com.example.test_fit_app.databinding.DateItemLayoutBinding
import com.example.test_fit_app.databinding.ItemLayoutBinding

class LessonsAdapter() : ListAdapter<ListItems, RecyclerView.ViewHolder>(LessonsDiffUtil()) {

    private val dateNum = 0
    private val lessonNum = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            dateNum -> DateViewHolder(DateItemLayoutBinding.inflate(layoutInflater, parent, false))
            lessonNum -> LessonsViewHolder(ItemLayoutBinding.inflate(layoutInflater, parent, false))
            else -> throw Error()
        }

//        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return LessonsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LessonsViewHolder -> holder.bind(getItem(position) as LessonItem)
            is DateViewHolder -> holder.bind(getItem(position) as DateItem)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DateItem -> dateNum
            is LessonItem -> lessonNum
            else -> throw Error()
        }
    }


}

class LessonsViewHolder(private val binding: ItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: LessonItem) {
        with(binding) {
            textLocationTraining.isSelected = true
            textStartTraining.text = item.lessonModel.startTime
            textFinishTraining.text = item.lessonModel.endTime
            textTypeTraining.text = item.lessonModel.name
            textName.text = item.lessonModel.trainerName
            textLocationTraining.text = item.lessonModel.place
            colorLine.setColorFilter(Color.parseColor(item.lessonModel.color))
        }
    }

}

class DateViewHolder(private val binding: DateItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: DateItem) {
        with(binding) {
            date.text = item.date
        }
    }

}