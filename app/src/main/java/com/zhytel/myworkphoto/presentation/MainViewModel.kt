package com.zhytel.myworkphoto.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhytel.myworkphoto.data.ApiFactoty
import com.zhytel.myworkphoto.data.repository.UrlRepositoryImpl
import com.zhytel.myworkphoto.domain.GetUrlsListUseCase
import com.zhytel.myworkphoto.domain.LoadDataUseCase
import com.zhytel.myworkphoto.presentation.adapters.MainAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val apiService = ApiFactoty.apiService

    private val repository = UrlRepositoryImpl()

    private val getUrlsListUseCase = GetUrlsListUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    var urlsList = getUrlsListUseCase()

    private val compositeDisposable = CompositeDisposable()

    private val API_KEY =
        "o-vVNCE59pckIkO6Tjg7JYtU_F5yqBaX-uRdUhcSOcA"


    init {
        viewModelScope.launch {
            loadDataUseCase
        }
    }
    fun loadData(adapter: MainAdapter, page: Int) {
        val nt = apiService.getImageUrls(API_KEY, page.toString())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                adapter.setImage(it.toMutableList())
            },{
                throw RuntimeException(it.message)
            })
        compositeDisposable.add(nt)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}