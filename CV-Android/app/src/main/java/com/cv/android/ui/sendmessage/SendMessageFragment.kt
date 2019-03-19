package com.cv.android.ui.sendmessage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cv.android.R
import com.cv.android.databinding.FragmentSendMessageBinding
import com.cv.android.extensions.inflateBinding
import org.koin.android.viewmodel.ext.android.viewModel

class SendMessageFragment : Fragment() {
    private val viewModel: SendMessageViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return inflateBinding<FragmentSendMessageBinding>(R.layout.fragment_send_message, container) { it.viewModel = viewModel }
    }
}
