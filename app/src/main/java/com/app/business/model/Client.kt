package com.app.business.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Client(
    var id: String,
    var clientName: String,
    var clientEmail: String,
    var PhoneNum: String) : Parcelable