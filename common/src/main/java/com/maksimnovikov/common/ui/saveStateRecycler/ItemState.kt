package com.maksimnovikov.common.ui.saveStateRecycler

import android.os.Bundle

interface ItemState {

    fun save(): Bundle = Bundle()
    fun restore(state: Bundle): Boolean = false
}