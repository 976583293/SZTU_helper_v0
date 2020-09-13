package com.example.sztu_helper_v0;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sztu_helper_v0.Adapter.HomePageAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "HomeActivity";
    private DrawerLayout dl_left;
    private FrameLayout fl_main;
    private ArrayList<View> fragmentList;
    private Toolbar toolbar;
    private TextView bottom_course;
    private TextView bottom_mainpage;
    private TextView bottom_school;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: create home view successfully!");
        initViews();
        initToolbar();
        //initFragments();
        initDrawerLayout();
    }

    private void initDrawerLayout() {
        dl_left.setScrimColor(Color.TRANSPARENT);
        dl_left.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        dl_left.closeDrawer(GravityCompat.START);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" ");
        toolbar.setNavigationIcon(R.mipmap.icon_threeline_t);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dl_left.openDrawer(GravityCompat.START);
            }
        });
    }
    private void initFragments() {
        fragmentList = new ArrayList<android.view.View>();

    }
    //初始化view
    private void initViews() {
        dl_left = (DrawerLayout)findViewById(R.id.dl_main);
        fl_main = (FrameLayout)findViewById(R.id.fl_main);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        bottom_course = (TextView)findViewById(R.id.bottom_course);
        bottom_mainpage = (TextView)findViewById(R.id.bottom_mainpage);
        bottom_school = (TextView)findViewById(R.id.bottom_school);

        bottom_course.setOnClickListener(this);
        bottom_mainpage.setOnClickListener(this);
        bottom_school.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bottom_course:

        }
    }
    //点击返回键
    @Override
    public void onBackPressed()
    {
        if (dl_left.isDrawerOpen(GravityCompat.START)) {
            dl_left.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}