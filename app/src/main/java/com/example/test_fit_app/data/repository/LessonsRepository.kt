package com.example.test_fit_app.data.repository

import com.example.test_fit_app.data.model.DataModel

interface LessonsRepository {
   suspend fun getAll():DataModel
}