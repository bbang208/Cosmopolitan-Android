package io.github.bbang208.cosmopolitan.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import io.github.bbang208.cosmopolitan.R
import io.github.bbang208.cosmopolitan.databinding.ActivityDetailBinding

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val viewModel by viewModels<DetailViewModel>()

    private val drinkID: String by lazy { intent.getStringExtra(KEY_DRINK_ID)?:"" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        binding.lifecycleOwner = this
        binding.viewModel = this.viewModel

        if (drinkID.isNotEmpty())
            viewModel.setDrinkID(drinkID)
    }

    companion object {
        private const val KEY_DRINK_ID = "key_drink_id"
        fun create(context: Context, drinkID: String): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(KEY_DRINK_ID, drinkID)

            return intent
        }
    }
}