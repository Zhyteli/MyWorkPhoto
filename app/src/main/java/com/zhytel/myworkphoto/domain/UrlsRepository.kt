package com.zhytel.myworkphoto.domain

import androidx.lifecycle.LiveData

interface UrlsRepository {

    fun getUrlsList(): LiveData<List<Urls>>

    fun getImageUrls(image: String): LiveData<Urls>
}