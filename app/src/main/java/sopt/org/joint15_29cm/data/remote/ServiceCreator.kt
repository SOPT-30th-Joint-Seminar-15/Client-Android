package sopt.org.joint15_29cm.data.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sopt.org.joint15_29cm.data.remote.models.ResponseInquiryData
import sopt.org.joint15_29cm.data.remote.twenty_nine_cm.TwentyNineService
import sopt.org.joint15_29cm.util.ResponseWrapper


object ServiceCreator {
    fun getLog() : OkHttpClient.Builder{
        val clientBuilder : OkHttpClient.Builder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        clientBuilder.addInterceptor(loggingInterceptor)

        return clientBuilder
    }


    private val baseUrl = "http://15.164.163.246:8000/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(getLog().build())
        .build()
    val twentyNineService: TwentyNineService = retrofit.create(TwentyNineService::class.java)

    val getList: Flow<Response<ResponseWrapper<List<ResponseInquiryData>>>>
        get() = flow { emit(twentyNineService.getInquiryList("628f2a4174995ed500bc18e9")) }
}