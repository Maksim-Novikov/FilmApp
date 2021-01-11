package com.maksimnovikov.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.maksimnovikov.common.ui.BaseFragment
import kotlinx.android.extensions.LayoutContainer
import javax.inject.Inject

class SearchFragment : BaseFragment(R.layout.search_screen) {

    @Inject
    lateinit var router: SearchRouter

    override fun onBackPressed() {
        router.close()
    }
}

class SearchAdapter : ListAdapter<FilmSearch, SearchAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<FilmSearch>() {
        override fun areItemsTheSame(oldItem: FilmSearch, newItem: FilmSearch): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: FilmSearch, newItem: FilmSearch): Boolean =
            oldItem == newItem

    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        fun bind(filmSearch: FilmSearch) {
//            searchItemBanner
        }
    }
}

data class FilmSearch(val id: String, val imageUrl: String)

