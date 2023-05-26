package com.example.test_fit_app.data.db.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.test_fit_app.data.db.entity.LessonEntity

@Dao
interface LessonsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAll(lessons: List<LessonEntity>)
//
//    @Query("SELECT * FROM LessonEntity ORDER BY id DESC")
//     fun getPagingData(): PagingData<LessonEntity>

}