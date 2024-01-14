package com.zhytel.myworkphoto.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zhytel.myworkphoto.data.ApiFactoty
import com.zhytel.myworkphoto.data.pojo.UrlDto
import com.zhytel.myworkphoto.domain.UrlRepository

class UrlRepositoryImpl : UrlRepository {

    private val imageListLD = MutableLiveData<MutableList<UrlDto>>()
    private val imageList: MutableList<UrlDto> = ArrayList()


    override fun getUrlList(): LiveData<MutableList<UrlDto>> {
        imageListLD.value = imageList.toList().toMutableList()
        return imageListLD
    }

    override fun getImageUrls(id: String): UrlDto {
        return imageList.find { it.userDto.id == id }
            ?: throw RuntimeException("Element with id $id not found")
    }
}