package com.cv.android.ui.contactinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cv.android.R
import com.cv.android.extensions.inflateBinding
import com.cv.android.databinding.FragmentContactInfoBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ContactInfoFragment : Fragment() {
    private val viewModel: ContactInfoViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflateBinding<FragmentContactInfoBinding>(R.layout.fragment_contact_info, container) { it.viewModel = viewModel }
    }
}