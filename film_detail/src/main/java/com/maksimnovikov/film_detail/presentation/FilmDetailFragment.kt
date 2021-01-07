package com.maksimnovikov.film_detail.presentation

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.maksimnovikov.common.BaseFragment
import com.maksimnovikov.common.entity.FilmId
import com.maksimnovikov.film_detail.FilmDetailRouter
import com.maksimnovikov.film_detail.R
import com.maksimnovikov.film_detail.di.FilmDetailComponentHolder
import kotlinx.android.synthetic.main.film_detail_screen.*
import javax.inject.Inject

class FilmDetailFragment : BaseFragment(R.layout.film_detail_screen) {

    @Inject
    lateinit var router: FilmDetailRouter

    companion object {

        private const val FILM_ID_KEY = "FILM_ID_KEY"
        fun newInstance(filmId: FilmId) = FilmDetailFragment().apply {
            arguments = bundleOf(FILM_ID_KEY to filmId)
        }
    }

    private val filmId: FilmId
        get() = arguments?.get(FILM_ID_KEY) as FilmId


    init {
        FilmDetailComponentHolder.getComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filmDetailId.text = filmId.value.toString()
    }

    override fun onDestroy() {
        FilmDetailComponentHolder.reset()
        super.onDestroy()
    }

    override fun onBackPressed() {
        router.close()
    }
}
