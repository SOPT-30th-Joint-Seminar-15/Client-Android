package sopt.org.joint15_29cm.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sopt.org.joint15_29cm.data.remote.twenty_nine_cm.TwentyNineService

object ServiceCreator {
    private val baseUrl = "http://15.164.163.246:8000"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val twentyNineService: TwentyNineService = retrofit.create(TwentyNineService::class.java)
}