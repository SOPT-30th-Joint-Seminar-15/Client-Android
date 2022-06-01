package sopt.org.joint15_29cm.util

import android.app.Dialog
import android.content.ContentValues.TAG
import android.util.Log
import android.view.Window
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import sopt.org.joint15_29cm.data.remote.ServiceCreator
import sopt.org.joint15_29cm.databinding.DialogCreateBinding
import sopt.org.joint15_29cm.databinding.DialogCreateaskBinding
import sopt.org.joint15_29cm.databinding.DialogReadBinding
import sopt.org.joint15_29cm.feature.mino.ReadActivity

class CustomDialog(private val context: AppCompatActivity) {
    private lateinit var binding: DialogCreateBinding
    private lateinit var bindingReadBinding: DialogReadBinding
    private lateinit var bindingCreateAskBinding: DialogCreateaskBinding
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

    fun showCreateAskDialog(@LayoutRes layout: Int, text: String) {
        bindingCreateAskBinding = DialogCreateaskBinding.inflate(context.layoutInflater)
        bindingCreateAskBinding.tvCreateAskcontent.text = text
        Log.d(TAG, "CustomDialog - showCreateAskDialog() called text= ${text}")
        dialog.apply {

            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(bindingCreateAskBinding.root)
            setCancelable(false)
        }
        bindingCreateAskBinding.ivCreateAskclose.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }


    fun showReadDialog() {
        bindingReadBinding = DialogReadBinding.inflate(context.layoutInflater)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(bindingReadBinding.root)
        dialog.setCancelable(false)

        bindingReadBinding.tvReadBtnok.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                (context as ReadActivity).removeItem()
            }
            dialog.dismiss()
        }
        bindingReadBinding.tvReadBtncancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}
