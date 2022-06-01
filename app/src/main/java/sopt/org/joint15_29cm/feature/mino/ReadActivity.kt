package sopt.org.joint15_29cm.feature.mino

import android.content.Intent
import android.os.Bundle
import android.service.autofill.UserData
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import sopt.org.joint15_29cm.R
import sopt.org.joint15_29cm.data.remote.models.ResponseInquiryData
import sopt.org.joint15_29cm.databinding.ActivityReadBinding
import sopt.org.joint15_29cm.feature.zyoung.CreateActivity
import sopt.org.joint15_29cm.util.CustomDialog
import sopt.org.joint15_29cm.util.ExpandedAnimation

class ReadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReadBinding
    private lateinit var inquiryAdapter: InquiryListAdapter
    private lateinit var diglog: CustomDialog
    private val inquiryViewModel: InquiryViewModel by viewModels<InquiryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBindingView()
        displayInquiryList()
    }

    private fun initBindingView() {
        binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inquiryAdapter = InquiryListAdapter(::initExpandedAnimation, ::showDialog)
        binding.btnNavCreate.setOnClickListener {
            val intent = Intent(this, CreateActivity::class.java)
            startActivity(intent)
        }
        binding.rvConsulting.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager(this).orientation
            )
        )
        binding.rvConsulting.adapter = inquiryAdapter
    }


    private fun displayInquiryList() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                inquiryViewModel.getList.collect {
                    inquiryAdapter.submitList(it)
                }
            }
        }
    }

    suspend fun removeItem() {
        inquiryViewModel.removeItem()
        displayInquiryList()
    }

    private fun showDialog(userItem: ResponseInquiryData) {
        inquiryViewModel.inquiryItemId.value = userItem.inquiryId
        diglog = CustomDialog(this)
        diglog.showReadDialog()
    }

    private fun initExpandedAnimation(data: ResponseInquiryData, layoutExpand: LinearLayout) {
        if (!data.isExpanded) ExpandedAnimation.expand(layoutExpand)
        else ExpandedAnimation.collapse(layoutExpand)
        data.isExpanded = !data.isExpanded
    }
}
