package com.treebricks.priceybd;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.treebricks.priceybd.customView.MyNestedScrollView;
import com.treebricks.priceybd.customView.WrapContentHeightViewPager;
import com.treebricks.priceybd.fragments.SpecificationFragment;


public class DeviceActivity extends AppCompatActivity {
    public static final String DEVICE_NAME = "DEVICE_NAME";
    public static final String DEVICE_IMAGE = "DEVICE_IMAGE";

    KenBurnsView kbv;
    int image;
    String title;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private WrapContentHeightViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MyNestedScrollView scrollView = (MyNestedScrollView) findViewById (R.id.device_scrollview);
        scrollView.setFillViewport (true);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (WrapContentHeightViewPager) findViewById(R.id.device_viewpager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager);


        Bundle receivedBundle = getIntent().getExtras();
        if(receivedBundle != null)
        {
            image = receivedBundle.getInt(DEVICE_IMAGE);
            title = receivedBundle.getString(DEVICE_NAME);
        }

        kbv = (KenBurnsView) findViewById(R.id.kbv_image);

        kbv.setImageDrawable(ResourcesCompat.getDrawable(getResources(),image, null));
        kbv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog builder = new Dialog(DeviceActivity.this);
                builder.requestWindowFeature(Window.FEATURE_NO_TITLE);
                builder.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        builder.cancel();
                    }
                });

                ImageView imageView = new ImageView(DeviceActivity.this);
                imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), image, null));

                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        builder.cancel();
                    }
                });

                builder.addContentView(imageView, new RelativeLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
                builder.show();
            }
        });





        if(getSupportActionBar() != null)
        {
            getSupportActionBar().setTitle(title);
        }
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return SpecificationFragment.newInstance(title);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Specification";
                case 1:
                    return "Price List";
            }
            return null;
        }
    }
}
