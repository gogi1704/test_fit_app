package com.example.test_fit_app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.test_fit_app.data.db.dao.LessonsDao
import com.example.test_fit_app.data.db.entity.LessonEntity

@Database(entities = [LessonEntity::class], version = 1)
abstract class AppDb:RoomDatabase() {

    abstract fun lessonsDao():LessonsDao

}