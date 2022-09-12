package com.zhytel.myworkphoto.data.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UrlDto(
    @SerializedName("urls")
    @Expose
    val urls: UrlsDto,

    @SerializedName("user")
    @Expose
    val user: User

)