package ru.fidean.testtask.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    var Score: MutableLiveData<Int> = MutableLiveData(0)
    var Power: MutableLiveData<Int> = MutableLiveData(1)
    var UpPrise: MutableLiveData<Int> = MutableLiveData(8)
    fun upScore() {
        var score = Score.value
        score = score!! + Power.value!!
        Score.value = score
    }

    fun upPower() {
        var power = Power.value
        var score = Score.value
        var prise = UpPrise.value
        if (score!! >= prise!!) {
            score = score - prise
            power = power!! + 1
            prise = prise * 2
            Score.value= score
            Power.value= power
            UpPrise.value = prise
        }
    }
}