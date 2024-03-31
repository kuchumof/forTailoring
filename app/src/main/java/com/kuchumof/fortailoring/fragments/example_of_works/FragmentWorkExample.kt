package com.kuchumof.fortailoring.fragments.example_of_works

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.kuchumof.fortailoring.R
import com.kuchumof.fortailoring.adapter.ViewPagerAdapter
import com.kuchumof.fortailoring.databinding.FragmentWorkExampleBinding



//https://medium.com/busoft/how-to-use-viewpager2-with-tablayout-in-android-eaf5b810ef7c
class FragmentWorkExample : Fragment() {

    private var _binding: FragmentWorkExampleBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setOnClickFActionButton () {
        binding.fActionButton.setOnClickListener {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkExampleBinding.inflate(inflater, container, false)
        val viewPager = binding.viewPagerWorkExample
        val tabLayout = binding.tabLayoutWorkExample


        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        viewPager.adapter = adapter
        viewPager.isSaveEnabled = false // https://stackoverflow.com/questions/59486504/fragment-no-longer-exists-for-key-fragmentstateadapter-with-viewpager2 !!!КОСТЫЛЬ!!!

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = if (position==0) getText(R.string.Summer) else getText(R.string.Winter)
        }.attach()
        /**для отображения картинок*/
        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_summer)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_winter)

        return binding.root

    }

}