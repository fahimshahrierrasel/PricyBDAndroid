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
    public static final String CATAGORY = "CATAGORY";
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
    private String title,catagory;


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
        catagory = getIntent().getStringExtra(CATAGORY);

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


        final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<AllShortDetails> call = apiInterface.getAllMobileShortDetail();;
        if ("Normal".equals(catagory))
        {
            call = apiInterface.getAllMobileShortDetail();
        }
        else if("Brand".equals(catagory))
        {
            call = apiInterface.getDeviceByBrand(title);
        }

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
                fabMenu.close(true);
            }
        });

        mShadowView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                fabMenu.close(true);
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

        final MaterialDialog progressDialog = new MaterialDialog.Builder(this)
                .title("Getting the data from Database")
                .content("Please wait...")
                .progress(true, 0)
                .progressIndeterminateStyle(true)
                .build();


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

                                progressDialog.show();

                                Call<AllShortDetails> call = apiInterface.sortDeviceByBattery(Integer.parseInt(input.toString()));

                                call.enqueue(new Callback<AllShortDetails>() {
                                    @Override
                                    public void onResponse(Call<AllShortDetails> call, Response<AllShortDetails> response)
                                    {
                                        ArrayList<MobileShortDetail> allDevices = (ArrayList<MobileShortDetail>) response.body().getDevices();

                                        DeviceShortDetailAdapter allDevicesAdapter = new DeviceShortDetailAdapter(AllDevice.this, allDevices, allDevices.size());
                                        allDevicesGridRecycler.setAdapter(new SlideInBottomAnimationAdapter(allDevicesAdapter));
                                        progressDialog.dismiss();
                                    }

                                    @Override
                                    public void onFailure(Call<AllShortDetails> call, Throwable t) {
                                        progressDialog.dismiss();
                                    }
                                });

                            }
                        }).show();
            }
        });



        fabRom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                fabMenu.close(false);
                new MaterialDialog.Builder(view.getContext())
                        .title("Rom")
                        .content("How much Rom do you want on your device?")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .inputRange(2,3, ResourcesCompat.getColor(getResources(), R.color.md_red_500, null))
                        .input("Rom", "16", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {

                                progressDialog.show();

                                Call<AllShortDetails> call = apiInterface.sortDeviceByRom(Integer.parseInt(input.toString()));

                                call.enqueue(new Callback<AllShortDetails>() {
                                    @Override
                                    public void onResponse(Call<AllShortDetails> call, Response<AllShortDetails> response)
                                    {
                                        ArrayList<MobileShortDetail> allDevices = (ArrayList<MobileShortDetail>) response.body().getDevices();

                                        DeviceShortDetailAdapter allDevicesAdapter = new DeviceShortDetailAdapter(AllDevice.this, allDevices, allDevices.size());
                                        allDevicesGridRecycler.setAdapter(new SlideInBottomAnimationAdapter(allDevicesAdapter));
                                        progressDialog.dismiss();
                                    }

                                    @Override
                                    public void onFailure(Call<AllShortDetails> call, Throwable t) {
                                        progressDialog.dismiss();
                                    }
                                });

                            }
                        }).show();
            }
        });

        fabRam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                fabMenu.close(false);
                new MaterialDialog.Builder(view.getContext())
                        .title("Ram")
                        .content("How much Ram do you want on your device?")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .inputRange(1,2, ResourcesCompat.getColor(getResources(), R.color.md_red_500, null))
                        .input("Ram", "2", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {

                                progressDialog.show();

                                Call<AllShortDetails> call = apiInterface.sortDeviceByRam(Integer.parseInt(input.toString()));

                                call.enqueue(new Callback<AllShortDetails>() {
                                    @Override
                                    public void onResponse(Call<AllShortDetails> call, Response<AllShortDetails> response)
                                    {
                                        ArrayList<MobileShortDetail> allDevices = (ArrayList<MobileShortDetail>) response.body().getDevices();

                                        DeviceShortDetailAdapter allDevicesAdapter = new DeviceShortDetailAdapter(AllDevice.this, allDevices, allDevices.size());
                                        allDevicesGridRecycler.setAdapter(new SlideInBottomAnimationAdapter(allDevicesAdapter));
                                        progressDialog.dismiss();
                                    }

                                    @Override
                                    public void onFailure(Call<AllShortDetails> call, Throwable t) {
                                        progressDialog.dismiss();
                                    }
                                });

                            }
                        }).show();
            }
        });

        fabSelfie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                fabMenu.close(false);
                new MaterialDialog.Builder(view.getContext())
                        .title("Secondary/Selfie Camera")
                        .content("What should be your selife camera on your device?")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .inputRange(1,2, ResourcesCompat.getColor(getResources(), R.color.md_red_500, null))
                        .input("Selfie Camera", "5", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {

                                progressDialog.show();

                                Call<AllShortDetails> call = apiInterface.sortDeviceBySelfieCamera(Integer.parseInt(input.toString()));

                                call.enqueue(new Callback<AllShortDetails>() {
                                    @Override
                                    public void onResponse(Call<AllShortDetails> call, Response<AllShortDetails> response)
                                    {
                                        ArrayList<MobileShortDetail> allDevices = (ArrayList<MobileShortDetail>) response.body().getDevices();

                                        DeviceShortDetailAdapter allDevicesAdapter = new DeviceShortDetailAdapter(AllDevice.this, allDevices, allDevices.size());
                                        allDevicesGridRecycler.setAdapter(new SlideInBottomAnimationAdapter(allDevicesAdapter));
                                        progressDialog.dismiss();
                                    }

                                    @Override
                                    public void onFailure(Call<AllShortDetails> call, Throwable t) {
                                        progressDialog.dismiss();
                                    }
                                });

                            }
                        }).show();
            }
        });

        fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                fabMenu.close(false);
                new MaterialDialog.Builder(view.getContext())
                        .title("Primary/Back Camera")
                        .content("What should be your primary camera on your device?")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .inputRange(1,2, ResourcesCompat.getColor(getResources(), R.color.md_red_500, null))
                        .input("Primary Camera", "12", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {

                                progressDialog.show();

                                Call<AllShortDetails> call = apiInterface.sortDeviceByPrimaryCamera(Integer.parseInt(input.toString()));

                                call.enqueue(new Callback<AllShortDetails>() {
                                    @Override
                                    public void onResponse(Call<AllShortDetails> call, Response<AllShortDetails> response)
                                    {
                                        ArrayList<MobileShortDetail> allDevices = (ArrayList<MobileShortDetail>) response.body().getDevices();

                                        DeviceShortDetailAdapter allDevicesAdapter = new DeviceShortDetailAdapter(AllDevice.this, allDevices, allDevices.size());
                                        allDevicesGridRecycler.setAdapter(new SlideInBottomAnimationAdapter(allDevicesAdapter));
                                        progressDialog.dismiss();
                                    }

                                    @Override
                                    public void onFailure(Call<AllShortDetails> call, Throwable t) {
                                        progressDialog.dismiss();
                                    }
                                });

                            }
                        }).show();
            }
        });


        fabCpu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                fabMenu.close(false);
                new MaterialDialog.Builder(view.getContext())
                        .title("CPU")
                        .content("What should be processing speed on your device?")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .inputRange(4,5, ResourcesCompat.getColor(getResources(), R.color.md_red_500, null))
                        .input("CPU", "1.2", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {

                                progressDialog.show();

                                Call<AllShortDetails> call = apiInterface.sortDeviceByProcessorSpeed(Float.parseFloat(input.toString()));

                                call.enqueue(new Callback<AllShortDetails>() {
                                    @Override
                                    public void onResponse(Call<AllShortDetails> call, Response<AllShortDetails> response)
                                    {
                                        ArrayList<MobileShortDetail> allDevices = (ArrayList<MobileShortDetail>) response.body().getDevices();

                                        DeviceShortDetailAdapter allDevicesAdapter = new DeviceShortDetailAdapter(AllDevice.this, allDevices, allDevices.size());
                                        allDevicesGridRecycler.setAdapter(new SlideInBottomAnimationAdapter(allDevicesAdapter));
                                        progressDialog.dismiss();
                                    }

                                    @Override
                                    public void onFailure(Call<AllShortDetails> call, Throwable t) {
                                        progressDialog.dismiss();
                                    }
                                });

                            }
                        }).show();
            }
        });

        fabPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                fabMenu.close(false);
                new MaterialDialog.Builder(view.getContext())
                        .title("Price")
                        .content("How many money do you want to spent on your device?")
                        .inputType(InputType.TYPE_CLASS_NUMBER)
                        .inputRange(4,8, ResourcesCompat.getColor(getResources(), R.color.md_red_500, null))
                        .input("Price", "15000", new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {

                                progressDialog.show();

                                Call<AllShortDetails> call = apiInterface.sortDeviceByPrice(Integer.parseInt(input.toString()));

                                call.enqueue(new Callback<AllShortDetails>() {
                                    @Override
                                    public void onResponse(Call<AllShortDetails> call, Response<AllShortDetails> response)
                                    {
                                        ArrayList<MobileShortDetail> allDevices = (ArrayList<MobileShortDetail>) response.body().getDevices();

                                        DeviceShortDetailAdapter allDevicesAdapter = new DeviceShortDetailAdapter(AllDevice.this, allDevices, allDevices.size());
                                        allDevicesGridRecycler.setAdapter(new SlideInBottomAnimationAdapter(allDevicesAdapter));
                                        progressDialog.dismiss();
                                    }

                                    @Override
                                    public void onFailure(Call<AllShortDetails> call, Throwable t) {
                                        progressDialog.dismiss();
                                    }
                                });

                            }
                        }).show();
            }
        });





    }
}
