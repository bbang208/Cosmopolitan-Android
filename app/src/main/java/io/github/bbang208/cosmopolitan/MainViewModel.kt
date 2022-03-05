package io.github.bbang208.cosmopolitan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.bbang208.cosmopolitan.data.models.PopularDrinks
import io.github.bbang208.cosmopolitan.data.source.ApiRepository
import io.github.bbang208.cosmopolitan.util.Event
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    apiRepository: ApiRepository
) : ViewModel() {

    val popularDrinks = apiRepository.getPopular()

    private val _clickEvent = MutableLiveData<Event<PopularDrinks.Drink>>()
    val clickEvent: LiveData<Event<PopularDrinks.Drink>> = _clickEvent

    fun popularDrinksClick(item: PopularDrinks.Drink) {
        Timber.e("clicked@${item.strCategory}")
        _clickEvent.value = Event(item)
    }
}