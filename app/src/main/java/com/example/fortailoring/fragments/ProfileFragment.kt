package com.example.fortailoring.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import com.example.fortailoring.R
import com.example.fortailoring.activities.MainApp
import com.example.fortailoring.activities.NewItemActivity
import com.example.fortailoring.databinding.FragmentItemOrderBinding
import com.example.fortailoring.databinding.FragmentProfileBinding
import com.example.fortailoring.db.MainViewModel
import com.example.fortailoring.entities.OrderItem

class ProfileFragment : BaseFragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var editLauncher: ActivityResultLauncher<Intent>

    private val mainViewModel: MainViewModel by activityViewModels {
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onEditResult()
        /*mainViewModel.allItems.observe(this,{
            it
        })*/
    }
    override fun onClickNew() {
        editLauncher.launch(Intent(activity, NewItemActivity::class.java))
    }
    private fun onEditResult() {
        editLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                val editState = it.data?.getStringExtra(ItemOrderFragment.EDIT_STATE_KEY)
                if (editState == "update") {
                    mainViewModel.updateItem(it.data?.getSerializableExtra(ItemOrderFragment.NEW_ITEM_KEY) as OrderItem)
                } else {
                    mainViewModel.insertItem(it.data?.getSerializableExtra(ItemOrderFragment.NEW_ITEM_KEY) as OrderItem)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}