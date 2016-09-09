package com.treebricks.priceybd.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.treebricks.priceybd.R;
import com.treebricks.priceybd.adapters.BrandsAdapter;
import com.treebricks.priceybd.adapters.DeviceShortDetailAdapter;
import com.treebricks.priceybd.models.AllBrands;
import com.treebricks.priceybd.models.AllShortDetails;
import com.treebricks.priceybd.models.Brand;
import com.treebricks.priceybd.models.MobileShortDetail;
import com.treebricks.priceybd.rest.ApiClient;
import com.treebricks.priceybd.rest.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
{

    public static final String TITLE = "TITLE";
    public static final String CATAGORY = "CATAGORY";

    private Drawer result = null;
    private AccountHeader accountHeader = null;

    int[] bannerImages = {
            R.drawable.power_bank,
            R.drawable.cover_photo
    };

    RecyclerView trendingRecyclerView;
    RecyclerView brandRecyclerView;
    RecyclerView newArrivalRecyclerView;
    Button trendingMoreButton;
    Button brandMoreButton;
    Button newArrivalMoreButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // RollViewPager for Banners
        RollPagerView mLoopViewPager = (RollPagerView) findViewById(R.id.banner_view_pager);
        mLoopViewPager.setHintView(null);
        mLoopViewPager.setPlayDelay(3000);

        // Adapter for RollViewPager declared below.
        TestLoopAdapter mLoopAdapter = new TestLoopAdapter(mLoopViewPager);
        mLoopAdapter.setImgs(bannerImages);
        mLoopViewPager.setAdapter(mLoopAdapter);

        // RollViewPager onClick Listener
        mLoopViewPager.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this,"Item "+position+" clicked",Toast.LENGTH_SHORT).show();
            }
        });


        // Trending RecyclerView
        trendingRecyclerView = (RecyclerView) findViewById(R.id.trending_recycler_view);
        LinearLayoutManager trendingLinearLayoutManager =
                new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        trendingRecyclerView.setLayoutManager(trendingLinearLayoutManager);


        trendingMoreButton = (Button) findViewById(R.id.trending_more_button);

        trendingMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent allDevicesIntent = new Intent(MainActivity.this, AllDevice.class);
                allDevicesIntent.putExtra(TITLE, "Trending");
                allDevicesIntent.putExtra(CATAGORY,"Normal");
                startActivity(allDevicesIntent);
            }
        });

        // New Arrival RecyclerView
        newArrivalRecyclerView = (RecyclerView) findViewById(R.id.new_arrival_recycler_view);
        LinearLayoutManager newArrivalLayoutManager =
                new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        newArrivalRecyclerView.setLayoutManager(newArrivalLayoutManager);


        newArrivalMoreButton = (Button) findViewById(R.id.new_arrival_more_button);
        newArrivalMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent allDevicesIntent = new Intent(MainActivity.this, AllDevice.class);
                allDevicesIntent.putExtra(TITLE, "New Arrival");
                allDevicesIntent.putExtra(CATAGORY,"Normal");
                startActivity(allDevicesIntent);
            }
        });



        // Brand RecyclerView
        brandRecyclerView = (RecyclerView) findViewById(R.id.brand_recycler_view);
        LinearLayoutManager brandLayoutManager =
                new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        brandRecyclerView.setLayoutManager(brandLayoutManager);





        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<AllShortDetails> allDevicesCall = apiInterface.getAllMobileShortDetail();

        allDevicesCall.enqueue(new Callback<AllShortDetails>() {
            @Override
            public void onResponse(Call<AllShortDetails> call, Response<AllShortDetails> response)
            {
                ArrayList<MobileShortDetail> allDevices = (ArrayList<MobileShortDetail>) response.body().getDevices();

                DeviceShortDetailAdapter trendingAdapter = new DeviceShortDetailAdapter(MainActivity.this, allDevices, allDevices.size());
                DeviceShortDetailAdapter newArrivalAdapter = new DeviceShortDetailAdapter(MainActivity.this, allDevices, allDevices.size());

                trendingRecyclerView.setAdapter(trendingAdapter);
                newArrivalRecyclerView.setAdapter(newArrivalAdapter);
            }

            @Override
            public void onFailure(Call<AllShortDetails> call, Throwable t) {

            }
        });

        Call<AllBrands> allBrandsCall = apiInterface.getBrands();

        allBrandsCall.enqueue(new Callback<AllBrands>() {
            @Override
            public void onResponse(Call<AllBrands> call, Response<AllBrands> response) {

                // Brand Adapter takes Drawable images and string array
                ArrayList<Brand> allBrands = (ArrayList<Brand>) response.body().getBrands();

                BrandsAdapter brandAdapter = new BrandsAdapter(MainActivity.this, allBrands, allBrands.size());
                brandRecyclerView.setAdapter(brandAdapter);

            }

            @Override
            public void onFailure(Call<AllBrands> call, Throwable t) {

            }
        });

        brandMoreButton = (Button) findViewById(R.id.brand_more_button);

        brandMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "All Brands Avilable soon!", Toast.LENGTH_SHORT).show();
            }
        });


        // Navigation Drawer
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        //        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.addDrawerListener(toggle);
        //toggle.syncState();

        //NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
       // navigationView.setNavigationItemSelectedListener(this);


        accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.cover_photo)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .build();




        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(accountHeader)
                .withShowDrawerOnFirstLaunch(true)
                .addDrawerItems(
                        new SecondaryDrawerItem().withName("Ram").withIcon(R.drawable.ic_memory).withIdentifier(1),
                        new SecondaryDrawerItem().withName("Rom").withIcon(R.drawable.ic_memory).withIdentifier(2),
                        new SecondaryDrawerItem().withName("Battery").withIcon(R.drawable.ic_battery).withIdentifier(3),
                        new SecondaryDrawerItem().withName("Selfie Camera").withIcon(R.drawable.ic_camera).withIdentifier(4),
                        new SecondaryDrawerItem().withName("Primary Camera").withIcon(R.drawable.ic_camera).withIdentifier(5),
                        new SecondaryDrawerItem().withName("Processor").withIcon(R.drawable.ic_platform).withIdentifier(6),
                        new ExpandableDrawerItem().withName("Expandable").withSubItems(
                                new SecondaryDrawerItem().withName("Launch").withIcon(R.drawable.ic_launch).withIdentifier(7),
                                new SecondaryDrawerItem().withName("Features").withIcon(R.drawable.ic_features).withIdentifier(8),
                                new SecondaryDrawerItem().withName("Miscellaneous").withIcon(R.drawable.ic_miscellaneous).withIdentifier(9)
                        ),
                        new SectionDrawerItem().withName("Other"),
                        new SecondaryDrawerItem().withName("Communication").withIcon(R.drawable.ic_communication).withIdentifier(10),
                        new SecondaryDrawerItem().withName("Display").withIcon(R.drawable.ic_display).withIdentifier(11)
                )
                .addStickyDrawerItems(
                        new SecondaryDrawerItem().withName("Preferences").withIcon(android.R.drawable.ic_menu_preferences).withIdentifier(12),
                        new SecondaryDrawerItem().withName("About").withIcon(android.R.drawable.ic_menu_info_details).withIdentifier(13)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        if(drawerItem != null)
                        {
                            switch ((int)drawerItem.getIdentifier())
                            {
                                case 1:
                                    Toast.makeText(MainActivity.this, "Item-"+drawerItem.getIdentifier(), Toast.LENGTH_SHORT ).show();
                                    break;
                                case 2:
                                    Toast.makeText(MainActivity.this, "Item-"+drawerItem.getIdentifier(), Toast.LENGTH_SHORT ).show();
                                    break;
                                case 3:
                                    Toast.makeText(MainActivity.this, "Item-"+drawerItem.getIdentifier(), Toast.LENGTH_SHORT ).show();
                                    break;
                                case 4:
                                    Toast.makeText(MainActivity.this, "Item-"+drawerItem.getIdentifier(), Toast.LENGTH_SHORT ).show();
                                    break;
                                case 5:
                                    Toast.makeText(MainActivity.this, "Item-"+drawerItem.getIdentifier(), Toast.LENGTH_SHORT ).show();
                                    break;
                                case 6:
                                    Toast.makeText(MainActivity.this, "Item-"+drawerItem.getIdentifier(), Toast.LENGTH_SHORT ).show();
                                    break;
                                case 7:
                                    Toast.makeText(MainActivity.this, "Item-"+drawerItem.getIdentifier(), Toast.LENGTH_SHORT ).show();
                                    break;
                                case 8:
                                    Toast.makeText(MainActivity.this, "Item-"+drawerItem.getIdentifier(), Toast.LENGTH_SHORT ).show();
                                    break;
                                case 9:
                                    Toast.makeText(MainActivity.this, "Item-"+drawerItem.getIdentifier(), Toast.LENGTH_SHORT ).show();
                                    break;
                                case 10:
                                    Toast.makeText(MainActivity.this, "Item-"+drawerItem.getIdentifier(), Toast.LENGTH_SHORT ).show();
                                    break;
                                case 11:
                                    Toast.makeText(MainActivity.this, "Item-"+drawerItem.getIdentifier(), Toast.LENGTH_SHORT ).show();
                                    break;
                                case 12:
                                    Toast.makeText(MainActivity.this, "Item-"+drawerItem.getIdentifier(), Toast.LENGTH_SHORT ).show();
                                    break;
                                case 13:
                                    Toast.makeText(MainActivity.this, "Item-"+drawerItem.getIdentifier(), Toast.LENGTH_SHORT ).show();
                                    break;
                                default:
                                    Toast.makeText(MainActivity.this, "Default", Toast.LENGTH_SHORT ).show();
                                    break;
                            }
                        }

                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();



    }

    @Override
    public void onBackPressed() {
        if (result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }




    // TestLoopAdapter for RollViewPager Which is used for Home Page banner
    private class TestLoopAdapter extends LoopPagerAdapter {
        int[] imgs;

        public void setImgs(int[] imgs){
            this.imgs = imgs;
            notifyDataSetChanged();
        }


        public TestLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            Log.i("RollViewPager","getView:"+imgs[position]);

            ImageView view = new ImageView(container.getContext());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("RollViewPager","onClick");
                }
            });
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            view.setImageDrawable(ResourcesCompat.getDrawable(getResources(), imgs[position], null));

            return view;
        }

        @Override
        public int getRealCount() {
            return imgs.length;
        }

    }
}
