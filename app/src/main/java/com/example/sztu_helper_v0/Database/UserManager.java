package com.example.sztu_helper_v0.Database;

import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

public class UserManager {
    //通过账号查找该用户在不在
    public boolean findUserByAccount(String account){
        List<User> users = LitePal.findAll(User.class);
        for(User person: users){
            if(account.equals(person.getAccount())){
                return true;
            }
        }
        return false;
    }
    //通过账号判断密码正确与否
    public boolean ifPswCorrect(String account, String psw){
        List<User> users = LitePal.findAll(User.class);
        for(User person:users){
            if(psw.equals(person.getPassword(account))){
                return true;
            }
        }
        return false;
    }
    //记住密码时得到密码的操作
    public String getPswByAccount(String account){
        List<User> users = LitePal.findAll(User.class);
        for(User person: users){
            if(account.equals(person.getAccount())){
                return person.getPassword();
            }
        }
        return "";
    }
}
