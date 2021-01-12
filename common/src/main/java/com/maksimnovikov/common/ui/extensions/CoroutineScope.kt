package com.maksimnovikov.common.ui.extensions

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber


fun CoroutineScope.launchWithErrorHandler(
    onError: (Throwable) -> Unit = { _ -> },
    block: suspend () -> Unit,
): Job = launch(CoroutineExceptionHandler { _, throwable ->
    Timber.e(throwable)
    onError(throwable)
}) {
    block()
}