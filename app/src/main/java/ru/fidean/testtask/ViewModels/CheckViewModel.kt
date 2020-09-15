package ru.fidean.testtask.ViewModels

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.fidean.testtask.R
import ru.fidean.testtask.RetrofitNetwork


class CheckViewModel : ViewModel() {

    val Answer = MutableLiveData<Boolean>()

    fun getAnswer() {
        Log.d("Network", "Start getPost")
        CoroutineScope(Dispatchers.IO).launch {
            var getCall = RetrofitNetwork.api.getCall(1)

            try {
                var answer = getCall.await()
                Log.d("Answer", "Answer $answer.boolean")
                Answer.postValue(answer.boolean)
            } catch (error: Exception) {
                Log.d("Network", "Problem with getPost")
            }
        }
    }

}