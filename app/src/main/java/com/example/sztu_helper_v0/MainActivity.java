package com.example.sztu_helper_v0;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    //布局的控件
    private EditText et_account;
    private EditText et_password;
    private Button btn_login;
    private CheckBox cb_password;
    private CheckBox cb_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();    //初始化布局控件
        
    }

    /*判断是否第一次登录
    private boolean firstLogin(){

    }*/
    private void initViews(){
        et_account = (EditText) findViewById(R.id.login_account);
        et_password=(EditText)findViewById(R.id.login_password);
        btn_login=(Button)findViewById(R.id.btn_login);
        cb_password=(CheckBox)findViewById(R.id.cb_password);
        cb_login=(CheckBox)findViewById(R.id.cb_login);
    }
}