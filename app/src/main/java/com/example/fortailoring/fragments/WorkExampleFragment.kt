package com.example.fortailoring.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fortailoring.databinding.FragmentWorkExampleBinding


class WorkExampleFragment : BaseFragment() {

    private lateinit var binding: FragmentWorkExampleBinding
    override fun onClickNew() {
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWorkExampleBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = WorkExampleFragment()
    }
}