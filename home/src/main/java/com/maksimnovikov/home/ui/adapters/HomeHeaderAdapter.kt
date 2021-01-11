package com.maksimnovikov.home.ui.adapters

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.maksimnovikov.home.databinding.HomeHeaderBinding
import com.maksimnovikov.home.ui.HomeScreenViewItem

fun homeHeaderAdapter() =
    adapterDelegateViewBinding<HomeScreenViewItem.Header, HomeScreenViewItem, HomeHeaderBinding>(
        { layoutInflater, root -> HomeHeaderBinding.inflate(layoutInflater, root, false) }) {
        bind {
            binding.homeHeader.text = item.name
        }
    }