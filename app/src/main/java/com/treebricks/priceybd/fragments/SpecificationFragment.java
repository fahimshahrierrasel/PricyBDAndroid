package com.treebricks.priceybd.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.treebricks.priceybd.R;
import com.treebricks.priceybd.adapters.DeviceDetailAdapter;
import com.treebricks.priceybd.models.MobileDetail;
import com.treebricks.priceybd.rest.ApiClient;
import com.treebricks.priceybd.rest.ApiInterface;
import java.util.ArrayList;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fahim on 8/26/16.
 */
public class SpecificationFragment extends Fragment
{
    private static final String MOBILE_ID = "MOBILE_ID";


    public SpecificationFragment(){}

    public static SpecificationFragment newInstance(int mobileID)
    {
        SpecificationFragment specificationFragment = new SpecificationFragment();
        final Bundle args = new Bundle();

        args.putInt(MOBILE_ID, mobileID);
        specificationFragment.setArguments(args);
        return specificationFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.specification_fragment, container, false);
        RecyclerView specificationRecycler = (RecyclerView) rootView.findViewById(R.id.specificaiton_recycler);

        LinearLayoutManager specificationLinearLayoutManager =
                new LinearLayoutManager(SpecificationFragment.this.getContext(), LinearLayoutManager.VERTICAL, false);

        specificationRecycler.setLayoutManager(specificationLinearLayoutManager);

        int mobileId = getArguments().getInt(MOBILE_ID);

        new SpecificaitonTask(SpecificationFragment.this.getContext(), mobileId, specificationRecycler).execute(specificationRecycler);

        return rootView;
    }

    class SpecificaitonTask extends AsyncTask<RecyclerView,Void,Void>
    {
        ProgressDialog progress;
        RecyclerView recyclerView;
        ArrayList<String> specs;
        int mobileId;
        Context context;

        public SpecificaitonTask(Context context, int mobileId, RecyclerView recyclerView)
        {
            this.context = context;
            this.mobileId = mobileId;
            this.recyclerView = recyclerView;
        }

        @Override
        protected void onPreExecute() {
            progress = ProgressDialog.show(context, "Loading","Please Wait", true);
        }

        @Override
        protected Void doInBackground(final RecyclerView... recyclerViews) {


            recyclerView = recyclerViews[0];
            specs = new ArrayList<String>();
            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

            Call<MobileDetail> call = apiInterface.getMobileDetail(mobileId);
            call.enqueue(new Callback<MobileDetail>() {
                @Override
                public void onResponse(Call<MobileDetail> call, Response<MobileDetail> response) {

                    MobileDetail mobileDetail = response.body();

                    specs.add("Model Name: "+ mobileDetail.getModelName());

                    specs.add("Brand: " + mobileDetail.getBrand());

                    specs.add("Launch: " + mobileDetail.getLaunch());

                    specs.add("Network Technology: " + mobileDetail.getNetwork());

                    specs.add("Dimensions: " + mobileDetail.getDimensions());

                    specs.add("Weight: " + mobileDetail.getWeight());

                    specs.add("Sim Type: " + mobileDetail.getSimType());

                    specs.add("Display Type: " + mobileDetail.getDisplayType());

                    specs.add("Display Size: " + mobileDetail.getDisplaySize());

                    specs.add("Display Resolution: " + mobileDetail.getDisplayResolution());

                    specs.add("Operating System: " + mobileDetail.getOs());

                    specs.add("Chipset: " + mobileDetail.getChipset());

                    specs.add("CPU: " + mobileDetail.getCpu());

                    specs.add("GPU: " + mobileDetail.getGpu());

                    specs.add("RAM: " + mobileDetail.getMemoryRam());

                    specs.add("Internal Memory: " + mobileDetail.getMemoryInternal());

                    specs.add("External Memory: " + mobileDetail.getMemoryExternal());

                    specs.add("Primary Camera: " + mobileDetail.getPrimaryCamera());

                    specs.add("Secondary Camera: " + mobileDetail.getSecondaryCamera());

                    specs.add("Camera Features: " + mobileDetail.getCameraFeatures());

                    specs.add("Wifi: " + mobileDetail.getWifi());

                    specs.add("Bluetooth: " + mobileDetail.getBluetooth());

                    specs.add("GPS: " + mobileDetail.getBluetooth());

                    specs.add("Radio: " + mobileDetail.getRadio());

                    specs.add("USB: " + mobileDetail.getUsb());

                    specs.add("Sensors: " + mobileDetail.getSensors());

                    specs.add("Battery: " + mobileDetail.getBatteryType());

                    specs.add("Colors: " + mobileDetail.getColors());


                    DeviceDetailAdapter deviceDetailAdapter = new DeviceDetailAdapter(context, specs);
                    recyclerView.setAdapter(new ScaleInAnimationAdapter(deviceDetailAdapter));
                    progress.cancel();
                    
                }

                @Override
                public void onFailure(Call<MobileDetail> call, Throwable t) {

                }
            });
            return null;
        }

    }
}
