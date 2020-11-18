package com.maksimnovikov.bottom_navigation

import android.os.Bundle
import androidx.core.os.bundleOf
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.maksimnovikov.common.BaseFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Inject

class TabContainerFragment : BaseFragment(R.layout.tab_container_fragment) {

    companion object {

        private const val TAB_KEY = "TAB_KEY"
        fun newInstance(tab: Tab): TabContainerFragment = TabContainerFragment().apply {
            arguments = bundleOf(TAB_KEY to tab)
        }
    }

    private val tab: Tab
        get() = arguments?.get(TAB_KEY) as Tab

    @Inject
    lateinit var localCiceroneHolder: LocalCiceroneHolder

    @Inject
    lateinit var bottomRouter: BottomRouter

    @Inject
    lateinit var router: Router

    private val navigator: Navigator by lazy {
        object : AppNavigator(
            requireActivity(),
            R.id.fragment_container,
            childFragmentManager
        ) {
            override fun back() {
                if (localStackCopy.size > 1) {
                    fragmentManager.popBackStack()
                    localStackCopy.removeAt(localStackCopy.lastIndex)
                } else {
                    activityBack()
                }
            }

            override fun activityBack() {
                router.exit()
            }
        }
    }

    private val cicerone: Cicerone<Router> by lazy {
        localCiceroneHolder.getCicerone(tab)
    }
    private val ciceroneRouter: Router by lazy {
        cicerone.router
    }

    private val currentFragment: BaseFragment?
        get() = childFragmentManager.findFragmentById(R.id.fragment_container) as? BaseFragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (currentFragment == null) {
            ciceroneRouter.navigateTo(
                when (tab) {
                    is Tab.Favorites -> bottomRouter.getFavoritesTabScreen()
                    is Tab.Home -> bottomRouter.getHomeTabScreen()
                    is Tab.Search -> bottomRouter.getSearchTabScreen()
                }
            )
        }
    }


    override fun onResume() {
        super.onResume()
        cicerone.getNavigatorHolder().setNavigator(navigator)
    }

    override fun onPause() {
        cicerone.getNavigatorHolder().removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }
}

@Module
interface BottomInjector {

    @ContributesAndroidInjector
    fun contributesBottomFragment(): BottomNavigationFragment

    @ContributesAndroidInjector
    fun contributesTabContainerFragment(): TabContainerFragment
}