package com.test.alodoktertes.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PrefManager {
    private static SharedPreferences pref;
    Editor editor;
    Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "Alodokter";
    private static final String IS_LOGIN = "IsLogin";

    public PrefManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setIsLogin(boolean isLogin) {
        editor.putBoolean(IS_LOGIN, isLogin);
        editor.commit();
    }

    public boolean getIsLogin() {
        return pref.getBoolean(IS_LOGIN, false);
    }

    public void setClearPrefrencessLogout() {

        editor.remove(IS_LOGIN);
        editor.commit();

    }

}
