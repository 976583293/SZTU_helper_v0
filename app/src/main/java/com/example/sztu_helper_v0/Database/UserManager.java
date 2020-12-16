package com.example.sztu_helper_v0.Database;

import com.example.sztu_helper_v0.Bean.UserBean;

import org.litepal.LitePal;

import java.util.List;

public class UserManager {
    //添加用户
    public UserBean createAccount(String account, String psw){
        UserBean user = new UserBean();
        user.setAccount(account);
        user.setPassword(psw);
        return user;
    }
    //通过账号查找该用户在不在
    public boolean findUserByAccount(String account){
        List<UserBean> users = LitePal.findAll(UserBean.class);
        for(UserBean person: users){
            if(account.equals(person.getAccount())){
                return true;
            }
        }
        return false;
    }
    //通过账号判断密码正确与否
    public boolean ifPswCorrect(String account, String psw){
        List<UserBean> users = LitePal.findAll(UserBean.class);
        for(UserBean person:users){
            if(psw.equals(person.getPassword(account))){
                return true;
            }
        }
        return false;
    }
    //记住密码时得到密码的操作
    public String getPswByAccount(String account){
        List<UserBean> users = LitePal.findAll(UserBean.class);
        for(UserBean person: users){
            if(account.equals(person.getAccount())){
                return person.getPassword();
            }
        }
        return "";
    }
}
