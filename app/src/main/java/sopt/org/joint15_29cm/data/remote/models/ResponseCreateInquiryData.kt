package sopt.org.joint15_29cm.data.remote.models

data class ResponseCreateInquiryData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: InquiryId

){
    data class InquiryId(
        val _id: String
    )
}
