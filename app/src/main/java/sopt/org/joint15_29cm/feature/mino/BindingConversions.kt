package sopt.org.joint15_29cm.feature.mino

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.transform.CircleCropTransformation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object BindingConversions {

    @JvmStatic
    @BindingAdapter("load")
    fun loadImage(view: ImageView, url: String) {
        url.let {
            CoroutineScope(Dispatchers.Main).launch {
                view.load(url) {
                    crossfade(true)
                    transformations(CircleCropTransformation())
                    size(450, 450)
                }
            }
        }
    }
    @JvmStatic
    @BindingAdapter("visible")
    fun setVisibility(view: View, isExpanded:Boolean){
        if(view.visibility == View.VISIBLE){

        }
    }
}
