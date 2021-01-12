package com.maksimnovikov.filmapp

import android.os.Bundle
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.maksimnovikov.common.ui.BaseFragment
import com.maksimnovikov.filmapp.routing.Screens
import dagger.Lazy
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var ciceroneRouter: Router

    @Inject
    lateinit var navigatorHolder: Lazy<NavigatorHolder>

    private val navigator: Navigator = object : AppNavigator(
        this,
        R.id.mainActivityContainer
    ) {
        override fun back() {
            if (localStackCopy.size > 1) {
                fragmentManager.popBackStack()
                localStackCopy.removeAt(localStackCopy.lastIndex)
            } else {
                activityBack()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setDecorFitsSystemWindows(false)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            ciceroneRouter.navigateTo(Screens.bottom())
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.get().setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.get().removeNavigator()
        super.onPause()
    }

    private val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.mainActivityContainer) as? BaseFragment

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }
}

