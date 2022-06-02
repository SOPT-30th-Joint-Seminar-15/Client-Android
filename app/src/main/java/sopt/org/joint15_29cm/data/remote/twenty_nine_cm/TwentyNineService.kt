package sopt.org.joint15_29cm.data.remote.twenty_nine_cm

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*
import sopt.org.joint15_29cm.data.remote.models.RequestInquiryData
import sopt.org.joint15_29cm.data.remote.models.ResponseCreateInquiryData
import sopt.org.joint15_29cm.data.remote.models.ResponseInquiryData
import sopt.org.joint15_29cm.data.remote.models.ResponseOrderInfo
import sopt.org.joint15_29cm.util.ResponseWrapper

interface TwentyNineService{

    @GET("user/{userId}/inquiry")
     suspend fun getInquiryList(
        @Path("userId") userId: String
    ): Response<ResponseWrapper<List<ResponseInquiryData>>>

    @DELETE("inquiry/{inquiryId}")
    suspend fun removeInquiryItem(
        @Path("inquiryId") inquiryId: String
    ): Response<List<ResponseInquiryData>>
  
    @GET("/order/{orderNum}")
    fun getOrderInfo(@Path("orderNum") orderNum: String): Call<ResponseOrderInfo>

    @Headers("accept: application/json",
        "content-type: application/json")
    @POST("/inquiry/user")
    fun postInquityData(
        @Body body: RequestInquiryData
    ):Call<ResponseCreateInquiryData>
}