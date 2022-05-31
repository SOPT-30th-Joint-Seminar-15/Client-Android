package sopt.org.joint15_29cm.data.remote.twenty_nine_cm.models

data class ResponseOrderInfo(
    val status: Int,
    val message: String,
    val data: OrderInfo
) {
    data class OrderInfo(
        val _id : String,
        val userId : String,
        val productName : String,
        val orderDate : String,
        val payMethod : String
    )
}
