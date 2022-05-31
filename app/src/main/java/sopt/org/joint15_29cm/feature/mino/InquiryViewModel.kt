package sopt.org.joint15_29cm.feature.mino

import androidx.lifecycle.*
import kotlinx.coroutines.flow.*
import retrofit2.Response
import sopt.org.joint15_29cm.data.remote.ServiceCreator
import sopt.org.joint15_29cm.data.remote.models.ResponseInquiryData
import sopt.org.joint15_29cm.util.ResponseWrapper

class InquiryViewModel : ViewModel() {
    val inquiry:Flow<Response<ResponseWrapper<List<ResponseInquiryData>>>> = ServiceCreator.getList
}
