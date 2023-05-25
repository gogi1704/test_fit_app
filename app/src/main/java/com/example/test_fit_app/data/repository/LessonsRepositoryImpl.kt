package com.example.test_fit_app.data.repository

import com.example.test_fit_app.api.LessonsApi
import com.example.test_fit_app.data.model.DataModel
import javax.inject.Inject


class LessonsRepositoryImpl @Inject constructor(private val api: LessonsApi) : LessonsRepository {


    override suspend fun getAll(): DataModel {
        val response = api.getAll()
        if (response.isSuccessful) {
            return response.body() ?: throw Error()
        } else throw Error()
    }
}