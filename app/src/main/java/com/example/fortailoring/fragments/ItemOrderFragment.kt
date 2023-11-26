package com.example.fortailoring.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fortailoring.R
import com.example.fortailoring.activities.MainApp
import com.example.fortailoring.activities.NewItemActivity
import com.example.fortailoring.databinding.FragmentItemOrderBinding
import com.example.fortailoring.db.ItemAdapter
import com.example.fortailoring.db.MainViewModel
import com.example.fortailoring.entities.OrderItem

class ItemOrderFragment : BaseFragment(), ItemAdapter.Listener {

    private lateinit var binding: FragmentItemOrderBinding
    private lateinit var editLauncher: ActivityResultLauncher<Intent>
    private lateinit var adapter: ItemAdapter

    private val mainViewModel: MainViewModel by activityViewModels {
        MainViewModel.MainViewModelFactory((context?.applicationContext as MainApp).database)
    }

    override fun onClickNew() {
        editLauncher.launch(Intent(activity, NewItemActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onEditResult()
        /*mainViewModel.allItems.observe(this,{
            it
        })*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemOrderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()
        observer()
    }

    private fun initRcView() = with(binding) {
        rcViewOrder.layoutManager = LinearLayoutManager(activity)
        adapter = ItemAdapter(this@ItemOrderFragment)
        rcViewOrder.adapter = adapter
    }

    private fun observer() {
        mainViewModel.allItems.observe(viewLifecycleOwner, {
            adapter.submitList(it)
        })
    }

    private fun onEditResult() {
        editLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                val editState = it.data?.getStringExtra(EDIT_STATE_KEY)
                if (editState == "update") {
                    mainViewModel.updateItem(it.data?.getSerializableExtra(NEW_ITEM_KEY) as OrderItem)
                } else {
                    mainViewModel.insertItem(it.data?.getSerializableExtra(NEW_ITEM_KEY) as OrderItem)
                }
            }
        }
    }

    override fun deleteItem(id: Int) {
        mainViewModel.deleteItem(id)
    }

    override fun onClickItem(item: OrderItem) {
        val intent = Intent(activity, NewItemActivity::class.java).apply {
            putExtra(NEW_ITEM_KEY, item)
        }
        editLauncher.launch(intent)
    }

    companion object {

        const val NEW_ITEM_KEY = "new_item_key"
        const val EDIT_STATE_KEY = "edit_state_key"

        @JvmStatic
        fun newInstance() = ItemOrderFragment()
    }
}