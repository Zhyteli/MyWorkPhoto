package com.zhytel.myworkphoto.domain

class GetImageUrlsUseCase(
    private val repository: UrlsRepository
) {
    operator fun invoke(image: String) = repository.getImageUrls(image)
}