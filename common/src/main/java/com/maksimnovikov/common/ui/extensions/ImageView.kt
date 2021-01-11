package com.maksimnovikov.common.ui.extensions

import android.content.res.ColorStateList
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.widget.ImageViewCompat
import com.bumptech.glide.Glide
import com.maksimnovikov.common.R
import timber.log.Timber

fun ImageView.setTint(@ColorRes colorRes: Int) {
    ImageViewCompat.setImageTintList(this, ColorStateList.valueOf(color(colorRes)))
}

fun ImageView.setImageUrl(
    url: String?,
    @DrawableRes placeholder: Int? = R.drawable.bg_placeholder,
    @DrawableRes error: Int? = R.drawable.bg_placeholder,
) {
    if (url.isNullOrBlank()) {
        error?.let { setImageResource(it) }
        return
    }

    try {
        Glide.with(context)
            .load(Uri.parse(url)).apply {
                when {
                    placeholder != null -> {
                        placeholder(placeholder)
                    }
                }
                if (error != null) {
                    error(error)
                }
            }
            .into(this)
    } catch (e: IllegalArgumentException) {
        Timber.e(e)
    }
}
