package sopt.org.joint15_29cm.feature.zyoung

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sopt.org.joint15_29cm.R
import sopt.org.joint15_29cm.data.remote.ServiceCreator
import sopt.org.joint15_29cm.data.remote.models.RequestInquiryData
import sopt.org.joint15_29cm.data.remote.models.ResponseCreateInquiryData
import sopt.org.joint15_29cm.data.remote.models.ResponseOrderInfo
import sopt.org.joint15_29cm.databinding.ActivityCreateBinding
import sopt.org.joint15_29cm.feature.mino.ReadActivity
import sopt.org.joint15_29cm.util.CustomDialog
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class CreateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateBinding
    private var checkedTitle : String ?= null
    private var nowTypeNum: Int?=null
    private var prevTypeNum: Int ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDialog()
        initControlRadioButtons()
        orderNumClicked()

    }

    private fun initDialog() {
        binding.btnCreateRegister.setOnClickListener {
            if(checkedTitle==null){
                val dialog = CustomDialog(this)
                dialog.showCreateAskDialog(R.layout.dialog_createask, getString(R.string.create_optionmsg))
                return@setOnClickListener
            } //옵션을 선택하지 않은 경우
            if(binding.etCreateAsktitle.text.isEmpty()){
                val dialog = CustomDialog(this)
                dialog.showCreateAskDialog(R.layout.dialog_createask, getString(R.string.create_titlemsg))
                return@setOnClickListener
            } //제목을 입력하지 않은 경우
            if(binding.etCreateAskcontent.text.isEmpty()){
                val dialog = CustomDialog(this)
                dialog.showCreateAskDialog(R.layout.dialog_createask, getString(R.string.create_contentmsg))
                return@setOnClickListener
            } //내용을 입력하지 않은 경우

                postInquiry()
                val dialog = CustomDialog(this)
                dialog.showCreateDialog(R.layout.dialog_create)

        }
    }

    private fun initControlRadioButtons() {
        val radioButtonList = listOf(
            binding.radiobuttonCreateDelivery,
            binding.radiobuttonCreateOrder,
            binding.radiobuttonCreateCancel,
            binding.radiobuttonCreateRefund,
            binding.radiobuttonCreateReturn,
            binding.radiobuttonCreateExchange,
            binding.radiobuttonCreateGift,
            binding.radiobuttonCreateDeposit,
            binding.radiobuttonCreateChosen,
            binding.radiobuttonCreateCoupon,
            binding.radiobuttonCreateEtc,
            binding.radiobuttonCreateItem,
            binding.radiobuttonCreateDocument,
            binding.radiobuttonCreateSystem,
            binding.radiobuttonCreateUserinfo,
            binding.radiobuttonCreateUserrule,
            binding.radiobuttonCreatePurchaseinfo
        )


        for (i in radioButtonList.indices)
            radioButtonList[i].setOnCheckedChangeListener { _, isChecked ->
                if (radioButtonList[i].isChecked) {

                    if (i in 0..7)
                        binding.constraintlayoutCreateOrderinfo.visibility = View.VISIBLE
                    else
                        binding.constraintlayoutCreateOrderinfo.visibility = View.GONE
                    //하나가 체크되면 나머지 다 체크 풀기
                    nowTypeNum=i

                    if(prevTypeNum!=null && nowTypeNum!=null)
                        radioButtonList[prevTypeNum!!].isChecked=false

                    checkedTitle=radioButtonList[i].text.toString()
                    prevTypeNum=nowTypeNum
                }
            }
    }


    private fun postInquiry(){
        val requestInquiryData = RequestInquiryData(
            userId="628eef9e74995ed500bc18c7",
        email=binding.tvCreateUseremail.text.toString(),
       inquiryCategory=checkedTitle!!,
         orderNum=binding.etCreateOrdernumber.text.toString().let {
             "6290492b59c4d04df8dab4ae"
         },
        title=binding.etCreateAsktitle.text.toString(),
         content=binding.etCreateAskcontent.text.toString(),
        isSubscribed=binding.checkboxCreateCheckemail.isChecked
        )

        Log.d(TAG,"CreateActivity - onResponse() called request =$requestInquiryData")

        val call:Call<ResponseCreateInquiryData> = ServiceCreator.twentyNineService.postInquityData(requestInquiryData)
        call.enqueue(object: Callback<ResponseCreateInquiryData>{
            override fun onResponse(
                call: Call<ResponseCreateInquiryData>,
                response: Response<ResponseCreateInquiryData>
            ) {
                if(response.isSuccessful){

                    setIntent()
                }
            }

            override fun onFailure(call: Call<ResponseCreateInquiryData>, t: Throwable) {
                Log.d(TAG,"CreateActivity - onFailure() called t:$t")
            }

        })

    }

    private fun setIntent(){
        startActivity(Intent(this, ReadActivity::class.java))
    }

    private fun orderNumClicked(){
        binding.buttonCreateOrdernumber.setOnClickListener {
            //Log.d(TAG,"CreateActivity - orderNumClicked() called")
            getRemoteOrder()
        }
    }

    private fun getRemoteOrder(){
        //Log.d(TAG,"CreateActivity - getRemoteOrder() called")
        val call : Call<ResponseOrderInfo> = ServiceCreator.twentyNineService.getOrderInfo("629047fd59c4d04df8dab4aa")
        call.enqueue(object : Callback<ResponseOrderInfo>{
            override fun onResponse(
                call: Call<ResponseOrderInfo>,
                response: Response<ResponseOrderInfo>
            ) {
               if(response.isSuccessful){
                   val data= response.body()!!.data[0]
                   binding.etCreateOrdernumber.setText(data._id)
                   binding.tvCreateOrderitemname.text=data.productName
                   binding.tvCreateOrderitemdate.text=data.orderDate.substring(0,10)
                   binding.tvCreateOrderpurchasemethod.text=data.payMethod
               }

            }

            override fun onFailure(call: Call<ResponseOrderInfo>, t: Throwable) {
                Log.d(TAG,"CreateActivity - onFailure() called t=$t")
            }

        })
    }


}
