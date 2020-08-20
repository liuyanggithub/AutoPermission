package com.example.autopermission.util;

import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class SystemProperties {

    private static volatile int code;

    public static String getRom(String str, String str2) {
        try {
            Object get = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{str, str2});
            if (TextUtils.equals(get.toString(), "unkonw")) {
                Properties property = getProperty();
                get = property.get(str);
            }
            return (String) get;
        } catch (Exception unused) {
            return str2;
        }
    }

    public static Properties getProperty() {
        Properties properties = new Properties();
        try {
            Process p = Runtime.getRuntime().exec("getprop");
            properties.load(p.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getMiuiVersion() {

        String propName = "ro.miui.ui.version.name";
        String line;
        BufferedReader input = null;
        try {
            Process p = Runtime.getRuntime().exec("getprop " + propName);
            input = new BufferedReader(
                    new InputStreamReader(p.getInputStream()), 1024);
            line = input.readLine();
            input.close();
        } catch (IOException ex) {
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return line;
    }
}