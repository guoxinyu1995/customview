package com.example.day03_custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {
    private Paint mPain;
    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context,AttributeSet attrs) {
        super(context, attrs);

       init();
    }
    public void init(){
        mPain = new Paint();
        //设置颜色
        mPain.setColor(Color.RED);
        mPain.setStrokeWidth(5);
        mPain.setStyle(Paint.Style.FILL);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(50,50,50,300,mPain);
        canvas.drawLine(50,300,300,300,mPain);
        canvas.drawRect(70,100,80,300,mPain);
        mPain.setColor(Color.BLUE);
        canvas.drawRect(90,110,100,300,mPain);
        mPain.setColor(Color.YELLOW);
        canvas.drawRect(110,120,120,300,mPain);
    }
}
