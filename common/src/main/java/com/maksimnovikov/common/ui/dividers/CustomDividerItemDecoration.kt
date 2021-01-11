package com.maksimnovikov.common.ui.dividers

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CustomDividerItemDecoration(
    private val setOffsetToRect: (position: Int, itemCount: Int, outRect: Rect, state: RecyclerView.State) -> Unit
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        setOffsetToRect(position, parent.adapter?.itemCount ?: 0, outRect, state)
    }
}

fun RecyclerView.customDivider(
    setOffsetToRect: (position: Int, itemCount: Int, outRect: Rect, state: RecyclerView.State) -> Unit
): RecyclerView.ItemDecoration = CustomDividerItemDecoration(setOffsetToRect)
    .also { addItemDecoration(it) }
