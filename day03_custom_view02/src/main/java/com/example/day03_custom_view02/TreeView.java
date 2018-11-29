package com.example.day03_custom_view02;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
//柱状图
public class TreeView extends View {

    private Paint mPaint;
    private List<Integer> list;
    public TreeView(Context context) {
        super(context);
        list = new ArrayList<>();
        init();
    }

    public TreeView(Context context,AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public void setList(List<Integer> lists){
        this.list = lists;
    }
    private void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(10);
        mPaint.setStyle(Paint.Style.FILL);
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
        //划线 x,y轴
        canvas.drawLine(20,20,20,300,mPaint);
        canvas.drawLine(20,300,300,300,mPaint);
        //画拄
        canvas.drawRect(30,300-(list.get(0)*280/100),50,300,mPaint);
        canvas.drawRect(70,300-(list.get(1)*280/100),90,300,mPaint);
        canvas.drawRect(110,300-(list.get(2)*280/100),130,300,mPaint);
    }
}
