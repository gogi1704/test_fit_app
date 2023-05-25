package com.example.test_fit_app.api.di

import com.example.test_fit_app.BuildConfig
import com.example.test_fit_app.api.LessonsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module

class ApiModule {

    companion object{
        private const val BASE_URL = "https://olimpia.fitnesskit-admin.ru/"
    }

    @Singleton
    @Provides
    fun provideLogging():HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        if (BuildConfig.DEBUG){
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideOkhttp(loggingInterceptor: HttpLoggingInterceptor):OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(30 , TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .baseUrl(BASE_URL)
        .build()

    @Singleton
    @Provides
    fun provideLessonsApi(retrofit: Retrofit):LessonsApi = retrofit.create()

}