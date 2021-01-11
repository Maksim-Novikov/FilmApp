package com.maksimnovikov.common.ui.extensions

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Context.color(@ColorRes colorRes: Int): Int = ContextCompat.getColor(this, colorRes)
fun View.color(@ColorRes colorRes: Int): Int = context.color(colorRes)

// returns dip(dp) dimension value in pixels
fun Context.dip(value: Int): Int = (value * resources.displayMetrics.density).toInt()
fun Context.dip(value: Float): Float = (value * resources.displayMetrics.density)
fun View.dip(value: Int): Int = context.dip(value)
fun View.dip(value: Float): Int = context.dip(value).toInt()
fun Fragment.dip(value: Int): Int = requireContext().dip(value)
fun Fragment.dip(value: Float): Float = requireContext().dip(value)

fun Context.drawable(@DrawableRes drawableRes: Int): Drawable? =
    ContextCompat.getDrawable(this, drawableRes)

fun View.drawable(@DrawableRes drawableRes: Int): Drawable? = context.drawable(drawableRes)
