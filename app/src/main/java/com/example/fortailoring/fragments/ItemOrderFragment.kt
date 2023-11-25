package com.example.fortailoring.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.fortailoring.R
import com.example.fortailoring.activities.MainApp
import com.example.fortailoring.databinding.FragmentItemOrderBinding
import com.example.fortailoring.db.MainViewModel

class ItemOrderFragment : BaseFragment() {
    private lateinit var binding: FragmentItemOrderBinding
    private val mainViewModel: MainViewModel by activityViewModels {
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }
    override fun onClickNew() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = ItemOrderFragment()
    }
}