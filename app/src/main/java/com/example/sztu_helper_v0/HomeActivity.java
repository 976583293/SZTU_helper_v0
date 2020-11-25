package com.example.sztu_helper_v0;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sztu_helper_v0.Fragment.Fragment_course;
import com.example.sztu_helper_v0.Fragment.Fragment_mainpage;
import com.example.sztu_helper_v0.Fragment.Fragment_school;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "HomeActivity";
    private DrawerLayout dl_left;
    private FrameLayout fl_main;
    private Toolbar toolbar;
    private LinearLayout ll_course;
    private LinearLayout ll_mainpage;
    private LinearLayout ll_school;
    private TextView bottom_course;
    private TextView bottom_mainpage;
    private TextView bottom_school;

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Fragment_course fragmentCourse;
    private Fragment_mainpage fragmentMainpage;
    private Fragment_school fragmentSchool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        fragmentManager = getSupportFragmentManager();
        Log.d(TAG, "onCreate: create home view successfully!");
        initViews();
        initToolbar();//初始化导航栏
        initDrawerLayout();//初始化侧滑栏
    }

    private void initDrawerLayout() {
        dl_left.setScrimColor(Color.TRANSPARENT); //设置背景色为透明
        dl_left.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED); //滑动模式
        dl_left.closeDrawer(GravityCompat.START); //关闭
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" "); //设置标题
        toolbar.setNavigationIcon(R.mipmap.icon_threeline_t); //设置左上角图标
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dl_left.openDrawer(GravityCompat.START); //点击图标后打开侧滑栏
            }
        });
    }

    //初始化view
    private void initViews() {
        dl_left = (DrawerLayout) findViewById(R.id.dl_main);
        fl_main = (FrameLayout) findViewById(R.id.fl_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        bottom_course = (TextView) findViewById(R.id.bottom_course);
        bottom_mainpage = (TextView) findViewById(R.id.bottom_mainpage);
        bottom_school = (TextView) findViewById(R.id.bottom_school);
        ll_course = (LinearLayout) findViewById(R.id.ll_course);
        ll_mainpage = (LinearLayout) findViewById(R.id.ll_mainpage);
        ll_school = (LinearLayout) findViewById(R.id.ll_school);

        bottom_course.setOnClickListener(this);
        bottom_mainpage.setOnClickListener(this);
        bottom_school.setOnClickListener(this);
        bottom_mainpage.setSelected(true);
        ll_mainpage.setBackgroundResource(R.drawable.draw_bottom_bg);
        ll_course.setBackgroundResource(R.drawable.draw_bottom_bg_left);
        ll_school.setBackgroundResource(R.drawable.draw_bottom_bg_right);
        fragmentTransaction = fragmentManager.beginTransaction();
        if (fragmentMainpage == null) {
            fragmentMainpage = new Fragment_mainpage();
        }
        fragmentTransaction.add(R.id.fl_main, fragmentMainpage).commit();
    }

    //定义导航栏的点击事件
    @Override
    public void onClick(View view) {
        fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        switch (view.getId()) {
            case R.id.bottom_course:
                Log.d(TAG, "onClick: you click course.");
                clearSelected();
                bottom_course.setSelected(true);
                ll_course.setBackgroundResource(R.drawable.draw_bottom_bg);
                ll_mainpage.setBackgroundResource(R.drawable.draw_bottom_bg_right);
                ll_school.setBackgroundResource(R.color.white);
                if (fragmentCourse == null) {
                    fragmentCourse = new Fragment_course();
                    fragmentTransaction.add(R.id.fl_main, fragmentCourse).commit();
                } else {
                    showFragment(fragmentCourse);
                }
                break;
            case R.id.bottom_mainpage:
                Log.d(TAG, "onClick: you click mainpage.");
                clearSelected();
                bottom_mainpage.setSelected(true);
                ll_mainpage.setBackgroundResource(R.drawable.draw_bottom_bg);
                ll_course.setBackgroundResource(R.drawable.draw_bottom_bg_left);
                ll_school.setBackgroundResource(R.drawable.draw_bottom_bg_right);
                if (fragmentMainpage == null) {
                    fragmentMainpage = new Fragment_mainpage();
                    fragmentTransaction.add(R.id.fl_main, fragmentMainpage).commit();
                } else {
                    showFragment(fragmentMainpage);
                }
                break;
            case R.id.bottom_school:
                Log.d(TAG, "onClick: you click school.");
                clearSelected();
                bottom_school.setSelected(true);
                ll_course.setBackgroundResource(R.color.white);
                ll_mainpage.setBackgroundResource(R.drawable.draw_bottom_bg_left);
                ll_school.setBackgroundResource(R.drawable.draw_bottom_bg);
                if (fragmentSchool == null) {
                    fragmentSchool = new Fragment_school();
                    fragmentTransaction.add(R.id.fl_main, fragmentSchool).commit();
                } else {
                    showFragment(fragmentSchool);
                }
                break;
        }
    }

    //取消所有导航按钮的选中状态
    private void clearSelected() {
        bottom_course.setSelected(false);
        bottom_mainpage.setSelected(false);
        bottom_school.setSelected(false);
    }

    //显示某个fragment
    private void showFragment(Fragment fragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        fragmentTransaction.show(fragment);
        fragmentTransaction.commit();
    }

    //隐藏所有fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (fragmentCourse != null) {
            fragmentTransaction.hide(fragmentCourse);
        }
        if (fragmentMainpage != null) {
            fragmentTransaction.hide(fragmentMainpage);
        }
        if (fragmentSchool != null) {
            fragmentTransaction.hide(fragmentSchool);
        }
    }

    //点击返回键
    @Override
    public void onBackPressed() {
        if (dl_left.isDrawerOpen(GravityCompat.START)) {
            dl_left.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //定义主页的Fragment的Click方法
    public void functionsViewClick(View v) {
        switch (v.getId()) {
            case R.id.fun_lessonTable:

        }
    }

}