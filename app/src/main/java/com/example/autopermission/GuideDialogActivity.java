package com.example.autopermission;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.autopermission.util.SystemHelper;

/**
 * <Pre>
 *     dialog形式的activity，背景透明
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 * <p>
 * Create by 2020/7/30 14:26
 */
public class GuideDialogActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_dialog);
    }

    public static void goGuideDialogActivity(Context context) {
        Intent intent = new Intent(context, GuideDialogActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        SystemHelper.setTopApp(this);
    }

    public void close(View view) {
        finish();
        TipsToast.showPermissionGuide();
    }
}
