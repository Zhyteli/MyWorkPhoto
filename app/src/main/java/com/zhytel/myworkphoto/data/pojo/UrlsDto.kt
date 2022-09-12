package com.zhytel.myworkphoto.data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UrlsDto(
    @SerializedName("full")
    @Expose
    val full: String,
    @SerializedName("small")
    @Expose
    val small: String,

)

