package io.github.bbang208.cosmopolitan.data.source

import androidx.lifecycle.LiveData
import io.github.bbang208.cosmopolitan.data.ApiResponse
import io.github.bbang208.cosmopolitan.data.ApiSuccessResponse
import io.github.bbang208.cosmopolitan.data.NetworkBoundResource
import io.github.bbang208.cosmopolitan.data.Resource
import io.github.bbang208.cosmopolitan.data.models.PopularDrinks
import io.github.bbang208.cosmopolitan.data.source.remote.AppApiService
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val appApiService: AppApiService
) {

    fun getPopular(): LiveData<Resource<PopularDrinks>> {
        return object : NetworkBoundResource<PopularDrinks, PopularDrinks>() {
            override suspend fun processResponse(response: ApiSuccessResponse<PopularDrinks>): PopularDrinks {
                return response.body
            }

            override suspend fun createCall(): LiveData<ApiResponse<PopularDrinks>> {
                return appApiService.getPopular()
            }

        }.asLiveData()
    }
}