package sopt.org.joint15_29cm.feature.mino

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import sopt.org.joint15_29cm.R
import sopt.org.joint15_29cm.databinding.ActivityReadBinding
import sopt.org.joint15_29cm.feature.zyoung.CreateActivity
import sopt.org.joint15_29cm.feature.zyoung.RequiryData
import sopt.org.joint15_29cm.util.CustomDialog
import sopt.org.joint15_29cm.util.ExpandedAnimation

class ReadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReadBinding
    private lateinit var inquiryAdapter: InquiryListAdapter
    private lateinit var diglog: CustomDialog
    private lateinit var getResultText: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBindingView()
        getResultText =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == RESULT_OK) {
                    val data2 = it.data
                    val data = data2?.getParcelableExtra<RequiryData>("data")
                    Log.d("Data!@!!", data.toString())
                    if (data != null) {
                        insertData(data)
                    }
                }
            }
    }

    private fun initBindingView() {
        binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inquiryAdapter = InquiryListAdapter(::initExpandedAnimation, ::showDialog)
        inquiryAdapter.submitList(
            listOf(
                InquiryData(
                    id = 0,
                    date = "2022-05-12",
                    type = "문의하기",
                    inquiryMessage = "안녕하세요",
                    answerMessage = "반가워요"
                ),
                InquiryData(
                    id = 1,
                    date = "2022-05-13",
                    type = "문의하기",
                    inquiryMessage = "안녕하세요",
                    answerMessage = null
                ),
                InquiryData(
                    id = 2,
                    date = "2022-05-14",
                    type = "문의안하기",
                    inquiryMessage = "안녕",
                    answerMessage = "반가워요"
                )
            )
        )
        binding.btnNavCreate.setOnClickListener {
            val intent = Intent(this, CreateActivity::class.java)
            getResultText.launch(intent)
        }
        binding.rvConsulting.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager(this).orientation
            )
        )
        binding.rvConsulting.adapter = inquiryAdapter
    }

    private fun showDialog() {
        diglog = CustomDialog(this)
        diglog.showReadDialog(R.layout.dialog_read)
    }


    private fun insertData(data: RequiryData) {
        val newList = inquiryAdapter.currentList.toMutableList()
        newList.add(
            InquiryData(
                id = 0,
                date = data.date,
                type = data.type,
                inquiryMessage = data.requiryMessage,
                answerMessage = null
            )
        )
        inquiryAdapter.submitList(newList)
    }

    fun removeItem() {
        inquiryAdapter.removeItem()
    }

    private fun initExpandedAnimation(data: InquiryData, layoutExpand: LinearLayout) {
        if (!data.isExpanded) ExpandedAnimation.expand(layoutExpand)
        else ExpandedAnimation.collapse(layoutExpand)
        data.isExpanded = !data.isExpanded
    }
}
