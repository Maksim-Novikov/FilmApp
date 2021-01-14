package com.maksimnovikov.common.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.maksimnovikov.common.R
import com.maksimnovikov.common.ui.extensions.inflate

class LoadingIndicatorView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(
    context,
    attr,
    defStyleAttr
) {

    init {
        inflate(R.layout.loading_indicator_view)
        // prevent click propagation while content is loading
        setOnClickListener { }
    }
}