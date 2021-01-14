package com.maksimnovikov.common.ui

import android.accounts.NetworkErrorException
import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import com.maksimnovikov.common.BuildConfig
import com.maksimnovikov.common.R
import com.maksimnovikov.common.ui.extensions.inflate
import com.maksimnovikov.common.ui.extensions.string
import kotlinx.android.synthetic.main.error_view.view.*
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ErrorView @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(
    context,
    attr,
    defStyleAttr
) {

    private var onRetry: () -> Unit = {}

    init {
        inflate(R.layout.error_view)
        setOnClickListener { }
        errorViewRetry.setOnClickListener { onRetry() }
    }

    fun onRetry(block: () -> Unit) {
        onRetry = block
    }

    fun setError(throwable: Throwable) {
        when (throwable) {
            is UnknownHostException,
            is NetworkErrorException,
            is SocketTimeoutException,
            is SocketException,
            -> {
                setData(
                    title = string(R.string.error_view_absent_network),
                )
            }

            else -> {
                setData(
                    title = string(R.string.error_view_some_error),
                    errorMessage = "${throwable::class.java.simpleName} ${throwable.message}"
                )
            }
        }
    }

    private fun setData(
        title: String,
        errorMessage: CharSequence = "",
    ) {
        errorViewTitle.text = title
        errorViewErrorMessageDesc.isVisible = BuildConfig.DEBUG && errorMessage.isNotBlank()
        errorViewErrorMessageDesc.text = errorMessage
    }
}

