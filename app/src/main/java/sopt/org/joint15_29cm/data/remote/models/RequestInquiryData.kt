package sopt.org.joint15_29cm.data.remote.models

import com.google.gson.annotations.SerializedName
import retrofit2.http.Headers

data class RequestInquiryData(
    @SerializedName("userId")
    val userId: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("inquiryCategory")
    val inquiryCategory: String,
    @SerializedName("orderNum")
    val orderNum: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("isSubscribed")
    val isSubscribed: Boolean
)
