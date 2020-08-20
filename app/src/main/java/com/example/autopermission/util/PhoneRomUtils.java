package com.example.autopermission.util;

import android.content.Intent;
import android.os.Build;

public class PhoneRomUtils {
    private static final String MANUFACTURER = Build.MANUFACTURER.toLowerCase();
    public static int getPhoneType() {
        Intent intent;
        if (MANUFACTURER.contains("huawei")) {
            return 1;
        } else if (MANUFACTURER.contains("xiaomi")) {
            return 2;
        } else if (MANUFACTURER.contains("oppo")) {
            return 3;
        } else if (MANUFACTURER.contains("vivo")) {
            return 4;
        } else if (MANUFACTURER.contains("meizu")) {
            return 6;
        } else {
            return 7;
        }
//        return 0;
    }
}
