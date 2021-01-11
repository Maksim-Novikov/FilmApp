package com.maksimnovikov.common.ui.extensions

import android.os.Parcelable
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.onScrollStateChange(block: (recyclerView: RecyclerView, newState: Int) -> Unit) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            block(recyclerView, newState)
        }
    })
}

var RecyclerView.savedScrollState: Parcelable?
    get() = layoutManager?.onSaveInstanceState()
    set(value) {
        layoutManager?.onRestoreInstanceState(value)
    }