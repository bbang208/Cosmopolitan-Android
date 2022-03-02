package io.github.bbang208.cosmopolitan.data.source.remote

import androidx.lifecycle.LiveData
import io.github.bbang208.cosmopolitan.BuildConfig
import io.github.bbang208.cosmopolitan.data.ApiResponse
import io.github.bbang208.cosmopolitan.data.models.PopularDrinks
import retrofit2.http.GET

interface AppApiService {

    @GET("/api/json/v2/${BuildConfig.API_KEY}/popular.php")
    fun getPopular(): LiveData<ApiResponse<PopularDrinks>>
}