package com.maksimnovikov.search.ui

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.maksimnovikov.common.domain.entity.Film
import com.maksimnovikov.common.ui.BaseFragment
import com.maksimnovikov.common.ui.extensions.fragmentSavedStateViewModels
import com.maksimnovikov.common.ui.extensions.hideKeyboardOnScroll
import com.maksimnovikov.search.R
import com.maksimnovikov.search.SearchRouter
import com.maksimnovikov.search.databinding.SearchScreenBinding
import com.maksimnovikov.search.presentation.NavigationCommand
import com.maksimnovikov.search.presentation.SearchScreenState
import com.maksimnovikov.search.presentation.SearchViewModel
import javax.inject.Inject

class SearchFragment : BaseFragment(R.layout.search_screen) {

    @Inject
    lateinit var router: SearchRouter

    @Inject
    lateinit var searchViewModel: SearchViewModel

    private val binding by viewBinding(SearchScreenBinding::bind)
    private val viewModel: SearchViewModel by fragmentSavedStateViewModels { searchViewModel }
    private var searchAdapter: ListDelegationAdapter<List<Film>>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.searchResults) {
            layoutManager = LinearLayoutManager(context)
            searchAdapter =
                ListDelegationAdapter(searchFilmAdapter(onFilmClicked = viewModel::onFilmClicked))
            adapter = searchAdapter
            setHasFixedSize(true)
            hideKeyboardOnScroll()
        }
        with(binding.searchEdit) {
            doOnTextChanged { text, _, _, _ ->
                viewModel.onEditChanged(text.toString())
            }
        }
        viewModel.screenState.collectInViewLifecycle {
            when (it) {
                SearchScreenState.Initial -> {

                }

                is SearchScreenState.Result -> {
                    searchAdapter?.items = it.content.films
                    searchAdapter?.notifyDataSetChanged()
                }

                SearchScreenState.Error -> {

                }
            }
        }
        viewModel.navigationCommand.collectInViewLifecycle {
            when (it) {
                is NavigationCommand.ToFilmDetail -> router.showDetailInfo(it.film)
            }
        }
    }

    override fun onBackPressed() {
        router.close()
    }
}