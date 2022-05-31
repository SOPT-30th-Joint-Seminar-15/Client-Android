package sopt.org.joint15_29cm.data.remote.twenty_nine_cm.models

import java.util.*

data class ResponseOrderInfo(
    val status: Int,
    val message: String,
    val success : Boolean,
    val data: List<OrderInfo>
) {
    data class OrderInfo(
        val _id : String,
        val userId : String,
        val productName : String,
        val orderDate : Date,
        val payMethod : String
    )
}