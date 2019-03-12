package com.cv.android.ui.photos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cv.android.R
import com.cv.android.extensions.inflateBinding
import org.koin.android.viewmodel.ext.android.viewModel
import com.cv.android.databinding.FragmentPhotosBinding
import kotlinx.android.synthetic.main.fragment_photos.*

class PhotosFragment : Fragment() {

    private val viewModel: PhotosViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflateBinding<FragmentPhotosBinding>(R.layout.fragment_photos, container) { it.viewModel = viewModel }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        photosRecyclerView.setHasFixedSize(true)

        photosRecyclerView.layoutManager = LinearLayoutManager(this.context).apply {
            orientation = RecyclerView.VERTICAL
        }
    }
}
