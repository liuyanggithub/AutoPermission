package com.example.autopermission;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <Pre>
 * TODO 描述该文件做什么
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 * <p>
 * Create by 2020/12/21 15:29
 */
public class NamedThreadFactory implements ThreadFactory{
    public final String a;
    public final AtomicInteger b;
    public final ThreadGroup c;
    public final ThreadFactory d;

    public NamedThreadFactory(String str) {
        this(null, str);
    }


    public Thread newThread(Runnable runnable) {
        ThreadFactory threadFactory = this.d;
        if (threadFactory == null) {
            ThreadGroup threadGroup = this.c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("#");
            stringBuilder.append(this.b.getAndIncrement());
            Thread thread = new Thread(threadGroup, runnable, stringBuilder.toString(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
        Thread newThread = threadFactory.newThread(runnable);
        new Thread(newThread, this.a);
        return newThread;
    }

    public NamedThreadFactory(ThreadFactory threadFactory, String str) {
        this.b = new AtomicInteger(1);
        this.d = threadFactory;
        this.a = str;
        this.c = Thread.currentThread().getThreadGroup();
    }
}
