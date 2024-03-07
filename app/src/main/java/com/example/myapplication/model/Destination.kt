package com.example.myapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Destination(
    val name: String,
    val description: String,
    val photo: String,
    val address: String,
    val open_hours: String
): Parcelable
