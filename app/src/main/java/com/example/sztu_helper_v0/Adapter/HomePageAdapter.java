package com.example.sztu_helper_v0.Adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class HomePageAdapter extends PagerAdapter {
    private ArrayList<View> fragmentList;

    public HomePageAdapter() {
    }

    public HomePageAdapter(ArrayList<View> fragments) {
        super();
        fragmentList = fragments;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
