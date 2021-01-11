package com.maksimnovikov.bottom_navigation

import android.os.Bundle
import android.view.View
import com.github.terrakok.cicerone.Router
import com.maksimnovikov.common.ui.BackPressedListener
import com.maksimnovikov.common.ui.BaseFragment
import com.maksimnovikov.common.ui.extensions.setTint
import kotlinx.android.synthetic.main.bottom_navigation_screen.*
import javax.inject.Inject

class BottomNavigationFragment : BaseFragment(R.layout.bottom_navigation_screen) {

    @Inject
    lateinit var localCiceroneHolder: LocalCiceroneHolder

    @Inject
    lateinit var router: Router

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomNavigationFavoritesTabIcon.setOnClickListener {
            setTab(Tab.Favorites())
        }
        bottomNavigationMainTabIcon.setOnClickListener {
            setTab(Tab.Home())
        }
        bottomNavigationListTabIcon.setOnClickListener {
            setTab(Tab.Search())
        }
        setTab(Tab.Home())
    }

    private val currentFragment: BackPressedListener?
        get() = childFragmentManager.findFragmentById(R.id.bottomNavigationContainer) as? BackPressedListener

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

    fun setTab(tab: Tab) {
        listOf(
            bottomNavigationListTabIcon,
            bottomNavigationFavoritesTabIcon,
            bottomNavigationMainTabIcon
            // we need set black color to fix asure deselection  https://jira01.goldapple.ru/browse/APP-5072
        ).forEach { it.setTint(R.color.black) }

        when (tab) {
            is Tab.Search -> bottomNavigationListTabIcon
            is Tab.Favorites -> bottomNavigationFavoritesTabIcon
            is Tab.Home -> bottomNavigationMainTabIcon
        }.setTint(R.color.colorAccentDark)
        setNavigationTab(tab)
    }

    fun setNavigationTab(tab: Tab) {
        localCiceroneHolder.setCurrentTab(tab)
        val fm = childFragmentManager
        val fragments = fm.fragments
        val currentFragment = fragments.firstOrNull { it.isVisible }

        val newFragment = fm.findFragmentByTag(tab.name)
        if (currentFragment != null && newFragment != null && currentFragment === newFragment) return

        val transaction = fm.beginTransaction()
        if (newFragment == null) {
            transaction.add(
                R.id.bottomNavigationContainer,
                TabContainerFragment.newInstance(tab),
                tab.name
            )
        }
        // might be more than one attached fragment
        fragments.forEach { transaction.detach(it) }

        if (newFragment != null) {
            transaction.attach(newFragment)
        }
        transaction.commitNow()
    }
}
