package com.bitcode.a17_02_25_mvvm_demousingretrofit.models

import com.google.gson.annotations.SerializedName

data class UserResponse(
    var page : Int,

    @SerializedName("per_page")
    var perPage : Int,

    var total : Int,

    @SerializedName("total_pages")
    var totalPages : Int,

    @SerializedName("data")
    var users : ArrayList<User>,

    var support : Support
)

