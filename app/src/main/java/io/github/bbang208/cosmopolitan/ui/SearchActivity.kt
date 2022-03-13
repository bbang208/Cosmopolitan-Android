package io.github.bbang208.cosmopolitan.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import io.github.bbang208.cosmopolitan.R
import io.github.bbang208.cosmopolitan.databinding.ActivitySearchBinding

@AndroidEntryPoint
class SearchActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySearchBinding
    private val searchViewModel by viewModels<SearchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        viewBinding.lifecycleOwner = this
        viewBinding.viewModel = searchViewModel

    }
}