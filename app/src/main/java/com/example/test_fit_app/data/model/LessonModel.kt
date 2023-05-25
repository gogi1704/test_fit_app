package com.example.test_fit_app.data.model

data class LessonModel(
    val name:String ,
    val description:String ,
    val place:String ,
    val coach_id:String ,
    val startTime:String ,
    val endTime:String ,
    val date:String ,
    val appointment_id:Long,
    val service_id:Long ,
    val available_slots:Long ,
    val commercial:Boolean ,
    val client_recorded:Boolean ,
    val is_cancelled:Boolean ,
    val tab:String ,
    val color:String ,
    val tab_id:Long ,

)
