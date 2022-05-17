package sopt.org.joint15_29cm.feature.mino

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import sopt.org.joint15_29cm.R
import sopt.org.joint15_29cm.databinding.ActivityReadBinding
import sopt.org.joint15_29cm.util.ExpandedAnimation

class ReadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReadBinding
    private lateinit var inquiryAdapter: InquiryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBindingView()
    }

    private fun initBindingView() {
        binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inquiryAdapter = InquiryListAdapter(::initExpandedAnimation)
        inquiryAdapter.submitList(
            listOf(
                InquiryData(0, "2022-05-12", "문의하기", "안녕하세요", "", "", "반가워요"),
                InquiryData(1, "2022-05-13", "하기", "안녕하", "", "", "반가워요"),
                InquiryData(2, "2022-05-14", "문하기", "안녕", "", "", "반가워요")
            )
        )
        binding.rvConsulting.adapter = inquiryAdapter
    }

    private fun initExpandedAnimation(data: InquiryData, layoutExpand: LinearLayout) {
        if (!data.isExpanded) ExpandedAnimation.expand(layoutExpand)
        else ExpandedAnimation.collapse(layoutExpand)
        data.isExpanded = !data.isExpanded
    }

}
