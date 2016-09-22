package com.treebricks.priceybd.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.treebricks.priceybd.R;
import com.treebricks.priceybd.fragments.SpecificationFragment;

public class CompareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        ImageView firstimg = (ImageView) findViewById(R.id.first_image);
        ImageView secondimg = (ImageView) findViewById(R.id.second_image);

        // Status bar transparent.
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        // Set image for first comparing device
        Glide.with(this).load("http://cdn2.gsmarena.com/vv/pics/motorola/motorola-moto-z-play-1.jpg")
                .error(R.drawable.smartphone)
                .crossFade()
                .placeholder(R.drawable.smartphone)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(firstimg);

        // Set image for second comparing device
        Glide.with(this).load("http://cdn2.gsmarena.com/vv/pics/samsung/samsung-galaxy-j7-prime-1.jpg")
                .error(R.drawable.smartphone)
                .crossFade()
                .placeholder(R.drawable.smartphone)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .into(secondimg);

        // Initializing Fragment Manager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Initializing two fragment transaction each for every view/
        FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();

        // New instance of specification fragment two for comparing 2 device.
        SpecificationFragment specificationFragment1 = SpecificationFragment.newInstance(1);
        SpecificationFragment specificationFragment2 = SpecificationFragment.newInstance(3);

        // Adding fragment to the view and commit the change in layout.
        fragmentTransaction1.add(R.id.comp_first_fragment, specificationFragment1).commit();
        fragmentTransaction2.add(R.id.comp_second_fragment, specificationFragment2).commit();

    }
}
