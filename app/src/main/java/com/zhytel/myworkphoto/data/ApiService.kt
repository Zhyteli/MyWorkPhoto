package com.zhytel.myworkphoto.data

import com.zhytel.myworkphoto.data.pojo.UrlDto
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("photos")
    fun getImageUrls(
        @Query(QUERY_PARAM_API_KEY) apiKey: String,
        @Query(QUERY_PARAM_PAGE) page: String
        ):Observable<List<UrlDto>>

    companion object {
        private const val QUERY_PARAM_API_KEY = "client_id"
        private const val QUERY_PARAM_PAGE = "page"
    }
}