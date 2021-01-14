package com.maksimnovikov.common.ui

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

abstract class BaseFragment(
    @LayoutRes contentLayoutId: Int = 0,
) : Fragment(contentLayoutId), HasAndroidInjector, BackPressedListener {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(requireContext())
    }

    override fun onBackPressed() {}

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    fun <T> Flow<T>.collectInViewLifecycle(block: (T) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            collect { block(it) }
        }
    }
}


abstract class BaseFragment2(
    @LayoutRes contentLayoutId: Int = 0,
) : Fragment(contentLayoutId), BackPressedListener {

    override fun onBackPressed() {}

    fun <T> Flow<T>.collectInViewLifecycle(block: (T) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            collect { block(it) }
        }
    }
}

