package com.kuchumof.fortailoring.fragments.example_of_works

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import com.kuchumof.fortailoring.R
import com.kuchumof.fortailoring.adapter.ViewPagerAdapter
import com.kuchumof.fortailoring.constant.SeasonEnum
import com.kuchumof.fortailoring.databinding.FragmentWorkExampleBinding


//https://medium.com/busoft/how-to-use-viewpager2-with-tablayout-in-android-eaf5b810ef7c
class FragmentWorkExample : Fragment() {

    private lateinit var binding: FragmentWorkExampleBinding
    private var activeTab = SeasonEnum.SUMMER


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun setOnClickFActionButton() {
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWorkExampleBinding.inflate(inflater, container, false)
        val viewPager = binding.viewPagerWorkExample
        val tabLayout = binding.tabLayoutWorkExample

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                activeTab = if (tab.position == 0) SeasonEnum.SUMMER else SeasonEnum.WINTER
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
                return
            }

            override fun onTabReselected(p0: TabLayout.Tab?) {
                return
            }
        }
        )

        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        viewPager.adapter = adapter
        viewPager.isSaveEnabled =
            false // https://stackoverflow.com/questions/59486504/fragment-no-longer-exists-for-key-fragmentstateadapter-with-viewpager2 !!!КОСТЫЛЬ!!!

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = if (position == 0) getText(R.string.Summer) else getText(R.string.Winter)
            //           activeTab = if (position == 0) SeasonEnum.SUMMER else SeasonEnum.WINTER
        }.attach()
        /**для отображения картинок*/
        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_summer)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_winter)

        val viewModel: FolderViewModel by viewModels()
        binding.fActionButton.setOnClickListener {
            viewModel.addFolder(activeTab)

        }
        return binding.root

    }


}