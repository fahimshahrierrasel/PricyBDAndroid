package com.treebricks.priceybd.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.treebricks.priceybd.R;

public class ShopActivity extends AppCompatActivity implements OnMapReadyCallback {

    public static final String SHOP_NAME = "SHOP_NAME";
    public static final String SHOP_ADDRESS = "SHOP_ADDRESS";
    public static final String SHOP_MOBILE_NUMBER = "SHOP_MOBILE_NUMBER";
    public static final String SHOP_EMAIL = "SHOP_EMAIL";
    public static final String LATITUDE = "LATITUDE";
    public static final String LONGITUDE = "LONGITUDE";
    String shopName;
    String shopAddress;
    String shopMobile;
    String shopEmail;
    double latitude;
    double longitude;
    TextView shopNameTextView;
    TextView shopAddressTextView;
    TextView shopMobileTextView;
    TextView shopEmailTextView;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        shopNameTextView = (TextView) findViewById(R.id.shop_name_collapse);
        shopAddressTextView = (TextView) findViewById(R.id.address);
        shopMobileTextView = (TextView) findViewById(R.id.mobile_number);
        shopEmailTextView = (TextView) findViewById(R.id.email);
        supportPostponeEnterTransition();

        Bundle receivedBundle = getIntent().getExtras();

        if(receivedBundle != null)
        {
            shopName = receivedBundle.getString(SHOP_NAME);
            shopAddress = receivedBundle.getString(SHOP_ADDRESS);
            shopMobile = receivedBundle.getString(SHOP_MOBILE_NUMBER);
            shopEmail = receivedBundle.getString(SHOP_EMAIL);
            latitude = Double.parseDouble(receivedBundle.getString(LATITUDE));
            longitude = Double.parseDouble(receivedBundle.getString(LONGITUDE));
        }

        shopNameTextView.setText(shopName);
        shopAddressTextView.setText(shopAddress);
        shopMobileTextView.setText(shopMobile);
        shopEmailTextView.setText(shopEmail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle(shopName);
        collapsingToolbarLayout.setExpandedTitleColor(ResourcesCompat.getColor(getResources(), android.R.color.transparent, null));



        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Calling " + shopName + "("+ shopMobile +")", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng shopLocation = new LatLng(latitude, longitude);

        mMap.addMarker(new MarkerOptions().position(shopLocation).title(shopName));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(shopLocation,16.5f));
        mMap.setMinZoomPreference(10f);
        mMap.setMaxZoomPreference(20f);
    }
}
