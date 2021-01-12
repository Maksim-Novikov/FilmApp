package com.maksimnovikov.search.ui

import androidx.core.view.isVisible
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.maksimnovikov.common.domain.entity.Film
import com.maksimnovikov.common.ui.extensions.applyClickableForeground
import com.maksimnovikov.common.ui.extensions.setImageUrl
import com.maksimnovikov.common.ui.extensions.setTextOrHideView
import com.maksimnovikov.search.databinding.SearchResultItemBinding

fun searchFilmAdapter(onFilmClicked: (Film) -> Unit) =
    adapterDelegateViewBinding<Film, Film, SearchResultItemBinding>(
        { layoutInflater, root -> SearchResultItemBinding.inflate(layoutInflater, root, false) }) {
        itemView.setOnClickListener {
            onFilmClicked(item)
        }
        itemView.applyClickableForeground()
        bind {
            binding.searchResultItemBanner.setImageUrl(item.posterUrlPreview)
            binding.searchResultItemName.text = item.nameRu
            binding.searchResultItemDescription.apply {
                // hide nameEn to prevent double same names
                if (item.nameRu == item.nameEn) {
                    isVisible = false
                } else {
                    setTextOrHideView(item.nameEn)
                }
            }
            binding.searchResultItemCountry.setTextOrHideView(item.country)
            binding.searchResultItemGenres.setTextOrHideView(item.genresString)
            binding.searchResultItemRating.setTextOrHideView(item.rating)
        }
    }


