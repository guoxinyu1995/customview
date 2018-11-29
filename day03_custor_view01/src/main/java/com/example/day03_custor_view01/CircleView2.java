package com.example.day03_custor_view01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
//内部小圆
public class CircleView2 extends View {
    private Paint mPaint;
    private RectF rectF;

    public CircleView2(Context context) {
        super(context);
        init();
    }

    public CircleView2(Context context,AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setTextSize(40);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.FILL);

        rectF = new RectF();
        rectF.top = -100;
        rectF.left = 0;
        rectF.right = 150;
        rectF.bottom = 100;
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(150,150);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLACK);
        canvas.drawArc(rectF,60,60,true,mPaint);
        mPaint.setColor(Color.RED);
        canvas.drawCircle(75,75,60,mPaint);
        mPaint.setColor(Color.BLACK);
        canvas.drawText("go",55,80,mPaint);
    }
}
