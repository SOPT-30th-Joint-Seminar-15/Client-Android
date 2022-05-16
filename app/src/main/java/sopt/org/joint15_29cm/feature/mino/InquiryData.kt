package sopt.org.joint15_29cm.feature.mino

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InquiryData(
    val id: Int,
    val date: String,
    val type: String,
    val inquiryMessage: String,
    val inquiryImage1:String?,
    val inquiryImage2:String?,
    val answerMessage: String?
) : Parcelable
