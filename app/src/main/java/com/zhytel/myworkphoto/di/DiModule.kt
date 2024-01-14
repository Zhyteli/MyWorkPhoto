package com.zhytel.myworkphoto.di

import com.zhytel.myworkphoto.data.ApiFactoty
import com.zhytel.myworkphoto.data.ApiService
import com.zhytel.myworkphoto.data.repository.UrlRepositoryImpl
import com.zhytel.myworkphoto.domain.GetUrlsListUseCase
import com.zhytel.myworkphoto.domain.UrlRepository
import com.zhytel.myworkphoto.presentation.adapters.MainAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class DiModule {

    @Provides
    fun provideUrlRepository(): UrlRepository {
        return UrlRepositoryImpl()
    }

    @Provides
    fun provideGetUrlsListUseCase(urlRepository: UrlRepository): GetUrlsListUseCase {
        return GetUrlsListUseCase(urlRepository)
    }

    @Provides
    fun provideService(): ApiService {
        return ApiFactoty.apiService
    }

    @Provides
    fun provideAdapter(): MainAdapter {
        return MainAdapter()
    }
}