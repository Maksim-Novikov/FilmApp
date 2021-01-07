package com.maksimnovikov.home

import android.os.Bundle
import android.view.View
import com.maksimnovikov.common.BaseFragment
import com.maksimnovikov.common.entity.FilmId
import kotlinx.android.synthetic.main.home_screen.*
import javax.inject.Inject

class HomeFragment : BaseFragment(R.layout.home_screen) {

    @Inject
    lateinit var homeRouter: HomeRouter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeDetail.setOnClickListener {
            homeRouter.showDetailInfo(FilmId(100))
        }
    }

    override fun onBackPressed() {
        homeRouter.close()
    }
}
