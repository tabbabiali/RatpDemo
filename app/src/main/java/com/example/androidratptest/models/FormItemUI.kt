package com.example.androidratptest.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FormItemUI(
    var int1: Int? = 0,
    var int2: Int? = 0,
    var limit: Int? = 0,
    var str1: String? = "",
    var str2: String? = ""
) : Parcelable