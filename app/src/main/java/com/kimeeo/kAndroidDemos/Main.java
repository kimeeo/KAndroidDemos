package com.kimeeo.kAndroidDemos;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.kimeeo.kAndroid.core.fragment.BaseFragment;
import com.kimeeo.kAndroidDemos.bindingDemo.RecyclerView;
import com.kimeeo.kAndroidDemos.map.MapView;
import com.kimeeo.kAndroidDemos.recycleView.ProfileBasedListView;
import com.kimeeo.kAndroidDemos.recycleView.adapterLayout.HorizontalLinearLayoutAdapterLayoutView;
import com.kimeeo.kAndroidDemos.recycleView.adapterLayout.VerticalLinearLayoutAdapterLayoutView;
import com.kimeeo.kAndroidDemos.recycleView.verticalViews.GridView;
import com.kimeeo.kAndroidDemos.recycleView.verticalViews.ListView;
import com.kimeeo.kAndroidDemos.recycleView.verticalViews.ResponsiveView;
import com.kimeeo.kAndroidDemos.recycleView.verticalViews.StaggeredGridView;
import com.kimeeo.kAndroidDemos.services.local.AssetsView;
import com.kimeeo.kAndroidDemos.services.local.DirectoryView;
import com.kimeeo.kAndroidDemos.services.local.FileView;
import com.kimeeo.kAndroidDemos.services.local.RawView;
import com.kimeeo.kAndroidDemos.services.okhttp.OkHTTPRecyclerViewVertical;
import com.kimeeo.kAndroidDemos.services.retrofilt.RetrofitRecyclerViewVertical;
import com.kimeeo.kAndroidDemos.services.rss.RSSRecyclerViewVertical;
import com.kimeeo.kAndroidDemos.services.sqlLite.SQLLiteRecyclerViewVertical;
import com.kimeeo.kAndroidDemos.services.volley.VolleyRecyclerViewVertical;

import java.util.HashMap;
import java.util.Map;

public class Main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Map<Integer, Class> views = new HashMap<>();

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

        views.put(R.id.nav_recycle_view_vertical_list, ListView.class);
        views.put(R.id.nav_recycle_view_vertical_grid, GridView.class);
        views.put(R.id.nav_recycle_view_vertical_staggered, StaggeredGridView.class);
        views.put(R.id.nav_recycle_view_vertical_responsive, ResponsiveView.class);


        views.put(R.id.nav_recycle_view_horizontal_list, com.kimeeo.kAndroidDemos.recycleView.horizontalViews.ListView.class);
        views.put(R.id.nav_recycle_view_horizontal_grid, com.kimeeo.kAndroidDemos.recycleView.horizontalViews.GridView.class);
        views.put(R.id.nav_recycle_view_horizontal_staggered, com.kimeeo.kAndroidDemos.recycleView.horizontalViews.StaggeredGridView.class);


        views.put(R.id.nav_recycle_view_vertical_linear_layout, VerticalLinearLayoutAdapterLayoutView.class);
        views.put(R.id.nav_recycle_view_horizontal_linear_layout, HorizontalLinearLayoutAdapterLayoutView.class);


        views.put(R.id.nav_recycle_view_header_list, com.kimeeo.kAndroidDemos.recycleView.verticalHeaderViews.ListView.class);
        views.put(R.id.nav_recycle_view_header_grid, com.kimeeo.kAndroidDemos.recycleView.verticalHeaderViews.GridView.class);
        views.put(R.id.nav_recycle_view_header_staggered, com.kimeeo.kAndroidDemos.recycleView.verticalHeaderViews.StaggeredGridView.class);
        views.put(R.id.nav_recycle_view_header_responsive, com.kimeeo.kAndroidDemos.recycleView.verticalHeaderViews.ResponsiveView.class);

        views.put(R.id.nav_recycle_view_runtime_layout_change, ProfileBasedListView.class);







        views.put(R.id.nav_map, MapView.class);

        views.put(R.id.nav_a_q, ListView.class);
        views.put(R.id.nav_retrofit, RetrofitRecyclerViewVertical.class);
        views.put(R.id.nav_ok_http, OkHTTPRecyclerViewVertical.class);
        views.put(R.id.nav_rss, RSSRecyclerViewVertical.class);
        views.put(R.id.nav_volley, VolleyRecyclerViewVertical.class);


        views.put(R.id.nav_sql_lite, SQLLiteRecyclerViewVertical.class);


        views.put(R.id.nav_directory, DirectoryView.class);
        views.put(R.id.nav_local_assets, AssetsView.class);
        views.put(R.id.nav_local_file, FileView.class);
        views.put(R.id.nav_local_raw, RawView.class);

        views.put(R.id.nav_bind_recycle, RecyclerView.class);


        loadView(R.id.nav_recycle_view_vertical_list);
    }

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
