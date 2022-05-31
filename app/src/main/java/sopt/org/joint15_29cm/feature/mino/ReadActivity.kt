package sopt.org.joint15_29cm.feature.mino

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import sopt.org.joint15_29cm.R
import sopt.org.joint15_29cm.data.remote.ServiceCreator
import sopt.org.joint15_29cm.data.remote.models.ResponseInquiryData
import sopt.org.joint15_29cm.databinding.ActivityReadBinding
import sopt.org.joint15_29cm.feature.zyoung.CreateActivity
import sopt.org.joint15_29cm.feature.zyoung.RequiryData
import sopt.org.joint15_29cm.util.CustomDialog
import sopt.org.joint15_29cm.util.ExpandedAnimation
import sopt.org.joint15_29cm.util.asCallbackFLow

class ReadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReadBinding
    private lateinit var inquiryAdapter: InquiryListAdapter
    private lateinit var diglog: CustomDialog
    private lateinit var getResultText: ActivityResultLauncher<Intent>
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
                inquiryViewModel.inquiry.collect {
                    Log.d("Return!!!", it.body()?.data.toString())
                    inquiryAdapter.submitList(it.body()?.data)
                }
            }
        }
    }

    fun removeItem() {
        inquiryAdapter.removeItem()
    }

    private fun showDialog() {
        diglog = CustomDialog(this)
        diglog.showReadDialog(R.layout.dialog_read)
    }

    private fun initExpandedAnimation(data: ResponseInquiryData, layoutExpand: LinearLayout) {
        if (!data.isExpanded) ExpandedAnimation.expand(layoutExpand)
        else ExpandedAnimation.collapse(layoutExpand)
        data.isExpanded = !data.isExpanded
    }
}
