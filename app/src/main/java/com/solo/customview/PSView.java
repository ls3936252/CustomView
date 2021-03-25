package com.solo.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.solo.customview.R;

public class PSView extends View {

    private Paint paint;
    private Bitmap bitmap;
    private Bitmap mAlphaBmp;

    public PSView(Context context) {
        super(context);
    }

    public PSView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        paint = new Paint();
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.solo);
        mAlphaBmp = bitmap.extractAlpha();
    }

    public PSView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PSView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = 200;
        int height = width * mAlphaBmp.getHeight() / mAlphaBmp.getWidth();
        //绘制灰色阴影
//        paint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT,Shader.TileMode.REPEAT));
//        canvas.drawBitmap(bitmap, null, new Rect(10, 10, width, height), paint);
        canvas.drawRect(new Rect(10, 10, getWidth(), getHeight()), paint);
       /* canvas.translate(width, 0);
        paint.setColor(Color.BLACK);
        canvas.drawBitmap(bitmap, null, new Rect(10, 10, width, height), paint);*/
    }


}
