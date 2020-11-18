package com.maksimnovikov.search

import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Inject

class SearchFragment : com.maksimnovikov.common.BaseFragment() {

    @Inject
    lateinit var router: SearchRouter
    override fun onBackPressed(): Unit {
        router.close()
    }
}

@Module
interface SearchInjector {

    @ContributesAndroidInjector
    fun contributesSearchFragment(): SearchFragment
}