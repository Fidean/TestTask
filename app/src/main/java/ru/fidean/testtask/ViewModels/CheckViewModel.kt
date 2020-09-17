package ru.fidean.testtask.ViewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.fidean.testtask.RetrofitClient


class CheckViewModel : ViewModel() {

    val Answer = MutableLiveData<Boolean>()

    fun getAnswer() {
        Log.d("Network", "Start getAnswer")
        CoroutineScope(Dispatchers.IO).launch {
            var getAnswer = RetrofitClient.api.getAnswer(1)
            try {
                var answer = getAnswer.await()
                Log.d("Network", "Answer $answer.boolean")
                Answer.postValue(answer.boolean)
            } catch (error: Exception) {
                Log.d("Network", "Problem with getAnswer")
            }
        }
    }

}