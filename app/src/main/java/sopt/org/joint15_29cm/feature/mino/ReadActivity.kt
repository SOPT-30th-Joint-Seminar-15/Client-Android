package sopt.org.joint15_29cm.feature.mino

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sopt.org.joint15_29cm.databinding.ActivityReadBinding
import sopt.org.joint15_29cm.feature.zyoung.CreateActivity

class ReadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnReadWrite.setOnClickListener {
            startActivity(Intent(this, CreateActivity::class.java))
        }
    }
}
