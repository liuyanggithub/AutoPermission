package com.example.autopermission;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.service.wallpaper.WallpaperService;
import android.util.LruCache;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Map;

/**
 * <Pre>
 * TODO 描述该文件做什么
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 * <p>
 * Create by 2020/12/21 14:53
 */
public class LiveWallpaperView extends SurfaceView implements SurfaceHolder.Callback{
    private Context context;
    public LruCache<String, Bitmap> lruCache;
    public Bitmap bitmap;
    public Paint mPaint;
    public WallpaperService.Engine engine;
    public LiveWallpaperView(WallpaperService.Engine engine, Context context) {
        super(context);
        this.engine = engine;
        this.lruCache = new LruCache(((int) Runtime.getRuntime().maxMemory()) / 8);
        this.context = context;
        initPaintConfig();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        holder.removeCallback(this);
        start(holder);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        releaseBitmap();
    }

    public void saveCurrentWall() {
        String str = "cache_wallpaper";
        LruCache lruCache = this.lruCache;
        if (lruCache != null) {
            try {
                Bitmap bitmap = (Bitmap) lruCache.get(str);
                if (bitmap == null) {
                    Drawable drawable = WallpaperManager.getInstance(context).getDrawable();
                    if (drawable != null) {
                        bitmap = ((BitmapDrawable) drawable).getBitmap();
                        if (bitmap != null) {
                            this.lruCache.put(str, bitmap);
                        }
                    } else {
                        return;
                    }
                }
                if (bitmap != null) {
                    this.bitmap = bitmap;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void initPaintConfig() {
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(5);
    }

    private void drawSurfaceView(SurfaceHolder holder) {
        if (this.bitmap != null && !this.bitmap.isRecycled()) {
            Canvas localCanvas = holder.lockCanvas();
            if (localCanvas != null) {
                Rect rect = new Rect();
                rect.left = rect.top = 0;
                rect.bottom = localCanvas.getHeight();
                rect.right = localCanvas.getWidth();
                localCanvas.drawBitmap(this.bitmap, null, rect, this.mPaint);
                holder.unlockCanvasAndPost(localCanvas);
            }
        }
    }

    public Bitmap getBitmap() {
        Bitmap bitmap = null;
        if (this.engine.isPreview()) {
            bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.bg_wall);
        }
        if (bitmap != null) {
            return bitmap;
        }
        return this.bitmap;
    }

    private void start(SurfaceHolder surfaceHolder) {
        ThreadTools.a(new WallRun(this, surfaceHolder.lockCanvas(), surfaceHolder));
    }

    public void releaseBitmap() {
        try {
            if (lruCache != null && lruCache.size() > 0) {
                Map<String, Bitmap> stringBitmapMap = lruCache.snapshot();
                lruCache.evictAll();
                if (stringBitmapMap != null && stringBitmapMap.size() > 0) {
                    for (Map.Entry<String, Bitmap> entry : stringBitmapMap.entrySet()) {
                        if (entry != null && entry.getValue() != null && !entry.getValue().isRecycled()) {
                            entry.getValue().recycle();
                        }
                    }
                    stringBitmapMap.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
