package com.maksimnovikov.film_detail.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import by.kirich1409.viewbindingdelegate.viewBinding
import com.maksimnovikov.common.domain.entity.Film
import com.maksimnovikov.common.ui.BaseFragment2
import com.maksimnovikov.common.ui.extensions.fragmentSavedStateViewModels
import com.maksimnovikov.common.ui.extensions.join
import com.maksimnovikov.common.ui.extensions.setImageUrl
import com.maksimnovikov.common.ui.extensions.setTextOrHideView
import com.maksimnovikov.film_detail.FilmDetailRouter
import com.maksimnovikov.film_detail.R
import com.maksimnovikov.film_detail.databinding.FilmDetailScreenBinding
import com.maksimnovikov.film_detail.di.FilmDetailComponentHolder
import com.maksimnovikov.film_detail.di.FilmDetailViewModelFactory
import com.maksimnovikov.film_detail.presentation.FilmDetailScreenState
import com.maksimnovikov.film_detail.presentation.FilmDetailViewModel
import javax.inject.Inject

class FilmDetailFragment : BaseFragment2(R.layout.film_detail_screen) {

    @Inject
    lateinit var router: FilmDetailRouter

    @Inject
    lateinit var filmDetailViewModelFactory: FilmDetailViewModelFactory

    companion object {

        private const val FILM_ID_KEY = "FILM_ID_KEY"
        fun newInstance(film: Film) = FilmDetailFragment().apply {
            arguments = bundleOf(FILM_ID_KEY to film)
        }
    }

    private val film: Film
        get() = arguments?.get(FILM_ID_KEY) as Film

    private val binding by viewBinding(FilmDetailScreenBinding::bind)
    private val viewModel: FilmDetailViewModel by fragmentSavedStateViewModels {
        filmDetailViewModelFactory.create(film)
    }

    init {
        FilmDetailComponentHolder.getComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.filmDetailBack.setOnClickListener { viewModel.onBackPressed() }
        binding.filmDetailErrorView.onRetry { viewModel.onRetry() }

        viewModel.screenState.collectInViewLifecycle {
            when (it) {
                is FilmDetailScreenState.Error -> {
                    binding.filmDetailLoadingIndicator.isVisible = false
                    binding.filmDetailContent.isVisible = false
                    with(binding.filmDetailErrorView) {
                        isVisible = true
                        setError(it.throwable)
                    }
                }

                FilmDetailScreenState.Loading -> {
                    binding.filmDetailLoadingIndicator.isVisible = true
                    binding.filmDetailContent.isVisible = false
                    binding.filmDetailErrorView.isVisible = false
                }

                is FilmDetailScreenState.Content -> {
                    binding.filmDetailLoadingIndicator.isVisible = false
                    binding.filmDetailContent.isVisible = true
                    binding.filmDetailErrorView.isVisible = false

                    val model = it.content
                    binding.filmDetailToolbar.text = model.nameRu
                    binding.filmDetailId.text = model.filmId.value.toString()
                    binding.filmDetailPoster.setImageUrl(model.posterUrl)
                    binding.filmDetailName.text = model.nameRu
                    binding.filmDetailNameEng.setTextOrHideView(model.nameEn)
                    binding.filmDetailYear.text =
                        model.year.join(model.genres.joinToString(separator = ", "), ", ")
                    binding.filmDetailCountry.text =
                        (model.countries + model.filmLength).joinToString(separator = ", ")
                    binding.filmDetailDescription.text = model.description
                }
            }
        }
    }

    override fun onDestroy() {
        FilmDetailComponentHolder.reset()
        super.onDestroy()
    }

    override fun onBackPressed() {
        router.close()
    }
}
