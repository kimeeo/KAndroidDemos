package com.kimeeo.kAndroidDemos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.kimeeo.kAndroid.core.fragment.BaseFragment;
import com.kimeeo.kAndroidDemos.recycleView.RecyclerViewHorizontal;
import com.kimeeo.kAndroidDemos.recycleView.RecyclerViewVertical;
import com.kimeeo.kAndroidDemos.services.okhttp.OkHTTPRecyclerViewVertical;
import com.kimeeo.kAndroidDemos.services.retrofilt.RetrofitRecyclerViewVertical;
import com.kimeeo.kAndroidDemos.services.rss.RSSRecyclerViewVertical;

import java.util.HashMap;
import java.util.Map;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        views.put(R.id.nav_recycle_view_vertical_list, RecyclerViewVertical.class);
        views.put(R.id.nav_recycle_view_horizontal_list, RecyclerViewHorizontal.class);

        views.put(R.id.nav_a_q, RecyclerViewVertical.class);
        views.put(R.id.nav_retrofit, RetrofitRecyclerViewVertical.class);
        views.put(R.id.nav_ok_http, OkHTTPRecyclerViewVertical.class);
        views.put(R.id.nav_rss, RSSRecyclerViewVertical.class);


        loadView(R.id.nav_recycle_view_vertical_list);
    }

    Map<Integer,Class> views = new HashMap<>();
    private void loadView(int id) {
        Class clazz=views.get(id);
        if(clazz!=null)
        {
            Fragment view =BaseFragment.newInstance(clazz);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentHolder, view).commit();
        }
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
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        loadView(id);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
