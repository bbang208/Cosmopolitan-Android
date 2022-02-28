package io.github.bbang208.cosmopolitan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.bbang208.cosmopolitan.data.models.Repo
import io.github.bbang208.cosmopolitan.data.source.ApiRepository
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    apiRepository: ApiRepository
) : ViewModel() {

}