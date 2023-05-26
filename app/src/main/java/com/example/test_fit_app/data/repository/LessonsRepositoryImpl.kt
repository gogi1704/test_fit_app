package com.example.test_fit_app.data.repository

import com.example.test_fit_app.api.LessonsApi
import com.example.test_fit_app.data.model.DataModel
import javax.inject.Inject


class LessonsRepositoryImpl @Inject constructor(
    private val api: LessonsApi,
   // private val dao: LessonsDao
) : LessonsRepository {


//    val pagingData: PagingData<LessonEntity> = dao.getPagingData().insertSeparators(
//        generator = { before, after ->
//            if (before?.date != after?.date) null else after
//        }
//    )


    override suspend fun getAll(): DataModel {
        val response = api.getAll()
        if (response.isSuccessful) {
            return response.body() ?: throw Error()
        } else throw Error()
    }
}