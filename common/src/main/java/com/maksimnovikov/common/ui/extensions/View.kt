package com.maksimnovikov.common.ui.extensions

import android.os.Build
import android.view.View
import com.maksimnovikov.common.R

/**
 * Use for set ripple to view which has image
 * */
fun View.applyClickableForeground() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        foreground = drawable(R.drawable.ripple_black_on_white)
    }
}
