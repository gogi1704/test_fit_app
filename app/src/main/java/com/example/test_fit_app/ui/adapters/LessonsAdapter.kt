package com.example.test_fit_app.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_fit_app.data.model.LessonModel
import com.example.test_fit_app.databinding.ItemLayoutBinding

class LessonsAdapter() : ListAdapter<LessonModel, LessonsViewHolder>(LessonsDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonsViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LessonsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LessonsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class LessonsViewHolder(private val binding: ItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: LessonModel) {
        with(binding) {
            textStartTraining.text = item.startTime
            textFinishTraining.text = item.endTime
            textTypeTraining.text = item.name
            textName.text = item.coachId
            textLocationTraining.text = item.place
            colorLine.setColorFilter(Color.parseColor(item.color))
        }
    }

}