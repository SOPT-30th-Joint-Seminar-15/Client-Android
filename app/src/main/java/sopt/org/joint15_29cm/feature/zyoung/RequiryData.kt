package sopt.org.joint15_29cm.feature.zyoung

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RequiryData(
    val id: Int,
    val date: String,
    val type: String?,
    val requiryMessage: String,
) : Parcelable
