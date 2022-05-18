package sopt.org.joint15_29cm.util

import android.app.Dialog
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import sopt.org.joint15_29cm.databinding.DialogCreateBinding

class CustomDialog(private val context: AppCompatActivity) {
    private lateinit var binding: DialogCreateBinding
    private val dialog = Dialog(context)

    fun showCreate() {
        binding = DialogCreateBinding.inflate(context.layoutInflater)

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(binding.root)
        dialog.setCancelable(false)

        binding.tvCreateOk.setOnClickListener {
            dialog.dismiss()
            context.finish()
        }
        dialog.show()
    }

    fun showDelete() {
    }
}
