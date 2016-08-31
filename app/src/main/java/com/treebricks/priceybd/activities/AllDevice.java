package com.treebricks.priceybd.activities;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toolbar;

import com.treebricks.priceybd.R;
import com.treebricks.priceybd.adapters.DeviceShortDetailAdapter;
import com.treebricks.priceybd.models.AllShortDetails;
import com.treebricks.priceybd.models.MobileShortDetail;
import com.treebricks.priceybd.rest.ApiClient;
import com.treebricks.priceybd.rest.ApiInterface;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllDevice extends AppCompatActivity {

    public static final String TITLE = "TITLE";
    RecyclerView allDevicesGridRecycler;
    String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alldevice);

        title = getIntent().getStringExtra(TITLE);

        if(getSupportActionBar() != null)
        {
            getSupportActionBar().setTitle(title);
        }

        allDevicesGridRecycler = (RecyclerView) findViewById(R.id.all_devices_grid);

        if(AllDevice.this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            allDevicesGridRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        }
        else{
            allDevicesGridRecycler.setLayoutManager(new GridLayoutManager(this, 3));
        }


        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<AllShortDetails> call = apiInterface.getAllMobileShortDetail();

        call.enqueue(new Callback<AllShortDetails>() {
            @Override
            public void onResponse(Call<AllShortDetails> call, Response<AllShortDetails> response)
            {
                ArrayList<MobileShortDetail> allDevices = (ArrayList<MobileShortDetail>) response.body().getDevices();

                DeviceShortDetailAdapter allDevicesAdapter = new DeviceShortDetailAdapter(AllDevice.this, allDevices, allDevices.size());
                allDevicesGridRecycler.setAdapter(new SlideInBottomAnimationAdapter(allDevicesAdapter));

            }

            @Override
            public void onFailure(Call<AllShortDetails> call, Throwable t) {

            }
        });

    }

}
