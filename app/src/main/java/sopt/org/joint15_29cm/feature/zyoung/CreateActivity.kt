package sopt.org.joint15_29cm.feature.zyoung

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import sopt.org.joint15_29cm.R
import sopt.org.joint15_29cm.databinding.ActivityCreateBinding
import sopt.org.joint15_29cm.feature.mino.ReadActivity
import sopt.org.joint15_29cm.util.CustomDialog
import java.time.LocalDate

class CreateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateBinding
    private var checkedTitle : String ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDialog()
        initControlRadioButtons()
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


                val dialog = CustomDialog(this)
                dialog.showCreateDialog(R.layout.dialog_create)
                setIntent()
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
                    for (x in 0 until i) {
                        radioButtonList[x].isChecked = false

                    }
                    for (x in i + 1 until radioButtonList.size) {
                        radioButtonList[x].isChecked = false

                    }
                    checkedTitle=radioButtonList[i].text.toString()
                }

            }
    }

    private fun getCurrentDate() : String = LocalDate.now().toString()

    private fun setIntent(){
        val intent= Intent(this, ReadActivity::class.java)

        val data=RequiryData(0, getCurrentDate(), checkedTitle!!, binding.etCreateAskcontent.text.toString(), binding.checkboxCreateCheckemail.isChecked)
        intent.putExtra("data",data)
        setResult(RESULT_OK, intent)
    }
}
