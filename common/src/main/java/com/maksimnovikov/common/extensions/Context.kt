package com.maksimnovikov.common.extensions

import android.content.Context
import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun Context.color(@ColorRes colorRes: Int): Int = ContextCompat.getColor(this, colorRes)
fun View.color(@ColorRes colorRes: Int): Int = context.color(colorRes)