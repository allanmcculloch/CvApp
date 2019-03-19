package com.cv.android.ui.photos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cv.android.R
import com.cv.android.databinding.ItemPhotoBinding
import com.cv.models.Photo

class PhotosAdapter: RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {
    private lateinit var photosList: List<Photo>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPhotoBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_photo, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photosList[position])
    }

    override fun getItemCount(): Int {
        return if (::photosList.isInitialized) photosList.size else 0
    }

    fun updateList(photos: List<Photo>) {
        this.photosList = photos

        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = PhotoViewModel()

        fun bind(photo: Photo) {
            viewModel.bind(photo)
            binding.viewModel = viewModel
        }
    }
}
