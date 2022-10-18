package com.ideal.textrecognizer.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ideal.textrecognizer.R
import com.ideal.textrecognizer.databinding.FragmentOnboardBinding

class OnboardFragment : Fragment(R.layout.fragment_onboard) {

    private val viewModel: OnboardViewModel by viewModels {

    }
    private var _binding: FragmentOnboardBinding? = null
    private val binding: FragmentOnboardBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOnboardBinding.inflate(inflater)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}