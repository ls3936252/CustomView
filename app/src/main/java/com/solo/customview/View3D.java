package com.solo.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.solo.customview.R;

@SuppressLint("AppCompatCustomView")
public class View3D extends ImageView {

    private Paint mPaint;
    private Bitmap mBitmap;
    private Camera camera = new Camera();
    private Matrix matrix = new Matrix();
    private int mProgress = 0;

    private static final String TAG = "View3D";

    public View3D(Context context) {
        super(context);
    }

    public View3D(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }



    public View3D(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void init() {
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.aaa);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    public void setProgress(int progress){
        mProgress = progress;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawBitmap(mBitmap, new Rect(0,0,1920,1080),new Rect(0,0,getWidth(),getHeight()),mPaint);
        Log.d(TAG, "onDraw: mProgress" + mProgress);
        camera.save();
        canvas.save();

        mPaint.setAlpha(100);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
//        camera.rotateY(mProgress);
        camera.translate(0, 0, -mProgress);
        camera.applyToCanvas(canvas);
        camera.restore();
        super.onDraw(canvas);
        canvas.restore();

    }
}
