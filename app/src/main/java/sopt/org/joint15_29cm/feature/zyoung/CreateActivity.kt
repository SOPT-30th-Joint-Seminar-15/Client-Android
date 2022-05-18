package sopt.org.joint15_29cm.feature.zyoung

import android.os.Bundle
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
    }

    private fun initDialog() {
//        binding.test.setOnClickListener {
//            val dialog = CustomDialog(this)
//            dialog.show(R.layout.dialog_read)
//        }
    }
}
