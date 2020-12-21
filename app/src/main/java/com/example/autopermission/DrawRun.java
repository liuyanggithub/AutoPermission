package com.example.autopermission;

/**
 * <Pre>
 * TODO 描述该文件做什么
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 * <p>
 * Create by 2020/12/21 15:05
 */
public class DrawRun implements Runnable{
    private WallRun runnable;

    public DrawRun(WallRun runnable) {
        this.runnable = runnable;
    }

    @Override
    public void run() {
        try {
            this.runnable.holder.unlockCanvasAndPost(this.runnable.canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
