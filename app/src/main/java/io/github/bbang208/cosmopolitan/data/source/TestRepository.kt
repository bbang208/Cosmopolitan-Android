package io.github.bbang208.cosmopolitan.data.source

import androidx.lifecycle.LiveData
import io.github.bbang208.cosmopolitan.data.ApiResponse
import io.github.bbang208.cosmopolitan.data.ApiSuccessResponse
import io.github.bbang208.cosmopolitan.data.NetworkBoundResource
import io.github.bbang208.cosmopolitan.data.Resource
import io.github.bbang208.cosmopolitan.data.models.DateModel
import io.github.bbang208.cosmopolitan.data.source.remote.TestApiService
import javax.inject.Inject

class TestRepository @Inject constructor(
    private val testApiService: TestApiService
) {

    fun getTime(): LiveData<Resource<DateModel>> {
        return object : NetworkBoundResource<DateModel, DateModel>() {
            override suspend fun processResponse(response: ApiSuccessResponse<DateModel>): DateModel {
                return response.body
            }

            override suspend fun createCall(): LiveData<ApiResponse<DateModel>> {
                return testApiService.getTime()
            }

        }.asLiveData()
    }
}