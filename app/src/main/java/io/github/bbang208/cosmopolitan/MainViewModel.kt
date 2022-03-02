package io.github.bbang208.cosmopolitan

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.bbang208.cosmopolitan.data.models.PopularDrinks
import io.github.bbang208.cosmopolitan.data.source.ApiRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    apiRepository: ApiRepository
) : ViewModel() {

    val popularDrinks = apiRepository.getPopular()

    fun popularDrinksClick(item: PopularDrinks.Drink) {
        Timber.e("clicked@${item.strCategory}")
    }
}