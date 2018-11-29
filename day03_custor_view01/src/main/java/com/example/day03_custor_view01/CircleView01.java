package com.example.day03_custor_view01;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
//转盘  外部大圆 用扇形画
public class CircleView01 extends View {
    private Paint mPaint;
    private RectF rectF;
    private float mStartAngle = 0;
    public CircleView01(Context context) {
        super(context);
        init();
    }

    public CircleView01(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10);
        mPaint.setTextSize(30);

        rectF = new RectF();
        rectF.top = 50;
        rectF.left = 50;
        rectF.right = 450;
        rectF.bottom = 450;
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
        String[] text = {"一 等 奖","二 等 奖","三 等 奖","四 等 奖","五 等 奖","六 等 奖"};
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                mPaint.setColor(Color.BLUE);
            }else{
                mPaint.setColor(Color.GREEN);
            }
            canvas.drawArc(rectF,mStartAngle,60,true,mPaint);
            mPaint.setColor(Color.RED);
            mPaint.setTextSize(20);
            Path path = new Path();
            path.addArc(rectF,mStartAngle+20,60);
            canvas.drawTextOnPath(text[i],path,0,50,mPaint);
            mStartAngle += 60;
        }
        /*String[] text = {"一 等 奖","二 等 奖","三 等 奖","四 等 奖","五 等 奖","六 等 奖"};
        for (int i = 0; i < 6; i++) {
            mPaint.setColor(Color.YELLOW);
            mPaint.setTextSize(20);
            Path path = new Path();
            path.addArc(rectF,mStartAngle+20,60);
            canvas.drawTextOnPath(text[i],path,0,50,mPaint);
            mStartAngle += 60;
        }*/

    }
}
