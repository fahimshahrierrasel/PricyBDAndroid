package com.treebricks.priceybd.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.treebricks.priceybd.R;

/**
 * Created by fahim on 10/9/16.
 */

public class PriceyPreferenceFragment extends PreferenceFragment
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
