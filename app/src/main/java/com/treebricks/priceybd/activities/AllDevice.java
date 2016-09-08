package com.treebricks.priceybd.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
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
    private RecyclerView allDevicesGridRecycler;
    private View mShadowView;
    private FloatingActionMenu fabMenu;
    private FloatingActionButton fabPrice;
    private FloatingActionButton fabCpu;
    private FloatingActionButton fabCamera;
    private FloatingActionButton fabSelfie;
    private FloatingActionButton fabRam;
    private FloatingActionButton fabRom;
    private FloatingActionButton fabBattery;
    private String title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alldevice);

        allDevicesGridRecycler = (RecyclerView) findViewById(R.id.all_devices_grid);
        fabMenu = (FloatingActionMenu) findViewById(R.id.menu);
        fabBattery = (FloatingActionButton) findViewById(R.id.fab_battery);
        fabRom = (FloatingActionButton) findViewById(R.id.fab_rom);
        fabRam = (FloatingActionButton) findViewById(R.id.fab_ram);
        fabSelfie = (FloatingActionButton) findViewById(R.id.fab_selfie);
        fabCamera = (FloatingActionButton) findViewById(R.id.fab_camera);
        fabCpu = (FloatingActionButton) findViewById(R.id.fab_cpu);
        fabPrice = (FloatingActionButton) findViewById(R.id.fab_price);
        mShadowView = findViewById(R.id.shadowView);

        title = getIntent().getStringExtra(TITLE);

        if(getSupportActionBar() != null)
        {
            getSupportActionBar().setTitle(title);
        }

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

        mShadowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // No action taken for making alpha screen unresponsive
            }
        });

        mShadowView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                // No action taken for making alpha screen unresponsive
                return false;
            }
        });


        fabMenu.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
            @Override
            public void onMenuToggle(boolean opened) {
                if(fabMenu.isOpened())
                {
                    mShadowView.setVisibility(View.VISIBLE);
                }
                else {
                    mShadowView.setVisibility(View.GONE);
                }
            }
        });

        fabMenu.setClosedOnTouchOutside(true);

        fabBattery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                fabMenu.close(false);
                new MaterialDialog.Builder(view.getContext())
                        .title("Battery")
                        .content("How much Battery capacity do you want on your device?")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .inputRange(4,5, ResourcesCompat.getColor(getResources(), R.color.md_red_500, null))
                        .input("Battery Capacity", "3000", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {

                                Toast.makeText(view.getContext(), "Battery Capacity: " + input +" MAh", Toast.LENGTH_SHORT).show();

                            }
                        }).show();
            }
        });



        fabRom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                new MaterialDialog.Builder(view.getContext())
                        .title("Rom")
                        .content("How much Rom do you want on your device?")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .inputRange(2,3, ResourcesCompat.getColor(getResources(), R.color.md_red_500, null))
                        .input("Rom", "16", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {

                                Toast.makeText(view.getContext(), "Rom: " + input + " GB", Toast.LENGTH_SHORT).show();

                            }
                        }).show();
            }
        });

        fabRam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                new MaterialDialog.Builder(view.getContext())
                        .title("Ram")
                        .content("How much Ram do you want on your device?")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .inputRange(1,2, ResourcesCompat.getColor(getResources(), R.color.md_red_500, null))
                        .input("Ram", "16", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {

                                Toast.makeText(view.getContext(), "Ram: " + input + " GB", Toast.LENGTH_SHORT).show();

                            }
                        }).show();
            }
        });

        fabSelfie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                new MaterialDialog.Builder(view.getContext())
                        .title("Secondary/Selfie Camera")
                        .content("What should be your selife camera on your device?")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .inputRange(1,2, ResourcesCompat.getColor(getResources(), R.color.md_red_500, null))
                        .input("Selfie Camera", "5", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {

                                Toast.makeText(view.getContext(), "Selfie Camera: " + input + " MP", Toast.LENGTH_SHORT).show();

                            }
                        }).show();
            }
        });

        fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                new MaterialDialog.Builder(view.getContext())
                        .title("Primary/Back Camera")
                        .content("What should be your primary camera on your device?")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .inputRange(1,2, ResourcesCompat.getColor(getResources(), R.color.md_red_500, null))
                        .input("Primary Camera", "12", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {

                                Toast.makeText(view.getContext(), "Primary Camera: " + input + " MP", Toast.LENGTH_SHORT).show();

                            }
                        }).show();
            }
        });


        fabCpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                new MaterialDialog.Builder(view.getContext())
                        .title("CPU")
                        .content("What should be processing speed on your device?")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .inputRange(4,5, ResourcesCompat.getColor(getResources(), R.color.md_red_500, null))
                        .input("CPU", "1.2", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {

                                Toast.makeText(view.getContext(), "CPU: " + input + " GHz", Toast.LENGTH_SHORT).show();

                            }
                        }).show();
            }
        });

        fabPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                new MaterialDialog.Builder(view.getContext())
                        .title("Price")
                        .content("How many money do you want to spent on your device?")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .inputRange(4,8, ResourcesCompat.getColor(getResources(), R.color.md_red_500, null))
                        .input("Price", "15000", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {

                                Toast.makeText(view.getContext(), "Price: " + input + " BDT", Toast.LENGTH_SHORT).show();

                            }
                        }).show();
            }
        });





    }
}
