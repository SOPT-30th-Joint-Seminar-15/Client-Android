package sopt.org.joint15_29cm.data.remote.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseInquiryData(
    val inquiryId: String,
    val createdAt: String,
    val inquiryCategory: String,
    val question: String,
    val answer: String?,
    val isAnswered: Boolean,
    var isExpanded: Boolean = false
) : Parcelable