package io.github.bbang208.cosmopolitan.data.source.remote

import androidx.lifecycle.LiveData
import io.github.bbang208.cosmopolitan.data.ApiResponse
import io.github.bbang208.cosmopolitan.data.models.DateModel
import retrofit2.http.GET

interface AppApiService {

    @GET("/")
    fun getTime(): LiveData<ApiResponse<DateModel>>
}