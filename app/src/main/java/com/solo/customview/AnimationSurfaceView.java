package com.solo.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import com.solo.customview.R;


public class AnimationSurfaceView extends SurfaceView {

    private boolean flag = false;
    private Bitmap bitmap;
    private int mSurfaceWidth, mSurfaceHeight;
    private Canvas mCanvas;
    private SurfaceHolder surfaceHolder;
    private Canvas lockCanvas;
    private int Dx;

    private enum Stats {
        LEFT,
        RIGHT
    }
    Stats stats = Stats.LEFT;

    public AnimationSurfaceView(Context context) {
        super(context);
    }

    public AnimationSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
                flag= true;
                startAnimation();
            }

            @Override
            public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
//                flag = false;
            }
        });
    }

    public AnimationSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void startAnimation() {
        mSurfaceWidth = getWidth();
        mSurfaceHeight = getHeight();
        mSurfaceWidth = mSurfaceWidth *5/2;
        Bitmap tmp = BitmapFactory.decodeResource(getResources(), R.drawable.car);
        bitmap = Bitmap.createScaledBitmap(tmp, mSurfaceWidth, mSurfaceHeight, true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (flag){
                    lockCanvas = surfaceHolder.lockCanvas();
                    DrawView();
                    surfaceHolder.unlockCanvasAndPost(lockCanvas);
                }
            }
        }).start();
    }

    private void DrawView() {
        lockCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        lockCanvas.drawBitmap(bitmap, Dx, 0, null);
        switch (stats){
            case LEFT:
                Dx -= 10;
                break;
            case RIGHT:
                Dx += 10;
                break;
            default:
                break;
        }
        if(Dx <= -mSurfaceWidth/2){
            stats = Stats.RIGHT;
        }
        if(Dx > 0){
            stats = Stats.LEFT;
        }
    }

}
