package com.example.autopermission;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

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

    public static Handler sHandler = new Handler(Looper.getMainLooper());

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }

    public static void post(Runnable runnable) {
        Handler handler = sHandler;
        if (handler != null && runnable != null) {
            handler.post(runnable);
        }
    }
}
