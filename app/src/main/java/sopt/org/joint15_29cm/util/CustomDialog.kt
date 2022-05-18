package sopt.org.joint15_29cm.util

import android.app.Dialog
import android.view.Window
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import sopt.org.joint15_29cm.databinding.DialogCreateBinding
import sopt.org.joint15_29cm.databinding.DialogReadBinding
import sopt.org.joint15_29cm.feature.mino.ReadActivity

class CustomDialog(private val context: AppCompatActivity) {
    private lateinit var binding: DialogCreateBinding
    private lateinit var bindingReadBinding: DialogReadBinding
    private val dialog = Dialog(context)

    fun showCreateDialog(@LayoutRes layout: Int) {
        binding = DialogCreateBinding.inflate(context.layoutInflater)

        dialog.apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(binding.root)
            setCancelable(false)
        }
        binding.tvCreateOk.setOnClickListener {
            dialog.dismiss()
            context.finish()
        }
        dialog.show()
    }

    fun showReadDialog(@LayoutRes layout: Int) {
        bindingReadBinding = DialogReadBinding.inflate(context.layoutInflater)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(bindingReadBinding.root)
        dialog.setCancelable(false)

        bindingReadBinding.tvReadBtnok.setOnClickListener {
            (context as ReadActivity).removeItem()
            dialog.dismiss()
        }
        bindingReadBinding.tvReadBtncancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}
