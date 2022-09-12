package com.zhytel.myworkphoto.domain

class LoadDataUseCase(
    private val repository: UrlRepository
) {
    operator fun invoke() = repository.loadData()
}