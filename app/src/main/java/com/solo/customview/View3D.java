package com.solo.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

import com.solo.customview.R;

public class View3D extends androidx.appcompat.widget.AppCompatImageView {

    private Paint mPaint;
    private Bitmap mBitmap;
    private Camera camera = new Camera();
    private Matrix matrix = new Matrix();
    private int mProgress = 80;

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
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.solo);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    private void setProgress(int progress){
        mProgress = progress;
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        camera.save();
        canvas.save();


        mPaint.setAlpha(100);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
//        canvas.drawBitmap(mBitmap, new Rect(0,0,1920,1080),new Rect(0,0,getWidth(),getHeight()),mPaint);
        camera.rotateY(mProgress);
//        camera.translate(1200, 0, 0);
        camera.applyToCanvas(canvas);
        super.onDraw(canvas);

        camera.restore();
        canvas.restore();

    }
}
