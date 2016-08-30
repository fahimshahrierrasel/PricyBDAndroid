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
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;
import com.treebricks.priceybd.fragments.PriceFragment;
import com.treebricks.priceybd.fragments.SpecificationFragment;


public class DeviceActivity extends AppCompatActivity {
    public static final String DEVICE_NAME = "DEVICE_NAME";
    public static final String DEVICE_IMAGE = "DEVICE_IMAGE";
    public static final String MOBILE_ID = "MOBILE_ID";
    public static final String TAG = "Retrofit Test";

    KenBurnsView kbv;
    String image;
    String title;
    int mobileId;

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final NestedScrollView scrollView = (NestedScrollView) findViewById (R.id.device_nestedscrollview);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.device_viewpager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager);


        Bundle receivedBundle = getIntent().getExtras();
        if(receivedBundle != null)
        {
            image = receivedBundle.getString(DEVICE_IMAGE);
            title = receivedBundle.getString(DEVICE_NAME);
            mobileId = receivedBundle.getInt(MOBILE_ID);
        }
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                scrollView.scrollTo(0, 0);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        kbv = (KenBurnsView) findViewById(R.id.kbv_image);
        Picasso.with(DeviceActivity.this).load(image).into(kbv);
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
                Picasso.with(view.getContext()).load(image).into(imageView);

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
            Fragment fragment = null;
            switch (position)
            {
                case 0:
                    fragment = SpecificationFragment.newInstance(mobileId);
                    break;

                case 1:
                    fragment = PriceFragment.newInstance(mobileId);
                    break;

                default:
                    fragment = SpecificationFragment.newInstance(mobileId);
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            // Show 2 total pages.
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
