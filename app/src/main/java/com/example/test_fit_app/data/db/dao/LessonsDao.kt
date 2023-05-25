package com.example.test_fit_app.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.test_fit_app.data.db.entity.LessonEntity

@Dao
interface LessonsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(lessons: List<LessonEntity>)

    @Query("SELECT * FROM EventEntity ORDER BY id DESC")
    suspend fun getPagingData(): PagingSource<Int, LessonEntity>

}