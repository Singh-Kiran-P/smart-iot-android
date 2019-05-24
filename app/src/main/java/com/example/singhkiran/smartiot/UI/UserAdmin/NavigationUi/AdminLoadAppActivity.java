package com.example.singhkiran.smartiot.UI.UserAdmin.NavigationUi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.singhkiran.smartiot.JsonRequests.Login.Login_Model;
import com.example.singhkiran.smartiot.R;
import com.example.singhkiran.smartiot.UI.Auth.LoginActivity;
import com.example.singhkiran.smartiot.UI.UserAdmin.NavigationUi.Fragments.Side_Nav.Fragment_Iot;
import com.example.singhkiran.smartiot.UI.UserAdmin.NavigationUi.Fragments.Side_Nav.Fragment_Logs;
import com.example.singhkiran.smartiot.UI.UserAdmin.NavigationUi.Fragments.Side_Nav.Fragment_Mainpage;
import com.example.singhkiran.smartiot.UI.UserAdmin.NavigationUi.Fragments.Side_Nav.Fragment_Profile;
import com.google.android.material.navigation.NavigationView;

public class AdminLoadAppActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_nav_activity_load_app);
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

        TextView navEmail = navigationView.getHeaderView(0).findViewById(R.id.nav_header_Email);
        navEmail.setText(login_response.getEmail());

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();


        ft.replace(R.id.screen_area, new Fragment_Mainpage());
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
        getMenuInflater().inflate(R.menu.admin_main, menu);
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

        if (id == R.id.nav_profile) {
            fragment = new Fragment_Profile();
        } else if (id == R.id.nav_iot) {
            fragment = new Fragment_Iot();

        } else if (id == R.id.nav_logs) {
            fragment = new Fragment_Logs();

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


        ft.replace(R.id.screen_area, new Fragment_Mainpage());
        ft.commit();
    }

    public void showPolicy(MenuItem item) {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/smartiot2456/")));
        } catch (Exception e) {

        }
    }
}
