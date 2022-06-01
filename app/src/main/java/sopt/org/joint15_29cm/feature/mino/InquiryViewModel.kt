package sopt.org.joint15_29cm.feature.mino

import android.service.autofill.UserData
import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import sopt.org.joint15_29cm.data.remote.ServiceCreator
import sopt.org.joint15_29cm.data.remote.models.ResponseInquiryData
import sopt.org.joint15_29cm.util.ResponseWrapper

class InquiryViewModel : ViewModel() {
    //val inquiry: Flow<Response<ResponseWrapper<List<ResponseInquiryData>>>?> = ServiceCreator.getList
    val getList: Flow<List<ResponseInquiryData>> = ServiceCreator.getList()
    val inquiryItemId = MutableLiveData<String>()

    suspend fun removeItem() = withContext(Dispatchers.IO) {
        ServiceCreator.twentyNineService.removeInquiryItem(inquiryItemId.value.toString())
    }


}
