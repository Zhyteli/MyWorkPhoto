package com.zhytel.myworkphoto.presentation

import androidx.lifecycle.ViewModel
import com.zhytel.myworkphoto.data.ApiService
import com.zhytel.myworkphoto.domain.GetUrlsListUseCase
import com.zhytel.myworkphoto.presentation.adapters.MainAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getUrlsListUseCase:GetUrlsListUseCase,
    mainAdapter: MainAdapter,
    private val apiService:ApiService
) : ViewModel() {

    var urlsList = getUrlsListUseCase()

    private val compositeDisposable = CompositeDisposable()

    private val API_KEY =
        "o-vVNCE59pckIkO6Tjg7JYtU_F5yqBaX-uRdUhcSOcA"

    val adapter = mainAdapter

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