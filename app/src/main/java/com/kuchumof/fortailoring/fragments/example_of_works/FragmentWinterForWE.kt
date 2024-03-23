package com.kuchumof.fortailoring.fragments.example_of_works

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.kuchumof.fortailoring.adapter.FolderListAdapter
import com.kuchumof.fortailoring.databinding.FragmentWinterForWEBinding
import kotlinx.coroutines.launch

class FragmentWinterForWE : Fragment() {

    private lateinit var binding: FragmentWinterForWEBinding
    private var adapter = FolderListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWinterForWEBinding.inflate(inflater, container, false)

        //Установка менеджера макета - сетка для RecyclerView с тремя столбцами
        binding.rcViewExampleWinter.layoutManager = GridLayoutManager(context, 3)

        //Установка адаптера RecyclerView с использованием FolderListAdapter
        binding.rcViewExampleWinter.adapter = adapter

        //Получение ссылки на экземпляр класса FolderViewModel
        val viewModel: FolderViewModel by viewModels()
        //Подписка на изменение списка
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                /**@param collect - метод возвращает последнее актуальное состояние списка */
                viewModel.foldersWinter.collect {
                    adapter.submitList(it)
                }
            }
        }
        return binding.root
    }
}