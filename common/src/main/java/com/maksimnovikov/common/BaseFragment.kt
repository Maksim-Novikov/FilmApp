package com.maksimnovikov.common

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment(
    @LayoutRes contentLayoutId: Int = 0
) : Fragment(contentLayoutId), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(requireContext())
    }

    open fun onBackPressed() {}

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}