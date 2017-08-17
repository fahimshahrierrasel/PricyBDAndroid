package com.treebricks.priceybd.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;

import com.treebricks.priceybd.R;
import com.treebricks.priceybd.fragments.PriceyPreferenceFragment;

/**
 * Created by fahim on 10/9/16.
 */

public class PriceyPreferences extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pricey_preferences);

        getSupportActionBar().setTitle("Preferences");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        PriceyPreferenceFragment preferenceFragment = new PriceyPreferenceFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, preferenceFragment);
        fragmentTransaction.commit();
    }

}
