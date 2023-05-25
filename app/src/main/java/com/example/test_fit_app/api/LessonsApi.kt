package com.example.test_fit_app.api

import retrofit2.http.GET

interface LessonsApi {

    @GET
    fun getAll()
    //schedule/get_v3/?club_id=2
}