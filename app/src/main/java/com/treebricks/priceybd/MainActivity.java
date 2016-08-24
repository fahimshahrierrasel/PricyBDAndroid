package com.treebricks.priceybd;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.treebricks.priceybd.banner.BannerAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    String[] images = {
            "http://cdn2.gsmarena.com/vv/bigpic/samsung-galaxy-note7.jpg",
            "http://cdn2.gsmarena.com/vv/pics/apple/apple-iphone-se-00.jpg",
            "http://cdn2.gsmarena.com/vv/pics/apple/apple-iphone-6s-1.jpg"
    };

    int[] drawableImages = {
            R.drawable.note7,
            R.drawable.iphone_se,
            R.drawable.iphone_6s
    };
    String[] names = {
            "Samsung Galaxy Note 7",
            "IPhone SE",
            "IPhone 6S"
    };

    RelativeLayout root;
    RecyclerView bannerRecyclerView;
    Handler handler;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        root = (RelativeLayout) findViewById(R.id.root);
        bannerRecyclerView = (RecyclerView) findViewById(R.id.banner_recycler_view);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        LinearLayoutManager bannerLinearLayoutManager =
                new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);

        bannerRecyclerView.setLayoutManager(bannerLinearLayoutManager);

        BannerAdapter bannerAdapter = new BannerAdapter(this, drawableImages);

        bannerRecyclerView.setAdapter(bannerAdapter);

        handler = new Handler();

        startRepeatingTask();


        // Navigation Drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    Runnable runnableCode = new Runnable() {
        @Override
        public void run() {
            try{
                bannerRecyclerView.scrollToPosition(counter);
            }finally {
                counter++;
                if(counter > images.length-1)
                {
                    counter = 0;
                }
                Log.d("Runnable", "Runable Repeting");
                handler.postDelayed(runnableCode, 5000);
            }
        }
    };

    void startRepeatingTask() {
        Log.d("Runnable", "Runable Started");
        runnableCode.run();
    }

    void stopRepeatingTask() {
        Log.d("Runnable", "Runable removed");
        handler.removeCallbacks(runnableCode);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopRepeatingTask();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
