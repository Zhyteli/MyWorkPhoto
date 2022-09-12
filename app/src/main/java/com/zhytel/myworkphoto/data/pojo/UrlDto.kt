package com.zhytel.myworkphoto.data.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UrlDto(
    @SerializedName("urls")
    @Expose
    val urls: UrlsDto,

    @SerializedName("user")
    @Expose
    val userDto: UserDto

)