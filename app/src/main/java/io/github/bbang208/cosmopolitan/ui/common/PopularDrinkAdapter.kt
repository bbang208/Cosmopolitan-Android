package io.github.bbang208.cosmopolitan.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import io.github.bbang208.cosmopolitan.AppExecutors
import io.github.bbang208.cosmopolitan.MainViewModel
import io.github.bbang208.cosmopolitan.R
import io.github.bbang208.cosmopolitan.data.models.PopularDrinks
import io.github.bbang208.cosmopolitan.databinding.ItemPopularBinding

class PopularDrinkAdapter(
    appExecutors: AppExecutors,
    private val viewModel: MainViewModel
) : DataBoundListAdapter<PopularDrinks.Drink, ItemPopularBinding>(
    appExecutors = appExecutors,
    diffCallback = object : DiffUtil.ItemCallback<PopularDrinks.Drink>() {
        override fun areItemsTheSame(
            oldItem: PopularDrinks.Drink,
            newItem: PopularDrinks.Drink
        ): Boolean {
            return oldItem.idDrink == newItem.idDrink
                    && oldItem.idDrink == newItem.idDrink
        }

        override fun areContentsTheSame(
            oldItem: PopularDrinks.Drink,
            newItem: PopularDrinks.Drink
        ): Boolean {
            return oldItem.idDrink == newItem.idDrink
                    && oldItem.idDrink == newItem.idDrink
        }
    }
) {
    override fun createBinding(parent: ViewGroup): ItemPopularBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_popular,
            parent,
            false
        )
    }

    override fun bind(binding: ItemPopularBinding, item: PopularDrinks.Drink) {
        binding.item = item
        binding.viewModel = viewModel
    }

}