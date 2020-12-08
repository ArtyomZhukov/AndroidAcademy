package com.zhukovartemvl.androidacademy.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Actor(
    val name: String,
    val imageURL: String
): Parcelable
