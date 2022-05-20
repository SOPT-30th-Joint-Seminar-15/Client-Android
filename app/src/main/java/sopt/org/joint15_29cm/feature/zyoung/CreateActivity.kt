package sopt.org.joint15_29cm.feature.zyoung

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import sopt.org.joint15_29cm.R
import sopt.org.joint15_29cm.databinding.ActivityCreateBinding
import sopt.org.joint15_29cm.util.CustomDialog

class CreateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDialog()
        initControlRadioButtons()
    }

    private fun initDialog() {
        binding.btnCreateRegister.setOnClickListener {

            if(binding.etCreateAsktitle.text.isNotEmpty() && binding.etCreateAskcontent.text.isNotEmpty()){

                val dialog = CustomDialog(this)
                dialog.showCreateDialog(R.layout.dialog_create)

            }


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


        for (i in 0 until radioButtonList.size)
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
                }

            }
    }

    private fun setIntent(){

    }
}
