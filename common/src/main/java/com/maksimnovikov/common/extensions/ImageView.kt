package com.maksimnovikov.common.extensions

import android.content.res.ColorStateList
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.core.widget.ImageViewCompat

fun ImageView.setTint(@ColorRes colorRes: Int) {
    ImageViewCompat.setImageTintList(this, ColorStateList.valueOf(color(colorRes)))
}