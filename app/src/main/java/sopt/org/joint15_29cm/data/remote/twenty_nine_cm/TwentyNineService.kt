package sopt.org.joint15_29cm.data.remote.twenty_nine_cm

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import sopt.org.joint15_29cm.data.remote.twenty_nine_cm.models.ResponseOrderInfo

interface TwentyNineService {
    @GET("/order/{orderNum}")
    fun getOrderInfo(@Path("orderNum") orderNum: String): Call<ResponseOrderInfo>
}