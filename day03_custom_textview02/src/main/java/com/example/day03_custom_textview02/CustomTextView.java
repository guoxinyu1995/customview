package com.example.day03_custom_textview02;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
//点击获取随机数和切换背景色
@SuppressLint("AppCompatCustomView")
public class CustomTextView extends TextView {
    /**
     * 需要绘制的文字
     */
    private String mText;
    /**
     * 文本的颜色
     */
    private int mTextColor;
    /**
     * 文本的大小
     */
    private int mTextSize = 10;
    /**
     * 绘制时控制文本绘制的范围
     */
    private Paint mPaint;

    private Paint mPaintIn;
    public CustomTextView(Context context) {
        super(context);
        init();
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
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
        //边框颜色
        canvas.drawRect(new Rect(0, 0, getMeasuredWidth(), getMeasuredHeight()), mPaintIn);
        //绘画文本
        canvas.drawText(mText, 0, 65, mPaint);


    }
    private void init() {
        //初始化
        mText = "4546";
        mTextSize = 50;
        mTextColor = Color.BLACK;

        //文本的画笔
        mPaint = new Paint();
        mPaint.setColor(mTextColor);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(mTextSize);

        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mText = randomText();
                String color = randomColor();
                mPaintIn.setColor(Color.parseColor("#F"+color));
                invalidate();
            }
        });

        //边框背景颜色的画笔
        mPaintIn = new Paint();
        mPaintIn.setAntiAlias(true);
        mPaintIn.setDither(true);
        mPaintIn.setStyle(Paint.Style.FILL);
        mPaintIn.setColor(getResources().getColor(R.color.colorPrimary));

    }

    //随机数
    private String randomText() {
        Random random = new Random();
        Set<Integer> set = new HashSet<Integer>();
        while (set.size() < 4) {
            int randomInt = random.nextInt(10);
            set.add(randomInt);
        }
        StringBuffer sb = new StringBuffer();
        for (Integer i : set) {
            sb.append("" + i);
        }

        return sb.toString();
    }

    //设置颜色的随机数
    private String randomColor() {
        Random random = new Random();
        Set<Integer> set = new HashSet<Integer>();
        while (set.size() < 5) {
            int randomInt = random.nextInt(10);
            set.add(randomInt);
        }
        StringBuffer sb = new StringBuffer();
        for (Integer i : set) {
            sb.append("" + i);
        }

        return sb.toString();
    }
}
