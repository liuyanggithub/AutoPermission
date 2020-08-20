package com.example.autopermission;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.autopermission.bean.ASBase;
import com.example.autopermission.bean.ASIntentBean;
import com.example.autopermission.bean.ASStepBean;
import com.example.autopermission.server.AccessibilityServiceMonitor;
import com.example.autopermission.util.ASMAutoUtils;
import com.example.autopermission.util.ASMListener;
import com.example.autopermission.util.AccessibilitUtil;
import com.example.autopermission.util.FileUtils;
import com.example.autopermission.util.SharePreferenceUtils;

import java.lang.reflect.Field;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ASMListener {
    private static final String TAG = "MainActivity";
    private List<ASBase> asBases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ASMAutoUtils.getInstance().setListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(AccessibilityServiceMonitor.getInstance() != null) {
            AccessibilityServiceMonitor.getInstance().stopBack();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            TipsToast.hide();
            if (AccessibilitUtil.isAccessibilitySettingsOn(this, AccessibilityServiceMonitor.class.getCanonicalName())) {
                requestPermission(null);
            }
        }
    }

    /**
     * 打开无障碍功能
     *
     * @param view
     */
    public void openAccessibilityService(View view) {
        if (AccessibilitUtil.isAccessibilitySettingsOn(this, AccessibilityServiceMonitor.class.getCanonicalName())) {
            requestPermission(view);
        } else {
            Intent mIntent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
            startActivityForResult(mIntent, 0);
            GuideDialogActivity.goGuideDialogActivity(MainActivity.this);
            SharePreferenceUtils.put(MyApplication.getInstance(), "is_first", true);
        }
    }

    public void closeAccessibilityService(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            AccessibilityServiceMonitor.getInstance().disableSelf();
        }
    }

    public void requestPermission(View view) {
        String data = FileUtils.getJson(this, "step.json");
        asBases = JSON.parseArray(data, ASBase.class);
        ASMAutoUtils.getInstance().start(asBases.remove(0));
    }

    public void permissionApplyInternal() {
        try {
            Class clazz = Settings.class;
            Field field = clazz.getDeclaredField("ACTION_MANAGE_OVERLAY_PERMISSION");

            Intent intent = new Intent(field.get(null).toString());
            intent.setData(Uri.parse("package:com.cheetah.cmshow"));
            startActivity(intent);
        } catch (Exception e) {
        }
    }

    @Override
    public void complete(ASBase arg1) {
        if (asBases != null && asBases.size() > 0) {
            ASMAutoUtils.getInstance().start(asBases.remove(0));
        }
    }

    @Override
    public void pause(ASStepBean arg1) {
        String clickFailToast = arg1.getClickFailToast();
        if (!TextUtils.isEmpty(clickFailToast)) {
            Toast.makeText(this, clickFailToast, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void jumpActivity(ASIntentBean intentData) {
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(intentData.getUriData())) {
            String[] uriArr = intentData.getUriData().split("&");
            Uri uri = Uri.fromParts(uriArr[0], uriArr[1], null);
            intent.setData(uri);
        }
        if (!TextUtils.isEmpty(intentData.getUriDataFull())) {
            String uriStr = intentData.getUriDataFull();
            Uri uri = Uri.parse(uriStr);
            intent.setData(uri);
        }
        if (!TextUtils.isEmpty(intentData.getExtra())) {
            String[] uriArr = intentData.getExtra().split("&");
            intent.putExtra(uriArr[0], uriArr[1]);
        }
        if (!TextUtils.isEmpty(intentData.getActionName())) {
            intent.setAction(intentData.getActionName());
        }
        if (!TextUtils.isEmpty(intentData.getComponenPkg()) && !TextUtils.isEmpty(intentData.getComponenCls())) {
            ComponentName comp = new ComponentName(intentData.getComponenPkg(), intentData.getComponenCls());
            intent.setComponent(comp);
        }
        if (!TextUtils.isEmpty(intentData.getCategory())) {
            intent.addCategory(intentData.getCategory());
        }
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void onKeyOpen(View view) {
        openAccessibilityService(view);
    }
}
