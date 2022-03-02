package io.github.bbang208.cosmopolitan.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.skydoves.whatif.whatIfNotNullAs
import io.github.bbang208.cosmopolitan.ui.common.DataBoundListAdapter

object PopularDrinksBinding {

    @JvmStatic
    @BindingAdapter("loadThumbnail")
    fun bindSubmitList(view: ImageView, url: String?) {
        url?.let {
            Glide
                .with(view.context)
                .load(it)
                .centerCrop()
                .into(view)
        }
    }
}