package com.kuchumof.fortailoring.fragments.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.kuchumof.fortailoring.R


class FragmentSettings : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }


}