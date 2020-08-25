package com.example.sztu_helper_v0;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sztu_helper_v0.Database.User;
import com.example.sztu_helper_v0.Utils.MD5Util;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.tablemanager.Connector;

import java.sql.SQLData;

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
        LitePal.initialize(this);
        SQLiteDatabase db = Connector.getDatabase();
        Log.d(TAG, "onCreate: Database successfully build");
        initViews();    //初始化布局控件
    }
    //初始化布局控件
    private void initViews(){
        et_account = (EditText) findViewById(R.id.login_account);
        et_password =(EditText)findViewById(R.id.login_password);
        btn_login = (Button)findViewById(R.id.btn_login);
        cb_password = (CheckBox)findViewById(R.id.cb_password);
        cb_login = (CheckBox)findViewById(R.id.cb_login);
    }
    //登录操作
    @SuppressLint("ShowToast")
    private boolean login(){
        User user = new User();
        String account = et_account.getText().toString();
        user.setAccount(account);
        //对密码进行MD5加密
        String md5Psw = MD5Util.md5(et_password.getText().toString());
        Log.d(TAG, "login: md5password=" + md5Psw);
        user.setPassword(md5Psw);
        if(!user.isSaved()){                //如果用户是第一次登录，取消选中checkbox
            cb_login.setChecked(false);
            cb_password.setChecked(false);
            user.setFirst_login(true);
            user.setAuto_login(false);
            user.setRem_password(false);
        }
        if(md5Psw.equals(user.getPassword(account))){
            Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT);
            if(cb_password.isChecked()){

            }
            if(cb_login.isChecked()){

            }
        }
    }
}