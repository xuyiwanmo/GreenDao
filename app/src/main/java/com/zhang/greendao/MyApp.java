package com.zhang.greendao;

import android.app.Application;

import com.zhang.greendao.dao.DaoMaster;
import com.zhang.greendao.dao.DaoSession;

/**
 * Created by 德医互联 on 2017/10/23.
 */

public class MyApp extends Application {

    private DaoMaster.DevOpenHelper mHelper;
    private DaoMaster mMaster;
    private static DaoSession mSession;

    private static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
        mHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "easyhoms.db", null);
        mMaster = new DaoMaster(mHelper.getWritableDb());
        mSession = mMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mSession;
    }

    public static MyApp getApp() {
        return myApp;
    }
}
