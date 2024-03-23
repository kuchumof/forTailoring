package com.kuchumof.fortailoring.fragments

import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kuchumof.fortailoring.adapter.OrderAdapter
import com.kuchumof.fortailoring.databinding.FragmentOrderBinding
import com.kuchumof.fortailoring.model.OrderItemModel
import com.kuchumof.fortailoring.model.TypeOfClothEnum
import java.util.Locale

class FragmentOrder : Fragment() {

    private lateinit var binding: FragmentOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        binding.rcOrder.layoutManager = LinearLayoutManager(context)
        binding.rcOrder.adapter =
                /*Вместо статического списка, необходимо сделать подписку на изменения в модели представления*/
            OrderAdapter(
                listOf(
                    OrderItemModel(
                        101,
                        "Петров П.П.",
                        getString(TypeOfClothEnum.DRESS.getTranslation()),
                        getCurrentTime(),
                        "31.31.2025"
                    ),
                    OrderItemModel(
                        102,
                        "ИвановИвановИвановИвановИвановИвановИвановИванов И.И",
                        getString(TypeOfClothEnum.DRESS.getTranslation()),
                        getCurrentTime(),
                        "31.31.2026"
                    ),
                    OrderItemModel(
                        103,
                        "Дураков С.С.",
                        getString(TypeOfClothEnum.DRESS.getTranslation()),
                        "01.01.2027",
                        "31.31.2028"
                    ),
                    OrderItemModel(
                        104,
                        "Бездельников А.А.",
                        getString(TypeOfClothEnum.DRESS.getTranslation()),
                        "01.01.2029",
                        "31.31.2030"
                    ),
                    OrderItemModel(
                        105,
                        "Сухов К.Н.",
                        getString(TypeOfClothEnum.DRESS.getTranslation()),
                        "01.01.2031",
                        "31.31.2032"
                    ),

                    )
            )
        return binding.root

    }
    //TODO
    //задавать время создания заявки автоматически из текущего
    // +
    // возможно редактирования(выбора(из календара,))
    private fun getCurrentTime(): String {
        val formatter = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        return formatter.format(Calendar.getInstance().time)
    }
}