package sopt.org.joint15_29cm.data.remote

import android.util.Log
import coil.request.SuccessResult
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sopt.org.joint15_29cm.data.remote.models.ResponseInquiryData
import sopt.org.joint15_29cm.data.remote.twenty_nine_cm.TwentyNineService
import sopt.org.joint15_29cm.util.ResponseWrapper


object ServiceCreator {
    private val baseUrl = "http://15.164.163.246:8000/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val twentyNineService: TwentyNineService = retrofit.create(TwentyNineService::class.java)

    fun getList(): Flow<List<ResponseInquiryData>> = flow {
        twentyNineService.getInquiryList("628f2a4174995ed500bc18e9").body()?.data?.let { emit(it) }
    }
}