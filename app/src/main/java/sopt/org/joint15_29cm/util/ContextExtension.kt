package sopt.org.joint15_29cm.util

import android.content.Context
import android.util.Log
import android.widget.Toast
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.roundToInt

fun Context.shortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.dpToPixel(dp: Int): Int =
    (dp * resources.displayMetrics.density).roundToInt()

fun <ResponseType> Call<ResponseType>.enqueueUtil(
    onSuccess: (ResponseType) -> Unit,
    onError: ((stateCode: Int) -> Unit)? = null
) {
    this.enqueue(object : Callback<ResponseType> {
        override fun onResponse(call: Call<ResponseType>, response: Response<ResponseType>) {
            if (response.isSuccessful) {
                onSuccess.invoke(response.body() ?: return)
            } else {
                onError?.invoke(response.code())
            }
        }

        override fun onFailure(call: Call<ResponseType>, t: Throwable) {
            Log.d("NetworkTest", "error:$t")
        }
    })
}
@ExperimentalCoroutinesApi
fun <T> Call<T>.asCallbackFLow() = callbackFlow<T> {
    enqueue(object : Callback<T> {
        // 응답을 받은경우의 호출
        override fun onResponse(call: Call<T>, response: Response<T>) {

            if (response.isSuccessful) {
                response.body()?.let { trySend(it).isSuccess } ?: close(Error())
            } else {
                close(Error("${response.code()} + ${response.errorBody()}"))
            }
        }

        //호출이 실패한 경우
        override fun onFailure(call: Call<T>, throwable: Throwable) {
            close(throwable)
        }
    })

    awaitClose() //close가 호출될때까지 기다립니다.
}