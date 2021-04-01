package com.solo.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.customview.widget.ViewDragHelper;

public class DragLayout extends LinearLayout {

    private static final String TAG = "DragLayout";

    private ViewDragHelper viewDragHelper;

    public DragLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        viewDragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(@NonNull View child, int pointerId) {
//                return child.getId() == R.id.tv3;
                return true;
            }

            @Override
            public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
                return left;
            }

            @Override
            public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
                return top;
            }

            @Override
            public int getViewHorizontalDragRange(@NonNull View child) {
                return 1;
            }

/*            @Override
            public void onEdgeTouched(int edgeFlags, int pointerId) {
                super.onEdgeTouched(edgeFlags, pointerId);
                Log.d(TAG, "onEdgeTouched: " + edgeFlags + "   "+ pointerId);
            }*/

/*            @Override
            public void onEdgeDragStarted(int edgeFlags, int pointerId) {
                viewDragHelper.captureChildView(findViewById(R.id.tv3), pointerId);
                super.onEdgeDragStarted(edgeFlags, pointerId);
                Log.d(TAG, "onEdgeDragStarted: " + edgeFlags + "   "+ pointerId);
            }*/
        });


    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return super.onInterceptTouchEvent(ev);
        return viewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        viewDragHelper.processTouchEvent(event);
        return true;
    }


}
