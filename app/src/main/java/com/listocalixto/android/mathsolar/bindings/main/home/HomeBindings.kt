package com.listocalixto.android.mathsolar.bindings.main.home

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import com.listocalixto.android.mathsolar.R
import com.listocalixto.android.mathsolar.data.model.Article
import com.listocalixto.android.mathsolar.ui.main.articles.adapter.HomeAdapter
import com.todkars.shimmer.ShimmerRecyclerView

@BindingAdapter("app:articleItems")
fun ShimmerRecyclerView.setArticleItems(items: List<Article>?) {
    items?.let {
        (actualAdapter as HomeAdapter).submitList(it)
    }
}

@BindingAdapter("app:loadArticleImage")
fun ImageView.setArticleImage(url: String?) {
    url?.let {
        load(it) {
            crossfade(600)
            error(R.drawable.ic_error_placeholder)
        }
    }
}

@BindingAdapter("app:applyBookmark")
fun ImageView.isBookmark(item: Article?) {
    item?.let {
        if (it.bookmark) {
            setImageResource(R.drawable.ic_bookmark)
        } else {
            setImageResource(R.drawable.ic_bookmark_border)
        }
    }
}

@BindingAdapter("app:loadingItems")
fun ShimmerRecyclerView.onLoadingStatus(state: Boolean?) {
    state?.let {
        if (it) {
            this.showShimmer()
        } else {
            this.hideShimmer()
        }
    }
}

@BindingAdapter("app:viewed")
fun TextView.isViewed(boolean: Boolean) {
    alpha = if (boolean) {
        0.3f
    } else {
        1.0f
    }
}
