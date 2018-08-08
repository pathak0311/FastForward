package com.example.android.fastforward;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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

        //This is to make Home Screen as the Main Screen of the App.
        Fragment fragment = new Fragment1();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //Replaces the current frame with the new fragment.
        ft.replace(R.id.content_frame, fragment);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;

        //Setting which fragment is to be launched when a menu item is pressed.

        if (id == R.id.home) {
            //This is to distinguish the selected menu item from the rest.
            item.setChecked(true);
            fragment = new Fragment1();
        } else if (id == R.id.about) {
            item.setChecked(true);
            fragment = new Fragment2();
        } else if (id == R.id.involve) {
            item.setChecked(true);
            fragment = new Fragment3();
        } else if (id == R.id.gallery) {
            item.setChecked(true);
            fragment = new Fragment4();
        } else if (id == R.id.Jagriti) {
            item.setChecked(true);
            fragment = new FragmentJ();
        } else if (id == R.id.Escape) {
            item.setChecked(true);
            fragment = new FragmentE();
        } else if (id == R.id.Disha) {
            item.setChecked(true);
            fragment = new FragmentD();
        } else if (id == R.id.BloodLine) {
            item.setChecked(true);
            fragment = new FragmentBL();
        } else if (id == R.id.catchus) {
            item.setChecked(true);
            fragment = new Communicate();
        }

        //Launchs the corressponding Fragment.
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openJagriti(View view){
        //Intent is used to go from present activity to another activity.
        Intent intent = new Intent(MainActivity.this, Jagriti.class);
        startActivity(intent);
    }

    public void openEscape(View view){
        Intent intent = new Intent(MainActivity.this, Escape.class);
        startActivity(intent);
    }

    public void openBloodLine(View view){
        Intent intent = new Intent(MainActivity.this, BloodLine.class);
        startActivity(intent);
    }

    public void openDisha(View view){
        Intent intent = new Intent(MainActivity.this, Disha.class);
        startActivity(intent);
    }

    public void fb (View view) {
        goToUrl ( "https://www.facebook.com/FastForwardIndia");
    }

    public void youtube (View view) {
        goToUrl ( "https://www.youtube.com/watch?v=W-MSTZAIReU");
    }

    public void insta (View view) {
        goToUrl ( "https://www.instagram.com/ffichanginglives/");
    }

    public void twitter (View view) {
        goToUrl ( "https://twitter.com/fastforwrdindia");
    }

    //Calling the browser for opening the link.
    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
}
