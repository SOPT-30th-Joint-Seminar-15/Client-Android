package sopt.org.joint15_29cm.feature.mino

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class InquiryViewModel : ViewModel() {
    private val inquiryList = MutableLiveData<List<InquiryData>>()

    fun getInquiryList(): LiveData<List<InquiryData>> = inquiryList
    fun setInquiryList(data: List<InquiryData>) {
        inquiryList.value = data
    }
}