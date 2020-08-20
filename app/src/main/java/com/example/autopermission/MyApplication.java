package com.example.autopermission;

import android.app.Application;

/**
 * <Pre>
 * TODO 描述该文件做什么
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 * <p>
 * Create by 2020/7/30 15:44
 */
public class MyApplication extends Application {
    public static MyApplication appContext;
    public static MyApplication getInstance() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }
}
