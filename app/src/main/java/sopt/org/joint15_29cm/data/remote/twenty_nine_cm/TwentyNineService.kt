package sopt.org.joint15_29cm.data.remote.twenty_nine_cm

import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import sopt.org.joint15_29cm.data.remote.models.ResponseInquiryData
import sopt.org.joint15_29cm.data.remote.twenty_nine_cm.models.ResponseOrderInfo
import sopt.org.joint15_29cm.util.ResponseWrapper

interface TwentyNineService {

    @GET("user/{userId}/inquiry")
    suspend fun getInquiryList(
        @Path("userId") userId: String
    ): Response<ResponseWrapper<List<ResponseInquiryData>>>

    @DELETE("inquiry/{inquiryId}")
    suspend fun removeInquiryItem(
        @Path("inquiryId") inquiryId: String
    ): Response<ResponseWrapper<Unit>>

    @GET("/order/{orderNum}")
    fun getOrderInfo(@Path("orderNum") orderNum: String): Call<ResponseOrderInfo>
}