package com.solo.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class BasisView extends View {
    public BasisView(Context context) {
        super(context);
    }

    public BasisView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BasisView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BasisView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


/*    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);


        Path path = new Path();
        RectF rectF = new RectF(50,50,200,500);
        path.addOval(rectF, Path.Direction.CCW);
        Region region = new Region(new Rect(50,50,200,100));
        Region region1 = new Region();
        region1.setPath(path, region);

        drawRegion(region1, canvas, paint);
    }*/

   /* @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = new Rect(100,100,400, 200);
        Rect rect2 = new Rect(200,0,300, 300);

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        paint.setColor(Color.RED);

        canvas.drawRect(rect,paint);
        canvas.drawRect(rect2,paint);

        Region region = new Region(rect);
        Region region2 = new Region(rect2);
        region.op(rect2, Region.Op.XOR);
        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.FILL);
        paint1.setColor(Color.GREEN);
        drawRegion(region, canvas, paint1);
    }*/

/*    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);
        canvas.save();
        canvas.clipRect(new RectF(100,100, 500,500));
        canvas.drawColor(Color.GREEN);
        canvas.restore();
        canvas.drawColor(Color.BLUE);
    }

    private void drawRegion(Region region, Canvas canvas, Paint paint) {
        RegionIterator regionIterator = new RegionIterator(region);
        Rect rect = new Rect();
        while (regionIterator.next(rect)){
            canvas.drawRect(rect, paint);
        }
    }*/

/*    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int baseliney = 600;
        int baselinex = 0;

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(120);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("SoLo", baselinex, baseliney, paint);

        Paint.FontMetrics fm = paint.getFontMetrics();
        float ascent = baseliney + fm.ascent;
        float descent = baseliney + fm.descent;
        float top = baseliney + fm.top;
        float bottom = baseliney + fm.bottom;

        paint.setColor(Color.RED);
        canvas.drawLine(baselinex, baseliney, 3000, baseliney, paint);
        paint.setColor(Color.BLUE);
        canvas.drawLine(baselinex, top, 3000, top, paint);
        paint.setColor(Color.GREEN);
        canvas.drawLine(baselinex, ascent, 3000, ascent, paint);
        paint.setColor(Color.GREEN);
        canvas.drawLine(baselinex, descent, 3000, descent, paint);
        paint.setColor(Color.RED);
        canvas.drawLine(baselinex, bottom, 3000, bottom, paint);

    }*/

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.moveTo(200,200);
        path.quadTo(300,300, 400, 200);
        canvas.drawPath(path, paint);
    }
}
