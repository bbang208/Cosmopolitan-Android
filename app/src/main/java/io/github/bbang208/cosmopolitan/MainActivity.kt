package io.github.bbang208.cosmopolitan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.google.android.material.transition.MaterialContainerTransform
import dagger.hilt.android.AndroidEntryPoint
import io.github.bbang208.cosmopolitan.data.Status
import io.github.bbang208.cosmopolitan.databinding.ActivityMainBinding
import io.github.bbang208.cosmopolitan.ui.common.TestAdapter
import io.github.bbang208.cosmopolitan.util.EventObserver
import io.github.bbang208.cosmopolitan.util.PushEvent
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var appExecutors: AppExecutors

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewBinding.lifecycleOwner = this
        viewBinding.viewModel = this.viewModel

        val adapter = TestAdapter(appExecutors, this.viewModel)
        viewBinding.popularDrinksRecyclerView.adapter = adapter

        viewModel.clickEvent.observe(this, EventObserver {
            Toast.makeText(this, "name: ${it.strDrink} id: ${it.idDrink}", Toast.LENGTH_LONG).show()
            val intent = DetailActivity.create(this, it.idDrink)
            startActivity(intent)
        })

        viewBinding.searchFloatingButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        viewModel.popularDrinks.observe(this) { res ->
            when (res.status) {
                Status.LOADING -> {}
                Status.SUCCESS -> {
                    val data = res.data?.drinks!!
                    for (item in data)
                        Timber.e("drinks: ${item.strDrink}")
                }
                Status.ERROR -> {
                    Timber.e("ERROR, ${res.responseCode}, ${res.data}, ${res.message}")
                }
            }
        }
    }
}