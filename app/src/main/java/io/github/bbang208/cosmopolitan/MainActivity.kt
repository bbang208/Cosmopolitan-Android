package io.github.bbang208.cosmopolitan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import io.github.bbang208.cosmopolitan.databinding.ActivityMainBinding
import io.github.bbang208.cosmopolitan.ui.common.TestAdapter
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

        PushEvent.getInstance().observe(this) {
            Timber.e("event: $it")
        }

        val listener = { data1: Int, data2: String ->

        }

        PushEvent.getInstance().requestUpdate("asdad", listener)

        PushEvent.getInstance().requestUpdate("test", listener = { data1: Int, data2: String ->

        })
    }
}