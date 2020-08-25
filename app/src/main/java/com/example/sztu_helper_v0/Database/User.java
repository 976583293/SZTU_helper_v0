package com.example.sztu_helper_v0.Database;

import org.litepal.crud.LitePalSupport;

public class User extends LitePalSupport {
    private int id;

    private String account;
    private String password;
    private boolean rem_password;
    private boolean auto_login;
    private boolean first_login;

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getPassword(String acc){
        if(acc.equals(account))
            return password;
        else
            return null;
    }

    public boolean isRem_password() {
        return rem_password;
    }

    public boolean isAuto_login() {
        return auto_login;
    }

    public boolean isFirst_login() {
        return first_login;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRem_password(boolean rem_password) {
        this.rem_password = rem_password;
    }

    public void setAuto_login(boolean auto_login) {
        this.auto_login = auto_login;
    }

    public void setFirst_login(boolean first_login) {
        this.first_login = first_login;
    }
}