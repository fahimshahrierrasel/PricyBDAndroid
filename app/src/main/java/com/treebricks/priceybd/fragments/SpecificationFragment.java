package com.treebricks.priceybd.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.treebricks.priceybd.R;
import com.treebricks.priceybd.models.MobileDetail;
import com.treebricks.priceybd.rest.ApiClient;
import com.treebricks.priceybd.rest.ApiInterface;

import java.util.ArrayList;

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

        ArrayList<TextView> allTextView = new ArrayList<TextView>();

        // Start
        TextView technology = (TextView) rootView.findViewById(R.id.technology);
        allTextView.add(technology);

        TextView bands2g = (TextView) rootView.findViewById(R.id.bands_2g);
        allTextView.add(bands2g);

        TextView bands3g = (TextView) rootView.findViewById(R.id.bands_3g);
        allTextView.add(bands3g);

        TextView bands4g = (TextView) rootView.findViewById(R.id.bands_4g);
        allTextView.add(bands4g);

        TextView speed = (TextView) rootView.findViewById(R.id.speed);
        allTextView.add(speed);

        TextView gprs = (TextView) rootView.findViewById(R.id.gprs);
        allTextView.add(gprs);

        TextView edge = (TextView) rootView.findViewById(R.id.edge);
        allTextView.add(edge);

        TextView announced = (TextView) rootView.findViewById(R.id.announced);
        allTextView.add(announced);

        TextView status = (TextView) rootView.findViewById(R.id.status);
        allTextView.add(status);

        TextView dimensions = (TextView) rootView.findViewById(R.id.dimensions);
        allTextView.add(dimensions);

        TextView weight = (TextView) rootView.findViewById(R.id.weight);
        allTextView.add(weight);

        TextView sim = (TextView) rootView.findViewById(R.id.sim);
        allTextView.add(sim);

        TextView bodyfeatures = (TextView) rootView.findViewById(R.id.body_features);
        allTextView.add(bodyfeatures);

        TextView displaytype = (TextView) rootView.findViewById(R.id.display_type);
        allTextView.add(displaytype);

        TextView displaysize = (TextView) rootView.findViewById(R.id.display_size);
        allTextView.add(displaysize);

        TextView resolution = (TextView) rootView.findViewById(R.id.resolution);
        allTextView.add(resolution);

        TextView protection = (TextView) rootView.findViewById(R.id.protection);
        allTextView.add(protection);

        TextView displayfeatures = (TextView) rootView.findViewById(R.id.display_features);
        allTextView.add(displayfeatures);

        TextView os = (TextView) rootView.findViewById(R.id.os);
        allTextView.add(os);

        TextView chipset = (TextView) rootView.findViewById(R.id.chipset);
        allTextView.add(chipset);

        TextView cpu = (TextView) rootView.findViewById(R.id.cpu);
        allTextView.add(cpu);

        TextView gpu = (TextView) rootView.findViewById(R.id.gpu);
        allTextView.add(gpu);

        TextView ram = (TextView) rootView.findViewById(R.id.ram);
        allTextView.add(ram);

        TextView internalmemory = (TextView) rootView.findViewById(R.id.internal_memory);
        allTextView.add(internalmemory);

        TextView externalmemory = (TextView) rootView.findViewById(R.id.external_memory);
        allTextView.add(externalmemory);

        TextView primarycamera = (TextView) rootView.findViewById(R.id.primary_camera);
        allTextView.add(primarycamera);

        TextView secondarycamera = (TextView) rootView.findViewById(R.id.secondary_camera);
        allTextView.add(secondarycamera);

        TextView video = (TextView) rootView.findViewById(R.id.video);
        allTextView.add(video);

        TextView camerafeatures = (TextView) rootView.findViewById(R.id.camera_features);
        allTextView.add(camerafeatures);

        TextView alerttype = (TextView) rootView.findViewById(R.id.alert_type);
        allTextView.add(alerttype);

        TextView loudspeaker = (TextView) rootView.findViewById(R.id.loudspeaker);
        allTextView.add(loudspeaker);

        TextView audiojack = (TextView) rootView.findViewById(R.id.audio_jack);
        allTextView.add(audiojack);

        TextView soundfeatures = (TextView) rootView.findViewById(R.id.sound_features);
        allTextView.add(soundfeatures);

        TextView wifi = (TextView) rootView.findViewById(R.id.wifi);
        allTextView.add(wifi);

        TextView bluetooth = (TextView) rootView.findViewById(R.id.bluetooth);
        allTextView.add(bluetooth);

        TextView gps = (TextView) rootView.findViewById(R.id.gps);
        allTextView.add(gps);

        TextView nfc = (TextView) rootView.findViewById(R.id.nfc);
        allTextView.add(nfc);

        TextView radio = (TextView) rootView.findViewById(R.id.radio);
        allTextView.add(radio);

        TextView usb = (TextView) rootView.findViewById(R.id.usb);
        allTextView.add(usb);

        TextView sensors = (TextView) rootView.findViewById(R.id.sensors);
        allTextView.add(sensors);

        TextView messaging = (TextView) rootView.findViewById(R.id.messaging);
        allTextView.add(messaging);

        TextView browser = (TextView) rootView.findViewById(R.id.browser);
        allTextView.add(browser);

        TextView java = (TextView) rootView.findViewById(R.id.java);
        allTextView.add(java);

        TextView extrafeatures = (TextView) rootView.findViewById(R.id.extra_features);
        allTextView.add(extrafeatures);

        TextView batterycapacity = (TextView) rootView.findViewById(R.id.battery_capacity);
        allTextView.add(batterycapacity);

        TextView talktime = (TextView) rootView.findViewById(R.id.talktime);
        allTextView.add(talktime);

        TextView musicplay = (TextView) rootView.findViewById(R.id.musicplay);
        allTextView.add(musicplay);

        TextView colors = (TextView) rootView.findViewById(R.id.colors);
        allTextView.add(colors);

        TextView performance = (TextView) rootView.findViewById(R.id.performance);
        allTextView.add(performance);

        Bundle recivedBundle = getArguments();

        int mobileId = 1;
        if(recivedBundle != null)
        {
            mobileId = recivedBundle.getInt(MOBILE_ID);
        }

        new SpecificaitonTask(SpecificationFragment.this.getContext(), mobileId, allTextView).execute();

        return rootView;
    }

    class SpecificaitonTask extends AsyncTask<Void, Void, Void>
    {
        ProgressDialog progress;
        int mobileId;
        Context context;
        ArrayList<TextView> allTextView;

        public SpecificaitonTask(Context context, int mobileId, ArrayList<TextView> allTextView)
        {
            this.context = context;
            this.mobileId = mobileId;
            this.allTextView = allTextView;
        }

        @Override
        protected void onPreExecute() {
            progress = ProgressDialog.show(context, "Loading","Please Wait", true);
        }

        @Override
        protected Void doInBackground(Void... Voids) {


            ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

            Call<MobileDetail> call = apiInterface.getMobileDetail(mobileId);
            call.enqueue(new Callback<MobileDetail>() {
                @Override
                public void onResponse(Call<MobileDetail> call, Response<MobileDetail> response) {

                    MobileDetail mobileDetail = response.body();

                    allTextView.get(0).setText(mobileDetail.getNetTechnology());
                    allTextView.get(1).setText(mobileDetail.get_2GBands());
                    allTextView.get(2).setText(mobileDetail.get_3GBands());
                    allTextView.get(3).setText(mobileDetail.get_4GBands());
                    allTextView.get(4).setText(mobileDetail.getSpeed());
                    allTextView.get(5).setText(mobileDetail.getgPRS());
                    allTextView.get(6).setText(mobileDetail.geteDGE());
                    allTextView.get(7).setText(mobileDetail.getAnnounced());
                    allTextView.get(8).setText(mobileDetail.getStatus());
                    allTextView.get(9).setText(mobileDetail.getBodyDimensions());
                    allTextView.get(10).setText(mobileDetail.getBodyWeight());
                    allTextView.get(11).setText(mobileDetail.getSimType());
                    allTextView.get(12).setText(mobileDetail.getBodyFeatures());
                    allTextView.get(13).setText(mobileDetail.getDisplayType());
                    allTextView.get(14).setText(mobileDetail.getDisplaySize() + " inches");
                    allTextView.get(15).setText(mobileDetail.getDisplayResolution());
                    allTextView.get(16).setText(mobileDetail.getDisplayProtection());
                    allTextView.get(17).setText(mobileDetail.getDisplayFeatures());
                    allTextView.get(18).setText(mobileDetail.getOs());
                    allTextView.get(19).setText(mobileDetail.getChipset());
                    allTextView.get(20).setText(mobileDetail.getCpuType());
                    allTextView.get(21).setText(mobileDetail.getGpu());
                    allTextView.get(22).setText(mobileDetail.getMemoryRam() + " GB");
                    allTextView.get(23).setText(mobileDetail.getMemoryOption());
                    allTextView.get(24).setText(mobileDetail.getMemoryExpand());
                    allTextView.get(25).setText(mobileDetail.getPrimaryCameraFeatures());
                    allTextView.get(26).setText(mobileDetail.getSecondaryCameraFeatures());
                    allTextView.get(27).setText(mobileDetail.getVideo());
                    allTextView.get(28).setText(mobileDetail.getCameraFeatures());
                    allTextView.get(29).setText(mobileDetail.getSoundAlertTypes());
                    allTextView.get(30).setText(mobileDetail.getSoundLoudspeaker());
                    allTextView.get(31).setText(mobileDetail.getSoundJack());
                    allTextView.get(32).setText(mobileDetail.getSoundFeatures());
                    allTextView.get(33).setText(mobileDetail.getWifi());
                    allTextView.get(34).setText(mobileDetail.getBluetooth());
                    allTextView.get(35).setText(mobileDetail.getGps());
                    allTextView.get(36).setText(mobileDetail.getNfc());
                    allTextView.get(37).setText(mobileDetail.getRadio());
                    allTextView.get(38).setText(mobileDetail.getUsb());
                    allTextView.get(39).setText(mobileDetail.getSensors());
                    allTextView.get(40).setText(mobileDetail.getMessaging());
                    allTextView.get(41).setText(mobileDetail.getBrowser());
                    allTextView.get(42).setText(mobileDetail.getmJava());
                    allTextView.get(43).setText(mobileDetail.getOtherFeatures());
                    allTextView.get(44).setText(mobileDetail.getBatteryType());
                    allTextView.get(45).setText(mobileDetail.getBatteryTalktime());
                    allTextView.get(46).setText(mobileDetail.getBatteryMusicplay());
                    allTextView.get(47).setText(mobileDetail.getColors());
                    allTextView.get(48).setText(mobileDetail.getPerformance());

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
