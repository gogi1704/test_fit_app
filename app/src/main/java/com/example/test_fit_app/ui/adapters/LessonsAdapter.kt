package com.example.test_fit_app.ui.adapters

import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.test_fit_app.data.model.*
import com.example.test_fit_app.databinding.DateItemLayoutBinding
import com.example.test_fit_app.databinding.LessonItemLayoutBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.N)

class LessonsAdapter : ListAdapter<ListItems, RecyclerView.ViewHolder>(LessonsDiffUtil()) {

    private val dateNum = 0
    private val lessonNum = 1

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            dateNum -> DateViewHolder(DateItemLayoutBinding.inflate(layoutInflater, parent, false))
            lessonNum -> LessonsViewHolder(LessonItemLayoutBinding.inflate(layoutInflater, parent, false))
            else -> throw Error()
        }

    }

    @RequiresApi(Build.VERSION_CODES.O)
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

class LessonsViewHolder(private val binding: LessonItemLayoutBinding) :
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
    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(item: DateItem) {
        val dateParse = LocalDate.parse(item.date, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        val day = "${
            dateParse.dayOfWeek.getDisplayName(
                TextStyle.FULL,
                Locale("ru", "RU")
            )
        } , ${dateParse.dayOfMonth} ${dateParse.month.getDisplayName(TextStyle.FULL ,Locale("ru", "RU") )}"

        with(binding) {
            date.text = day
        }
    }

}