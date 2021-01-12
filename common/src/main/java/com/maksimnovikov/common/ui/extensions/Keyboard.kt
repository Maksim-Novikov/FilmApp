package com.maksimnovikov.common.ui.extensions

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

/** Returns the InputMethodManager instance. **/
val Context.inputMethodManager
    get() = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

fun Context.showKeyboard() {
    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}

fun Context.hideKeyboard(view: View) {
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.showKeyboard(view: View) {
    inputMethodManager.showSoftInput(view, 0)
}

fun View.hideKeyboard() = context.hideKeyboard(this)

fun Fragment.hideKeyboard() = view?.hideKeyboard()
