package com.cv.android.ui.joblist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cv.android.R
import com.cv.android.databinding.ItemJobBinding
import com.cv.models.Job

class JobListAdapter: RecyclerView.Adapter<JobListAdapter.ViewHolder>() {
    private lateinit var jobsList: List<Job>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemJobBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_job, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(jobsList[position])
    }

    override fun getItemCount(): Int {
        return if (::jobsList.isInitialized) jobsList.size else 0
    }

    fun updateList(jobList: List<Job>) {
        this.jobsList = jobList

        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemJobBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = JobViewModel()

        fun bind(job: Job) {
            viewModel.bind(job)
            binding.viewModel = viewModel
        }
    }
}
