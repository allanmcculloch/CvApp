package com.cv.android.ui.joblist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cv.android.R
import com.cv.android.extensions.inflateBinding
import com.cv.android.databinding.FragmentJobListBinding
import kotlinx.android.synthetic.main.fragment_job_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class JobListFragment : Fragment() {

    private val viewModel: JobListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflateBinding<FragmentJobListBinding>(R.layout.fragment_job_list, container) { it.viewModel = viewModel }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        jobsListRecyclerView.setHasFixedSize(true)

        jobsListRecyclerView.layoutManager = LinearLayoutManager(this.context).apply {
            orientation = RecyclerView.VERTICAL
        }
    }
}
