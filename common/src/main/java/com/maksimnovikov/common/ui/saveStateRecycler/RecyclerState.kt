package com.maksimnovikov.common.ui.saveStateRecycler

import android.os.Bundle
import android.os.Parcelable

interface RecyclerState : ItemState {

    var layoutManagerState: Parcelable?
}

class RecyclerStateImpl : RecyclerState {

    override var layoutManagerState: Parcelable? = null

    override fun save(): Bundle = Bundle().apply {
        putParcelable(STATE_KEY, layoutManagerState)
    }

    override fun restore(state: Bundle): Boolean = state
        .getParcelable<Parcelable>(STATE_KEY)
        ?.also { layoutManagerState = it }
        ?.let { true }
        ?: false

    companion object {

        private const val STATE_KEY = "state"
    }
}


