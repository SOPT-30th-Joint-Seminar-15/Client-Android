package sopt.org.joint15_29cm.feature.mino

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import sopt.org.joint15_29cm.R
import sopt.org.joint15_29cm.databinding.ActivityReadBinding

class ReadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReadBinding
    private lateinit var inquiryAdapter:InquiryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBindingView()
    }

    private fun initBindingView() {
        binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun showDetail(view: View) {
        view.visibility = when (view.visibility) {
            visible -> gone
            gone -> visible
            else -> visible
        }
    }


    companion object {
        private const val visible = View.VISIBLE
        private const val gone = View.GONE
    }
}
