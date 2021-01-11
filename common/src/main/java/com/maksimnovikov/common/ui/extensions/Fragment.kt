package com.maksimnovikov.common.ui.extensions

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner

inline fun <reified T : ViewModel> Fragment.fragmentSavedStateViewModels(
    crossinline creator: (SavedStateHandle) -> T
): Lazy<T> = createViewModelLazy(
    viewModelClass = T::class,
    storeProducer = { viewModelStore },
    factoryProducer = {
        createAbstractSavedStateViewModelFactory(
            arguments = arguments ?: Bundle(),
            creator = creator
        )
    })

/**
 * Factory function to create a single instance of the ViewModel.
 *
 * @receiver SavedStateRegistryOwner
 * @param arguments Bundle?
 * @param creator Function1<SavedStateHandle, T>
 * @return ViewModelProvider.Factory
 */
@Suppress("UNCHECKED_CAST")
inline fun <reified T : ViewModel> SavedStateRegistryOwner.createAbstractSavedStateViewModelFactory(
    arguments: Bundle,
    crossinline creator: (SavedStateHandle) -> T
): ViewModelProvider.Factory = object : AbstractSavedStateViewModelFactory(this, arguments) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T = creator(handle) as T
}
