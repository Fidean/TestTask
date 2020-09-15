package ru.fidean.testtask

import android.os.Parcelable
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Call(

    var boolean: Boolean

) : Parcelable
