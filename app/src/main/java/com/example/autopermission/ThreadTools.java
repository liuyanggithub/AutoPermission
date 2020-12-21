package com.example.autopermission;

import java.util.concurrent.ExecutorService;

/**
 * <Pre>
 * TODO 描述该文件做什么
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 * <p>
 * Create by 2020/12/21 15:38
 */
public class ThreadTools {
    public static volatile ExecutorService a;

    public static void a() {
        if (a == null) {
            synchronized (ThreadTools.class) {
                if (a == null) {
                    a = ShadowExecutors.c(10, "​com.comm.libary.ThreadTools");
                }
            }
        }
    }

    public static void a(Runnable runnable) {
        if (a == null) {
            a();
        }
        a.execute(runnable);
    }

}
