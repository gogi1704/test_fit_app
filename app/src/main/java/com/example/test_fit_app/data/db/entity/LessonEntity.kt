package com.example.test_fit_app.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LessonEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name: String,
    val description: String,
    val place: String,
    val coach_id: String,
    val startTime: String,
    val endTime: String,
    val date: String,
    val appointmentId: Long,
    val service_id: Long,
    val availableSlots: Long,
    val commercial: Boolean,
    val clientRecorded: Boolean,
    val isCancelled: Boolean,
    val tab: String,
    val color: String,
    val tabId: Long,
    val trainerName: String
)