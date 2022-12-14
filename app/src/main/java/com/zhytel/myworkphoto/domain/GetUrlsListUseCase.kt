package com.zhytel.myworkphoto.domain

class GetUrlsListUseCase(
    private val repository: UrlRepository
) {
    operator fun invoke() = repository.getUrlList()
}