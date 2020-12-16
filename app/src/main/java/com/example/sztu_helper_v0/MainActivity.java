package com.example.sztu_helper_v0;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sztu_helper_v0.Bean.UserBean;
import com.example.sztu_helper_v0.Database.UserManager;
import com.example.sztu_helper_v0.Utils.MD5Util;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

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
        //判断是否自动登录
        if(cb_login.isChecked()){
            Intent mHome = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(mHome);
        }
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
        UserBean user = new UserBean();
        UserManager userManager = new UserManager();
        String account = et_account.getText().toString();

        //判断有无记住密码
        if(cb_password.isChecked()){
            String psw = userManager.getPswByAccount(account);
            et_password.setText(psw);
            if (userManager.ifPswCorrect(account, psw)) {
                Intent mHome = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(mHome);
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT);
            }
        }
        else {
            // 对密码进行MD5加密
            String md5Psw = MD5Util.md5(et_password.getText().toString());
            Log.d(TAG, "login: md5password=" + md5Psw);

            if (!userManager.findUserByAccount(account)) {
                Toast.makeText(this, "账号不存在！", Toast.LENGTH_SHORT);
            }
            if (userManager.ifPswCorrect(account, md5Psw)) {
                Intent mHome = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(mHome);
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT);
                if (cb_password.isChecked()) {
                    user.setRem_password(true);
                }
                if (cb_login.isChecked()) {
                    user.setAuto_login(true);
                }
            }
        }
        return true;
    }
}