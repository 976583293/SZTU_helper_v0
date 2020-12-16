package com.example.sztu_helper_v0;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sztu_helper_v0.Utils.ExcelUtil;
import com.inks.fileselect.ChooseFile;

import java.io.File;
import java.io.FileNotFoundException;

public class Mainpage_lessonTable extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Mainpage_lessonTable";
    int REQUEST_CODE = 120;
    private TextView upload;
    ChooseFile chooseFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage_lesson_table);
        upload = (TextView) findViewById(R.id.upload);
        upload.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.upload)//如果点击了上传按钮
            pickFile();//选择文件并上传
            chooseFile.popupChoose(Mainpage_lessonTable.this, v, getWindow(), getLayoutInflater(),true);
    }

    //选择文件
    private void pickFile() {
        chooseFile = new ChooseFile();
        chooseFile.setOnChooseFileBack(chooseFileBack);
    }

    ChooseFile.onChooseFileBack chooseFileBack = new ChooseFile.onChooseFileBack() {
        @Override
        public void onChooseBack(String path, String type) {
            File file=new File(path);
            if (ExcelUtil.checkIfExcelFile(file)) {
                try {
                    ExcelUtil.readExcel(file); //读取Excel file 内容
                    Log.d(TAG, "onActivityResult: read the file successfully.");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            else{
                Toast.makeText(Mainpage_lessonTable.this,"请选择正确的文件类型",Toast.LENGTH_SHORT).show();
            }
        }
    };
}