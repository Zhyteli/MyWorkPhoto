package com.zhytel.myworkphoto.domain

import androidx.lifecycle.LiveData
import com.zhytel.myworkphoto.data.pojo.UrlDto

interface UrlRepository {

    fun getUrlList(): LiveData<MutableList<UrlDto>>

    fun getImageUrls(id: String): UrlDto

    fun loadData()
}