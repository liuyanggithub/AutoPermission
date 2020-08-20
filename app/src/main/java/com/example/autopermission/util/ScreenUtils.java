package com.example.autopermission.util;

import android.app.Activity;
import android.app.KeyguardManager;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import android.view.Window;
import android.view.WindowManager;

import com.alibaba.fastjson.asm.Opcodes;
import com.example.autopermission.MyApplication;

public final class ScreenUtils {
    private ScreenUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int getScreenWidth() {
        WindowManager windowManager = (WindowManager) MyApplication.getInstance().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealSize(point);
        } else {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return point.x;
    }

    public static int getScreenHeight() {
        WindowManager windowManager = (WindowManager) MyApplication.getInstance().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            windowManager.getDefaultDisplay().getRealSize(point);
        } else {
            windowManager.getDefaultDisplay().getSize(point);
        }
        return point.y;
    }

    public static int getAppScreenWidth() {
        WindowManager windowManager = (WindowManager) MyApplication.getInstance().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static int getAppScreenHeight() {
        WindowManager windowManager = (WindowManager) MyApplication.getInstance().getSystemService("window");
        if (windowManager == null) {
            return -1;
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.y;
    }

    public static float getScreenDensity() {
        return MyApplication.getInstance().getResources().getDisplayMetrics().density;
    }

    public static int getScreenDensityDpi() {
        return MyApplication.getInstance().getResources().getDisplayMetrics().densityDpi;
    }

    public static void setFullScreen(@NonNull Activity activity) {
        if (activity != null) {
            activity.getWindow().addFlags(1024);
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void setNonFullScreen(@NonNull Activity activity) {
        if (activity != null) {
            activity.getWindow().clearFlags(1024);
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void toggleFullScreen(@NonNull Activity activity) {
        if (activity != null) {
            boolean isFullScreen = isFullScreen(activity);
            Window window = activity.getWindow();
            if (isFullScreen) {
                window.clearFlags(1024);
            } else {
                window.addFlags(1024);
            }
        } else {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static boolean isFullScreen(@NonNull Activity activity) {
        if (activity != null) {
            return (activity.getWindow().getAttributes().flags & 1024) == 1024;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void setLandscape(@NonNull Activity activity) {
        if (activity != null) {
            activity.setRequestedOrientation(0);
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static void setPortrait(@NonNull Activity activity) {
        if (activity != null) {
            activity.setRequestedOrientation(1);
            return;
        }
        throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
    }

    public static boolean isLandscape() {
        return MyApplication.getInstance().getResources().getConfiguration().orientation == 2;
    }

    public static boolean isPortrait() {
        return MyApplication.getInstance().getResources().getConfiguration().orientation == 1;
    }

    public static int getScreenRotation(@NonNull Activity activity) {
        if (activity != null) {
            switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
                case 0:
                    return 0;
                case 1:
                    return 90;
                case 2:
                    return Opcodes.GETFIELD;
                case 3:
                    return 270;
                default:
                    return 0;
            }
        } else {
            throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @android.support.annotation.NonNull but got null for it");
        }
    }

    public static boolean isScreenLock() {
        KeyguardManager keyguardManager = (KeyguardManager) MyApplication.getInstance().getSystemService("keyguard");
        if (keyguardManager == null) {
            return false;
        }
        return keyguardManager.inKeyguardRestrictedInputMode();
    }

    @RequiresPermission("android.permission.WRITE_SETTINGS")
    public static void setSleepDuration(int i) {
        Settings.System.putInt(MyApplication.getInstance().getContentResolver(), "screen_off_timeout", i);
    }

    public static int getSleepDuration() {
        try {
            return Settings.System.getInt(MyApplication.getInstance().getContentResolver(), "screen_off_timeout");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return -123;
        }
    }
}
