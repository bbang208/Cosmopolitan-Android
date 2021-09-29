package io.github.bbang208.cleanarchitecture

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.bbang208.cleanarchitecture.data.models.Repo
import io.github.bbang208.cleanarchitecture.data.source.TestRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val testRepository: TestRepository
) : ViewModel() {

    val test = testRepository.getTime()
    val data1 = Repo("asd", "asd2", "junseo", 1000)
    val data2 = Repo("asd1", "asd21", "junseo1", 100330)
    val data3 = Repo("asd2", "asd22", "junseo2", 10100)
    val data4 = Repo("asd3", "asd23", "junseo3", 10200)
    val list = arrayListOf(data1, data2, data3, data4)

    val asd = MutableLiveData<List<Repo>>().apply {
        value = list.toList()
    }

    fun test(item: Repo) {
        list.remove(item)
        asd.value = list.toList()
    }

}