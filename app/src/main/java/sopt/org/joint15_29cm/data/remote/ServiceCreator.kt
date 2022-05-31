package sopt.org.joint15_29cm.data.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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

    val getList: Flow<Response<ResponseWrapper<List<ResponseInquiryData>>>>
        get() = flow { emit(twentyNineService.getInquiryList("628f2a4174995ed500bc18e9")) }

    private fun getGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(Int::class.java, EmptyStringToNumberTypeAdapter())
            .registerTypeAdapter(
                Int::class.javaPrimitiveType,
                EmptyStringToNumberTypeAdapter()
            )
            .registerTypeAdapter(
                Double::class.javaPrimitiveType,
                EmptyStringToNumberTypeAdapter()
            )
            .registerTypeAdapter(Double::class.java, EmptyStringToNumberTypeAdapter())
        return gsonBuilder.create()
    }
}