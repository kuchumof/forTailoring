package com.example.fortailoring.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fortailoring.databinding.FragmentItemOrderBinding
import com.example.fortailoring.databinding.FragmentMoreBinding

class MoreFragment : BaseFragment() {
    private lateinit var binding: FragmentMoreBinding
    override fun onClickNew() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MoreFragment()
    }
}