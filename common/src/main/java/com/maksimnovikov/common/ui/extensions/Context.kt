package com.maksimnovikov.common.ui.extensions

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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

fun Context.string(@StringRes stringRes: Int): String = getString(stringRes)
fun Context.string(@StringRes stringRes: Int, vararg args: Any): String =
    getString(stringRes).format(*args)

fun View.string(@StringRes stringRes: Int): String = context.getString(stringRes)
fun View.string(@StringRes stringRes: Int, vararg args: Any): String =
    context.getString(stringRes).format(*args)

fun Context.dimen(@DimenRes resource: Int): Int = resources.getDimensionPixelSize(resource)
fun View.dimen(@DimenRes resource: Int): Int = context.dimen(resource)