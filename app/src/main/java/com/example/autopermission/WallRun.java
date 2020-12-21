package com.example.autopermission;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.SurfaceHolder;

/**
 * <Pre>
 * TODO 描述该文件做什么
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 * <p>
 * Create by 2020/12/21 15:02
 */
public class WallRun implements Runnable{
    public final /* synthetic */ Canvas canvas;
    public final /* synthetic */ SurfaceHolder holder;
    public final /* synthetic */ LiveWallpaperView wallpaperView;

    public WallRun(LiveWallpaperView wallpaperView, Canvas canvas, SurfaceHolder surfaceHolder) {
        this.wallpaperView = wallpaperView;
        this.canvas = canvas;
        this.holder = surfaceHolder;
    }

    @Override
    public void run() {
        Bitmap bitmap = this.wallpaperView.getBitmap();
        if (this.canvas != null) {
//            Rect rect = new Rect();
//            rect.top = 0;
//            rect.left = 0;
//            rect.bottom = this.canvas.getHeight();
//            rect.right = this.canvas.getWidth();
//            this.canvas.drawBitmap(a, null, rect, this.wallpaperView.mPaint);
//            if (this.wallpaperView.bitmap != null) {
//                float width = (((float) a.getWidth()) * 1.0f) / ((float) a.getHeight());
//                int abs = Math.abs((this.canvas.getHeight() - this.wallpaperView.bitmap.getHeight()) / 6);
//                Rect rect2 = new Rect();
//                rect2.left = 0;
//                rect2.top = abs;
//                rect2.bottom = ((int) (((float) this.canvas.getWidth()) / width)) + abs;
//                rect2.right = this.canvas.getWidth();
//                this.canvas.drawBitmap(this.wallpaperView.bitmap, null, rect2, this.wallpaperView.mPaint);
//            }
            Rect rect = new Rect();
            rect.left = rect.top = 0;
            rect.bottom = canvas.getHeight();
            rect.right = canvas.getWidth();
            canvas.drawBitmap(bitmap, null, rect, wallpaperView.mPaint);
        }
        MyApplication.post(new DrawRun(this));
    }
}
