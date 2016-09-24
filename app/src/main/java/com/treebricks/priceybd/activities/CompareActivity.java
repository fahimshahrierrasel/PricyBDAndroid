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
import com.treebricks.priceybd.models.MobileShortDetail;
import com.treebricks.priceybd.rest.ApiClient;
import com.treebricks.priceybd.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompareActivity extends AppCompatActivity {

    public static final String FIRST_DEVICE = "FIRST_DEVICE";
    public static final String SECOND_DEVICE = "SECOND_DEVICE";
    String firstDevice, secondDevice;
    MobileShortDetail device1, device2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        final ImageView firstimg = (ImageView) findViewById(R.id.first_image);
        final ImageView secondimg = (ImageView) findViewById(R.id.second_image);

        // Status bar transparent.
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);


        // Initializing Fragment Manager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Initializing two fragment transaction each for every view/
        final FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
        final FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();

        Bundle receivedBundle = getIntent().getExtras();
        if(receivedBundle != null)
        {
            firstDevice = receivedBundle.getString(FIRST_DEVICE);
            secondDevice = receivedBundle.getString(SECOND_DEVICE);
        }

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<MobileShortDetail> shortDetailCall1 = apiInterface.getShortInfo(firstDevice);
        Call<MobileShortDetail> shortDetailCall2 = apiInterface.getShortInfo(secondDevice);

        shortDetailCall1.enqueue(new Callback<MobileShortDetail>() {
            @Override
            public void onResponse(Call<MobileShortDetail> call, Response<MobileShortDetail> response) {
                device1 = response.body();
                // Set image for first comparing device
                Glide.with(CompareActivity.this).load(device1.getPhoto())
                        .error(R.drawable.smartphone)
                        .crossFade()
                        .placeholder(R.drawable.smartphone)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(firstimg);

                // New instance of specification fragment two for comparing 2 device.
                SpecificationFragment specificationFragment1 = SpecificationFragment.newInstance(Integer.parseInt(device1.getMobileID()));

                // Adding fragment to the view and commit the change in layout.
                fragmentTransaction1.add(R.id.comp_first_fragment, specificationFragment1).commit();

            }

            @Override
            public void onFailure(Call<MobileShortDetail> call, Throwable t) {

            }
        });

        shortDetailCall2.enqueue(new Callback<MobileShortDetail>() {
            @Override
            public void onResponse(Call<MobileShortDetail> call, Response<MobileShortDetail> response) {
                device2 = response.body();
                // Set image for second comparing device
                Glide.with(CompareActivity.this).load(device2.getPhoto())
                        .error(R.drawable.smartphone)
                        .crossFade()
                        .placeholder(R.drawable.smartphone)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(secondimg);

                // New instance of specification fragment two for comparing 2 device.
                SpecificationFragment specificationFragment2 = SpecificationFragment.newInstance(Integer.parseInt(device2.getMobileID()));

                // Adding fragment to the view and commit the change in layout.
                fragmentTransaction2.add(R.id.comp_second_fragment, specificationFragment2).commit();

            }

            @Override
            public void onFailure(Call<MobileShortDetail> call, Throwable t) {

            }
        });









    }
}
