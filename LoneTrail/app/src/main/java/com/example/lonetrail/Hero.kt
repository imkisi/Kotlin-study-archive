package com.example.lonetrail

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    val name: String,
    val photo: Int
): Parcelable
