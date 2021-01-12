package com.maksimnovikov.common.ui.extensions

import android.graphics.Rect
import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.maksimnovikov.common.R

/**
 * Use for set ripple to view which has image
 * */
fun View.applyClickableForeground() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        foreground = drawable(R.drawable.ripple_black_on_white)
    }
}

fun View.isKeyboardOpened(keyboardHeightFactor: Float = 0.15f): Boolean {
    val r = Rect()
    getWindowVisibleDisplayFrame(r)
    val screenHeight = rootView?.height ?: 0
    val bottomInset = screenHeight - (r.bottom - r.top)
    return bottomInset > keyboardHeightFactor * screenHeight
}

fun View.onInsetsChanged(onChange: (insets: WindowInsetsCompat) -> Unit) {
    var lastInsets: WindowInsetsCompat? = null
    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        if (lastInsets == null ||
            lastInsets?.systemWindowInsetTop != insets.systemWindowInsetTop ||
            lastInsets?.systemWindowInsetBottom != insets.systemWindowInsetBottom ||
            lastInsets?.systemWindowInsetRight != insets.systemWindowInsetRight ||
            lastInsets?.systemWindowInsetLeft != insets.systemWindowInsetLeft
        ) {
            onChange(insets)
            lastInsets = insets
        }
        insets
    }
}

var View.bottomMargin: Int
    get() = (layoutParams as? ViewGroup.MarginLayoutParams)?.bottomMargin ?: 0
    set(value) {
        layoutParams = (layoutParams as? ViewGroup.MarginLayoutParams)?.apply {
            bottomMargin = value
        }
    }