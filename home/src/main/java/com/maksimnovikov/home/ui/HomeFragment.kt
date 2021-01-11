package com.maksimnovikov.home.ui

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.maksimnovikov.common.ui.BaseFragment
import com.maksimnovikov.common.ui.dividers.customDivider
import com.maksimnovikov.common.ui.extensions.dip
import com.maksimnovikov.common.ui.extensions.fragmentSavedStateViewModels
import com.maksimnovikov.common.ui.saveStateRecycler.CustomDelegationAdapter
import com.maksimnovikov.home.HomeRouter
import com.maksimnovikov.home.R
import com.maksimnovikov.home.databinding.HomeScreenBinding
import com.maksimnovikov.home.presentation.HomeScreenState
import com.maksimnovikov.home.presentation.HomeViewModel
import com.maksimnovikov.home.presentation.NavigationCommand
import com.maksimnovikov.home.ui.adapters.homeHeaderAdapter
import com.maksimnovikov.home.ui.adapters.homeSliderAdapter
import javax.inject.Inject

class HomeFragment : BaseFragment(R.layout.home_screen) {

    @Inject
    lateinit var homeRouter: HomeRouter

    @Inject
    lateinit var homeViewModel: HomeViewModel

    private var mainAdapter: CustomDelegationAdapter<List<HomeScreenViewItem>>? = null
    private val binding by viewBinding(HomeScreenBinding::bind)
    private val viewModel: HomeViewModel by fragmentSavedStateViewModels { homeViewModel }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainAdapter = CustomDelegationAdapter(
            homeSliderAdapter(onFilmClick = {
                viewModel.onFilmClick(it)
            }),
            homeHeaderAdapter()
        )
        with(binding.homeRecycler) {
            layoutManager = LinearLayoutManager(context)
            adapter = mainAdapter
            setHasFixedSize(true)
            customDivider { position, itemCount, outRect, _ ->
                val data = mainAdapter?.items ?: return@customDivider
                val item = data[position]
                outRect.top = when (item) {
                    is HomeScreenViewItem.Header -> dip(10)
                    is HomeScreenViewItem.Slider -> dip(10)
                }
                outRect.bottom = when {
                    item is HomeScreenViewItem.Slider && position == itemCount - 1 -> dip(20)
                    else -> 0
                }
            }
        }

        viewModel.screenState.collectInViewLifecycle {
            when (it) {
                HomeScreenState.Error -> {

                }

                HomeScreenState.Loading -> {

                }

                is HomeScreenState.Content -> {
                    val newData =
                        listOf(
                            HomeScreenViewItem.Header(getString(R.string.top_100_popular_films)),
                            HomeScreenViewItem.Slider(it.homeContent.top100PopularFilms),
                            HomeScreenViewItem.Header(getString(R.string.top_250_best_films)),
                            HomeScreenViewItem.Slider(it.homeContent.top250BestFilms),
                            HomeScreenViewItem.Header(getString(R.string.top_await_films)),
                            HomeScreenViewItem.Slider(it.homeContent.topAwaitFilms),
                        )
                    mainAdapter?.items = newData
                    mainAdapter?.restoreItemsState()
                    mainAdapter?.notifyDataSetChanged()
                }
            }
        }
        viewModel.navigationCommand.collectInViewLifecycle {
            when (it) {
                is NavigationCommand.ToFilmDetail -> homeRouter.showDetailInfo(it.filmId)
                NavigationCommand.Back -> homeRouter.close()
            }
        }
    }

    override fun onBackPressed() {
        viewModel.onBackPressed()
    }
}