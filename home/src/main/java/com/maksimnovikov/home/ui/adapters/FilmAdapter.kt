package com.maksimnovikov.home.ui.adapters

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.maksimnovikov.common.domain.entity.Film
import com.maksimnovikov.common.ui.extensions.applyClickableForeground
import com.maksimnovikov.common.ui.extensions.join
import com.maksimnovikov.common.ui.extensions.joinByNewLine
import com.maksimnovikov.common.ui.extensions.setImageUrl
import com.maksimnovikov.home.databinding.HomeFilmItemBinding


fun filmAdapter(onFilmClick: (Film) -> Unit) =
    adapterDelegateViewBinding<Film, Film, HomeFilmItemBinding>(
        { layoutInflater, root -> HomeFilmItemBinding.inflate(layoutInflater, root, false) }) {
        itemView.applyClickableForeground()
        itemView.setOnClickListener {
            onFilmClick(item)
        }
        bind {
            binding.filmItemName.text = item.name joinByNewLine item.year.join(item.genre, ", ")
            binding.filmItemImage.setImageUrl(item.posterUrlPreview)
        }
    }