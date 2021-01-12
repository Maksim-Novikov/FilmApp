package com.maksimnovikov.common.ui.extensions

import android.widget.TextView
import androidx.core.view.isVisible

fun TextView.setTextOrHideView(value: String?) {
    if (value.isNullOrBlank()) {
        isVisible = false
    } else {
        text = value
        isVisible = true
    }
}