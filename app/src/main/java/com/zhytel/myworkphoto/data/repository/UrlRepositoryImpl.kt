package com.zhytel.myworkphoto.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zhytel.myworkphoto.data.ApiFactoty
import com.zhytel.myworkphoto.data.pojo.UrlDto
import com.zhytel.myworkphoto.domain.UrlRepository
import java.lang.RuntimeException

class UrlRepositoryImpl : UrlRepository {
    private val imageListLD = MutableLiveData<MutableList<UrlDto>>()
    private val imageList: MutableList<UrlDto> = ArrayList()
//    private val mapper = UrlsMapper()
    private val apiService = ApiFactoty.apiService
     val API_KEY =
        "o-vVNCE59pckIkO6Tjg7JYtU_F5yqBaX-uRdUhcSOcA"


    override fun getUrlList(): LiveData<MutableList<UrlDto>> {
        imageListLD.value = imageList.toList().toMutableList()
        return imageListLD
    }

    override fun getImageUrls(id: String): UrlDto {
        Log.d("getImageUrls", id)
        return imageList.find { it.user.id == id } ?: throw RuntimeException("Element with id $id not found")
    }


    override fun loadData() {
//        val nt = apiService.getImageUrls(API_KEY, "1")
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                it.map { it.urls }
//                imageListLD.value = imageList.toList()
//                Log.d("toListfr", it.toString())
//            },
//                { Log.d("erro", it.toString())}
//            )
    }
}