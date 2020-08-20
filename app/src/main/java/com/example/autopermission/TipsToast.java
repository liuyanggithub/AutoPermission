package com.example.autopermission;

import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.autopermission.util.ScreenUtils;


/**
 * <Pre>
 * TODO 描述该文件做什么
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 * <p>
 * Create by 2020/7/30 15:41
 */
public class TipsToast {
    private static Toast mToast = new Toast(MyApplication.getInstance());
    private static Runnable mRunnable;
    private static Handler mHandler;

    public static void showPermissioning() {
        showPermission(R.layout.toast_auto_permissioning, true);
    }
    public static void showPermissionGuide() {
        showPermission(R.layout.toast_guide, false);
    }

    public static void hide() {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
        if (mHandler == null || mRunnable == null) return;
        mHandler.removeCallbacks(mRunnable);
        mHandler = null;
        mRunnable = null;
    }

    public static void showPermission(final int resource, final boolean isFullScreen) {
        if (mToast == null) {
            mToast = new Toast(MyApplication.getInstance());
        }
        if (mHandler == null) {
            mHandler = new Handler(Looper.getMainLooper());
        }
        if (mRunnable == null) {
            mRunnable = new Runnable() {
                @Override
                public void run() {
                    setToastView(resource, isFullScreen);
                    mHandler.postDelayed(mRunnable, 4000);
                }
            };
        }
        mHandler.post(mRunnable);
    }

    private static void setToastView(int resource, boolean isFullScreen) {
        View view = LayoutInflater.from(MyApplication.getInstance()).inflate(resource, null);
        view.requestLayout();
        if (isFullScreen) {
            view.findViewById(R.id.root).setLayoutParams(new FrameLayout.LayoutParams(ScreenUtils.getScreenWidth(), ScreenUtils.getScreenHeight()));
            mToast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            mToast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.TOP, 0, 120);
        }
        mToast.setView(view);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.show();
    }
}
