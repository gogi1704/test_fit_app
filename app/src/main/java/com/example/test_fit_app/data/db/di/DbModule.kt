package com.example.test_fit_app.data.db.di

import android.content.Context
import androidx.room.Room
import com.example.test_fit_app.data.db.AppDb
import com.example.test_fit_app.data.db.dao.LessonsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DbModule {

    companion object {
        private const val APP_DB_NAME = "APP_DB"
    }

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): AppDb {
        return Room.databaseBuilder(context, AppDb::class.java, APP_DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideLessonsDao(appDb: AppDb): LessonsDao = appDb.lessonsDao()

}