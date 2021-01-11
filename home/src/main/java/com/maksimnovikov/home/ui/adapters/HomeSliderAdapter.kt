package com.maksimnovikov.home.ui.adapters

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.maksimnovikov.common.domain.entity.Film
import com.maksimnovikov.common.ui.dividers.customDivider
import com.maksimnovikov.common.ui.extensions.dip
import com.maksimnovikov.common.ui.extensions.onScrollStateChange
import com.maksimnovikov.common.ui.extensions.savedScrollState
import com.maksimnovikov.home.databinding.HomeSliderBinding
import com.maksimnovikov.home.ui.HomeScreenViewItem

fun homeSliderAdapter(onFilmClick: (Film) -> Unit) =
    adapterDelegateViewBinding<HomeScreenViewItem.Slider, HomeScreenViewItem, HomeSliderBinding>(
        { layoutInflater, root -> HomeSliderBinding.inflate(layoutInflater, root, false) }) {
        val mAdapter = ListDelegationAdapter(filmAdapter(onFilmClick))
        with(binding.homeSlider) {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = mAdapter
            customDivider { position, itemCount, outRect, _ ->
                outRect.left = dip(20)
                if (position == itemCount - 1) {
                    outRect.right = dip(20)
                }
            }
            onScrollStateChange { _, newState ->
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    item.layoutManagerState = savedScrollState
                }
            }
        }
        bind { payloads ->
            if (payloads.getOrNull(0) == true) {
                item.layoutManagerState = binding.homeSlider.savedScrollState
            } else {
                mAdapter.items = item.films
                binding.homeSlider.savedScrollState = item.layoutManagerState
            }
        }
    }