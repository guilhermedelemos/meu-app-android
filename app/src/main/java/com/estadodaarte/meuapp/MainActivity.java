package com.estadodaarte.meuapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.estadodaarte.meuapp.controller.MainController;
import com.estadodaarte.meuapp.view.DeviceActivity;
import com.estadodaarte.octopet.BaseController;
import com.estadodaarte.octopet.Device;

import static android.Manifest.permission.READ_PHONE_STATE;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private BaseController controller;

    public static final int MY_PERMISSIONS_READ_PHONE_STATE = 99;
    private int permissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        this.controller = new MainController();
        this.permissions = 0;
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
        if (id == R.id.action_bug_reporting) {
            // ACTION BUG REPORTING - TODO Bug Reporting
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_exit) {
            //System.exit(0);
            this.finishAffinity();
        } else if (id == R.id.nav_about) {
            //this.controller.StartActivity(this, view);
        } else if (id == R.id.nav_settings) {
            //
        } else if (id == R.id.nav_device) {
            this.startActivity(new Intent(this, DeviceActivity.class));
        } else if (id == R.id.nav_flex_calculator) {
            //
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        checkAndroidPermissions();
    }

    private void checkAndroidPermissions() {
        if(this.permissions > 0) {
            return;
        }
        this.permissions++;
        if ( checkPermission(READ_PHONE_STATE, android.os.Process.myPid(), android.os.Process.myUid()) != android.content.pm.PackageManager.PERMISSION_GRANTED ) {
            if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                ActivityCompat.requestPermissions(this, new String[] {READ_PHONE_STATE}, MY_PERMISSIONS_READ_PHONE_STATE);
            }
        }
    }

}
