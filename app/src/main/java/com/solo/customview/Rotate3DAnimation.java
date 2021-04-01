package com.solo.customview;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3DAnimation extends Animation {

    private final int start;
    private final int end;
    private int mCenterx;
    private int mCentery;
    private Camera mCamera;

    public Rotate3DAnimation(int start, int end) {
        this.start = start;
        this.end = end;

    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mCenterx = width / 2;
        mCentery = height / 2;
        mCamera = new Camera();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        mCamera.save();
        float d = start+ (end-start) * interpolatedTime;
        Matrix matrix = t.getMatrix();
        mCamera.rotateY(d);
        mCamera.getMatrix(matrix);
        mCamera.restore();

        matrix.preTranslate(-mCenterx, -mCentery);
        matrix.postTranslate(mCenterx, mCentery);
        super.applyTransformation(interpolatedTime, t);

    }
}
