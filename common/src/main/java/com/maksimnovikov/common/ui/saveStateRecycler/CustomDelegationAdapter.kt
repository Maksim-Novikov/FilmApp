package com.maksimnovikov.common.ui.saveStateRecycler

import android.os.Bundle
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class CustomDelegationAdapter<T : List<*>>(vararg delegates: AdapterDelegate<T>) :
    ListDelegationAdapter<T>(*delegates) {

    private var restoredState: Bundle? = null


    fun saveInstanceState(): Bundle = Bundle().apply {
        for (i in 0 until itemCount) {
            getItemStateByPosition(i)?.let {
                putBundle(
                    "$STATE_PREFIX$i",
                    it.save()
                )
            }
        }
    }

    fun restoreItemsState() {
        restoredState?.let { restore(it) }
        restoredState = null
    }

    fun restoreInstanceState(state: Bundle) {
        restoredState = state
    }

    private fun restore(bundle: Bundle) = with(bundle) {
        for (i in 0 until itemCount) {
            if (containsKey("$STATE_PREFIX$i")) {
                val changed: Boolean =
                    getItemStateByPosition(i)?.restore(getBundle("$STATE_PREFIX$i") ?: Bundle())
                        ?: false
                if (changed) {
                    notifyItemChanged(i)
                }
            }
        }
    }

    private fun getItemStateByPosition(position: Int): ItemState? =
        items[position] as? ItemState

    companion object {

        private const val STATE_PREFIX = "pos_"
    }
}

