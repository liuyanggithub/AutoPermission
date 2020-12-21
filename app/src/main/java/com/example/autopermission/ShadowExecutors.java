package com.example.autopermission;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * <Pre>
 * TODO 描述该文件做什么
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 * <p>
 * Create by 2020/12/21 15:25
 */
public class ShadowExecutors {
    public static final int a = 1;
    public static final int b = Runtime.getRuntime().availableProcessors();
    public static final int c = ((b << 1) + 1);
    public static final long d = 30000;
    public static ScheduledExecutorService c(int i, String str) {
        ScheduledExecutorService scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(Math.min(Math.max(1, i), c), new NamedThreadFactory(str));
        return scheduledThreadPoolExecutor;
    }
}
