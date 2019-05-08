package com.example.singhkiran.smartiot.UI.UserNormal.NavigationUi;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Model;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.Auth.LoginActivity;
import com.example.singhkiran.smartiot.UI.UserNormal.NavigationUi.Fragments.Side_Nav.Fragment_Profile;
import com.example.singhkiran.smartiot.UI.UserNormal.NavigationUi.Fragments.Side_Nav.fragment_mainpage;

public class LoadAppActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nrml_nav_activity_load_app);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Intent intent = getIntent();
        Login_Model login_response = (Login_Model) intent.getSerializableExtra("info");


        TextView navName = navigationView.getHeaderView(0).findViewById(R.id.nav_header_Name);
        navName.setText(login_response.getUsername());

        TextView navEmail =  navigationView.getHeaderView(0).findViewById(R.id.nav_header_Email);
        navEmail.setText(login_response.getEmail());

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();


        ft.replace(R.id.screen_area, new fragment_mainpage());
        ft.commit();

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
        getMenuInflater().inflate(R.menu.nrml_main, menu);
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
        Fragment fragment = null;

        int id = item.getItemId();

        if (id == R.id.nav_account) {
            fragment = new Fragment_Profile();
        } else if (id == R.id.nav_gallery) {
            fragment = new fragment_mainpage();

        } else if (id == R.id.nav_slideshow) {
            fragment = new fragment_mainpage();

        } else if (id == R.id.nav_manage) {
            fragment = new fragment_mainpage();

        } else if (id == R.id.nav_share) {
            fragment = new fragment_mainpage();

        } else if (id == R.id.nav_send) {

        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();


            ft.replace(R.id.screen_area, fragment);
            ft.commit();


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void logout(MenuItem item) {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }

    public void goTo_Home(View view) {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();


        ft.replace(R.id.screen_area, new fragment_mainpage());
        ft.commit();
    }

    public void showPolicy(MenuItem item) {
        try{
            startActivity( new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/smartiot2456/")));
        }catch (Exception e ){

        }
    }
}
