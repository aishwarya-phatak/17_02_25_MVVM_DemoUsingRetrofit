package com.bitcode.a17_02_25_mvvm_demousingretrofit.models

import com.google.gson.annotations.SerializedName

data class User(
    var id : Int,
    var email : String,

    @SerializedName("first_name")
    var firstName : String,

    @SerializedName("last_name")
    var lastName : String,

    var avatar : String
)


