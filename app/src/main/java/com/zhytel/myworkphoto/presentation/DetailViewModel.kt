package com.zhytel.myworkphoto.presentation

import androidx.lifecycle.ViewModel
import com.zhytel.myworkphoto.data.repository.UrlRepositoryImpl
import com.zhytel.myworkphoto.domain.GetImageUrlsUseCase
import com.zhytel.myworkphoto.domain.GetUrlsListUseCase

class DetailViewModel: ViewModel() {

    private val repository = UrlRepositoryImpl()
    private val getImageUrlsUseCase = GetImageUrlsUseCase(repository)
    private val getUrlsListUseCase = GetUrlsListUseCase(repository)

    fun getImageUrl(id: String?) = id?.let { getImageUrlsUseCase.invoke(it) }
    var urlsList = getUrlsListUseCase()

}