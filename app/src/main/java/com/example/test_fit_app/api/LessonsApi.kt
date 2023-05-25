package com.example.test_fit_app.api

import com.example.test_fit_app.data.model.DataModel
import retrofit2.Response
import retrofit2.http.GET

interface LessonsApi {

    @GET("schedule/get_v3/?club_id=2")
   suspend fun getAll():Response<DataModel>


}