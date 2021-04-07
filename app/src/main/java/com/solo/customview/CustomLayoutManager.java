package com.solo.customview;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

public class CustomLayoutManager extends RecyclerView.LayoutManager {

    private static final String TAG = "CustomLayoutManager";

    private int sumDy = 0;
    private int mTotalheight = 0;
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        int OffSetY = 0;
        for (int i = 0; i < getItemCount(); i++) {
            View view = recycler.getViewForPosition(i);
            addView(view);
            measureChildWithMargins(view,0,0);
            int decoratedMeasuredHeight = getDecoratedMeasuredHeight(view);
            int decoratedMeasuredWidth = getDecoratedMeasuredWidth(view);
            layoutDecorated(view,0, OffSetY, decoratedMeasuredWidth, OffSetY + decoratedMeasuredHeight);
            OffSetY += decoratedMeasuredHeight;

        }
        mTotalheight = Math.max(OffSetY, getVerticalSpace());
    }

    @Override
    public boolean canScrollVertically() {
        return true;
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        Log.d(TAG, "scrollVerticallyBy: dy = " + dy  + "  sumDy = " +  sumDy+ "   mTotalheight  = " + mTotalheight);

        if(sumDy + dy < 0){
            Log.d(TAG, "scrollVerticallyBy: 向上滑动" );
            offsetChildrenVertical(-sumDy);
            return dy;
        }else if(mTotalheight - getVerticalSpace() < sumDy + dy ){
            Log.d(TAG, "scrollVerticallyBy: 向下滑动" );
            offsetChildrenVertical(0);
            return dy;
        }

        sumDy += dy;
        offsetChildrenVertical(-dy);
        return dy;
    }
    private int getVerticalSpace(){
        return getHeight() - getPaddingBottom() - getPaddingTop();
    }
}
