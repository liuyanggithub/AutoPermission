package com.example.autopermission;

import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * <Pre>
 * TODO 描述该文件做什么
 * </Pre>
 *
 * @author 刘阳
 * @version 1.0
 * <p>
 * Create by 2020/12/18 16:06
 */
public class WPService extends WallpaperService {
    @Override
    public Engine onCreateEngine() {
        return new MyEngine();
    }

    private class MyEngine extends Engine {
        private LiveWallpaperView liveWallpaperView;

        public MyEngine() {
            setOffsetNotificationsEnabled(true);
            liveWallpaperView = new LiveWallpaperView(this, WPService.this.getBaseContext());
            liveWallpaperView.saveCurrentWall();
        }

        @Override
        public void onSurfaceCreated(SurfaceHolder holder) {
            super.onSurfaceCreated(holder);
            a();
            LiveWallpaperView xnWallpaperView = this.liveWallpaperView;
            if (xnWallpaperView != null) {
                xnWallpaperView.surfaceCreated(holder);
            }
        }

        @Override
        public void onSurfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            super.onSurfaceChanged(holder, format, width, height);
            a();
        }

        @Override
        public void onSurfaceDestroyed(SurfaceHolder holder) {
            super.onSurfaceDestroyed(holder);
            LiveWallpaperView xnWallpaperView = this.liveWallpaperView;
            if (xnWallpaperView != null) {
                xnWallpaperView.surfaceDestroyed(holder);
            }
        }

        private void a() {
            SurfaceView surfaceView = this.liveWallpaperView;
            if (surfaceView != null) {
                if (isVisible()) {
                    this.liveWallpaperView.saveCurrentWall();
                }
            }
        }

    }
}
