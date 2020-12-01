package com.example.sztu_helper_v0;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.leon.lfilepickerlibrary.LFilePicker;
import com.leon.lfilepickerlibrary.filter.LFileFilter;

public class Mainpage_lessonTable extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Mainpage_lessonTable";
    int REQUEST_CODE = 120;
    int RESULT_OK = 9;
    private TextView upload;

    String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage_lesson_table);
        upload.findViewById(R.id.upload);
    }

    @Override
    public void onClick(View v) {
        pickFile(upload);//选择文件并上传
    }

    //选择文件
    private void pickFile(TextView upload) {
        new LFilePicker()
                .withActivity(Mainpage_lessonTable.this)
                .withRequestCode(REQUEST_CODE)
                .withBackgroundColor("#3700B3")
                .withStartPath("/storage/emulated")
                .start();
    }

    //处理结果
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE) {
                filename = data.getDataString();
                Log.d(TAG, "onActivityResult: you choose" + filename);
            }
        }
    }

    //读取文件

}