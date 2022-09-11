package com.zhytel.myworkphoto.domain

class GetUrlsListUseCase(
    private val repository: UrlsRepository
) {
    operator fun invoke() = repository.getUrlsList()
}