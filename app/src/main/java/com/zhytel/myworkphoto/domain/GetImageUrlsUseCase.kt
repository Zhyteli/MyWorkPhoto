package com.zhytel.myworkphoto.domain

class GetImageUrlsUseCase(
    private val repository: UrlRepository
) {
    operator fun invoke(id: String) = repository.getImageUrls(id)
}