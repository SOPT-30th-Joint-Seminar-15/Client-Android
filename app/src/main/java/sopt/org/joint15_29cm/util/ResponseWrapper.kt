package sopt.org.joint15_29cm.util

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class ResponseWrapper<T>(
    val status: Int,
    val message: String,
    val success: Boolean,
    val data: @RawValue T? = null
) : Parcelable