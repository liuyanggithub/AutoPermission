package com.example.autopermission.util;


import com.example.autopermission.bean.ASBase;
import com.example.autopermission.bean.ASIntentBean;
import com.example.autopermission.bean.ASStepBean;

public interface ASMListener {
    void complete(ASBase arg1);

    /**
     * 暂停
     *
     * @param arg1
     */
    void pause(ASStepBean arg1);

    void jumpActivity(ASIntentBean intent);
}