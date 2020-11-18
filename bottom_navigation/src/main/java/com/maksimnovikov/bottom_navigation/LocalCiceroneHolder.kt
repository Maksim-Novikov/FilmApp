package com.maksimnovikov.bottom_navigation

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import java.util.*

class LocalCiceroneHolder {

    private val containers: HashMap<String, Cicerone<Router>> = HashMap()
    private var currentTab: Tab = Tab.Home()

    fun getCicerone(tab: Tab): Cicerone<Router> {
        if (!containers.containsKey(tab.name)) {
            containers[tab.name] = Cicerone.create()
        }
        return containers[tab.name]!!
    }

    fun getCurrentRouter(): Router = getRouter(currentTab)
    private fun getRouter(tab: Tab): Router = getCicerone(tab).router

    fun setCurrentTab(tab: Tab) {
        currentTab = tab
    }
}