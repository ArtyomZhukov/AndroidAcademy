package com.zhukovartemvl.androidacademy.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Actor(
    val name: String,
    val imageURL: String
): Parcelable