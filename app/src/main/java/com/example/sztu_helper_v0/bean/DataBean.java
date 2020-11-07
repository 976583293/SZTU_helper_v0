package com.example.sztu_helper_v0.bean;

import com.example.sztu_helper_v0.R;

import java.util.ArrayList;
import java.util.List;

public class DataBean {
    public Integer imageRes;
    public String imageUrl;
    public String title;
    public int viewType;

    public DataBean(Integer imageRes, String title, int viewType) {
        this.imageRes = imageRes;
        this.title = title;
        this.viewType = viewType;
    }

    public DataBean(String imageUrl, String title, int viewType) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.viewType = viewType;
    }

    public static List<DataBean> getData(){
        List<DataBean> list = new ArrayList<>();
        list.add(new DataBean(R.drawable.img01, "111", 1));
        list.add(new DataBean(R.drawable.img02, "222", 3));
        list.add(new DataBean(R.drawable.img03, "333", 3));
        list.add(new DataBean(R.drawable.img04, "444", 1));
        list.add(new DataBean(R.drawable.img05, "555", 1));
        return list;
    }
}
