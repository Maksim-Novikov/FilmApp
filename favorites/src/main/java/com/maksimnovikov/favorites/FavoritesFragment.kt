package com.maksimnovikov.favorites

import com.maksimnovikov.common.BaseFragment
import javax.inject.Inject

class FavoritesFragment : BaseFragment() {

    @Inject
    lateinit var router: FavoritesRouter
    override fun onBackPressed() {
        router.close()
    }
}

