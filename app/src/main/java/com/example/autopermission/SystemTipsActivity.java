package com.example.autopermission;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.example.autopermission.bean.ASBase;
import com.example.autopermission.bean.ASStepBean;
import com.example.autopermission.util.SystemHelper;


public class SystemTipsActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvStartContent;
    private TextView tvContent;
    private TextView tvEndContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_guide);
        initView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SystemHelper.setTopApp(this);
    }

    protected void initView() {
        findViewById(R.id.clRoot).setOnClickListener(this);
        findViewById(R.id.flClose).setOnClickListener(this);

        tvStartContent = findViewById(R.id.tvStartContent);
        tvContent = findViewById(R.id.tvContent);
        tvEndContent = findViewById(R.id.tvEndContent);

        Intent intent = getIntent();

        if (intent != null && intent.getSerializableExtra(ExtraConstant.EXTRA_AS_BASE) != null) {
            ASBase asBase = (ASBase) intent.getSerializableExtra(ExtraConstant.EXTRA_AS_BASE);
            setASData(asBase);
        }
    }

    public void setASData(ASBase data) {
        tvStartContent.setText("找到");
        tvEndContent.setText("");
        if (data != null && data.step != null) {
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < data.step.size(); i++) {
                ASStepBean asStepBean = data.step.get(i);
                if (!TextUtils.equals(asStepBean.getClick_type(), "system") && !TextUtils.isEmpty(asStepBean.find_text)) {
                    if (i > 0) {
                        sbf.append("\n【" + asStepBean.find_text + "】");
                    } else {
                        sbf.append("【" + asStepBean.find_text + "】");
                    }
                }
            }
            tvContent.setText(sbf.toString());
        }
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
