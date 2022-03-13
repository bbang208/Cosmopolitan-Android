package io.github.bbang208.cosmopolitan.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.bbang208.cosmopolitan.data.source.ApiRepository
import io.github.bbang208.cosmopolitan.data.source.remote.AppApiService
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val apiRepository: ApiRepository
) : ViewModel() {

    private val _drinkID = MutableLiveData<String>()

    val drinkDetail = Transformations.switchMap(_drinkID) { drinkID ->
        apiRepository.getDetail(drinkID)
    }

    fun setDrinkID(drinkID: String) {
        _drinkID.value = drinkID
    }
}