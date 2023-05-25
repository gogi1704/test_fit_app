package com.example.test_fit_app.data.repository.di

import com.example.test_fit_app.data.repository.LessonsRepository
import com.example.test_fit_app.data.repository.LessonsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindLessonsRepository(impl: LessonsRepositoryImpl):LessonsRepository
}