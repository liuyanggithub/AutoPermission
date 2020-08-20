package com.example.autopermission.server;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import com.example.autopermission.MyApplication;
import com.example.autopermission.TipsToast;
import com.example.autopermission.util.SharePreferenceUtils;

public class AccessibilityServiceMonitor extends AccessibilityService {
    private static final String TAG = "AccessibilityServiceMon";
    private static AccessibilityServiceMonitor mAccessibilityServiceMonitor;
    private Handler mHandler;
    private Runnable mRunnable;
    private boolean isBack = false;

    public static AccessibilityServiceMonitor getInstance() {
        if (mAccessibilityServiceMonitor == null) {
//            Toast.makeText(MyApplication.getInstance(), "辅助服务未开启", Toast.LENGTH_SHORT).show();
        }
        return mAccessibilityServiceMonitor;
    }

    @Override
    public void onCreate() {
        mAccessibilityServiceMonitor = this;
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (!isBack) {
            back();
            isBack = true;
        }
        //        int eventType = event.getEventType();
//        int typeWindowStateChanged = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED;
//        Log.d(TAG, "onAccessibilityEvent: " + eventType + "typeWindowStateChanged:" + typeWindowStateChanged);

    }

    private void back() {
        mRunnable = new Runnable() {
            @Override
            public void run() {
                performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK);
                mHandler.postDelayed(mRunnable, 600);
            }
        };
        mHandler = new Handler();
        mHandler.postDelayed(mRunnable, 600);
    }

    public void stopBack() {
        if (mHandler != null && mRunnable != null) {
            mHandler.removeCallbacks(mRunnable);
        }
    }

    @Override
    public void onServiceConnected() {
        super.onServiceConnected();
        //服务开启时，调用
        //setServiceInfo();这个方法同样可以实现xml中的配置信息
        //可以做一些开启后的操作比如点两下返回
        Log.d(TAG, "onServiceConnected: ");
        mAccessibilityServiceMonitor = this;
        boolean isFirst = (boolean) SharePreferenceUtils.get(MyApplication.getInstance(), "is_first", true);
        if (isFirst) {
            TipsToast.hide();
            TipsToast.showPermissioning();
            SharePreferenceUtils.put(MyApplication.getInstance(), "is_first", false);
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind: ");
        //关闭服务时,调用
        //如果有资源记得释放
        return super.onUnbind(intent);
    }

    @Override
    public void onInterrupt() {
        Log.d(TAG, "onInterrupt: ");
    }
}
