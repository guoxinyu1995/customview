package com.example.day03_custom_textview01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
//点击获取随机数和切换背景色
@SuppressLint("AppCompatCustomView")
public class CustomTextView extends TextView {
    //文本
    private String mText;
    //文本颜色
    private int mTexeColor;
    //文本大小
    private int mTextSize;
    /**
     * 绘制时控制文本绘制的范围
     * */
    private Rect mBound;
    private Paint mPaint;
    private Paint mPaintIn;
    public CustomTextView(Context context) {
        this(context,null);
    }

    public CustomTextView(Context context,  AttributeSet attrs) {
        this(context, attrs,0);

    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获得我们所定义的自定义样式属性
        TypedArray array = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomTextView,defStyleAttr,0);
        int n = array.getIndexCount();
        for(int i = 0;i<n;i++){
            int index = array.getIndex(i);
            switch (index){
                case R.styleable.CustomTextView_text:
                    mText = array.getString(index);
                    break;
                case R.styleable.CustomTextView_textColor:
                    //默认颜色
                   mTexeColor = array.getColor(index,Color.BLUE);
                    break;
                case R.styleable.CustomTextView_textSize:
                    //默认大小
                    mTextSize = array.getDimensionPixelSize(
                            index, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 16,
                                    getResources().getDisplayMetrics())
                    );
                    break;
            }
        }
        array.recycle();
        //绘制文本宽高
        mPaint = new Paint();
        mPaint.setTextSize(mTextSize);
        mBound = new Rect();
        mPaint.getTextBounds(mText,0,mText.length(),mBound);
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mText = randomText();
                String color = randomColor();
                mPaintIn.setColor(Color.parseColor("#F"+color));
               invalidate();
            }
        });
    }
    //设置随机数
    private String randomText() {
        Random random = new Random();
        Set<Integer> set = new HashSet<Integer>();
        while (set.size() < 4)
        {
            int randomInt = random.nextInt(10);
            set.add(randomInt);
        }
        StringBuffer sb = new StringBuffer();
        for (Integer i : set)
        {
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
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height ;
        if (widthMode == MeasureSpec.EXACTLY)
        {
            width = widthSize;
        } else
        {
            mPaint.setTextSize(mTextSize);
            mPaint.getTextBounds(mText, 0, mText.length(), mBound);
            float textWidth = mBound.width();
            int desired = (int) (getPaddingLeft() + textWidth + getPaddingRight());
            width = desired;
        }

        if (heightMode == MeasureSpec.EXACTLY)
        {
            height = heightSize;
        } else
        {
            mPaint.setTextSize(mTextSize);
            mPaint.getTextBounds(mText, 0, mText.length(), mBound);
            float textHeight = mBound.height();
            int desired = (int) (getPaddingTop() + textHeight + getPaddingBottom());
            height = desired;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint);
        mPaint.setColor(mTexeColor);
        canvas.drawText(mText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);
        //边框背景颜色的画笔
        mPaintIn = new Paint();
        mPaintIn.setAntiAlias(true);
        mPaintIn.setDither(true);
        mPaintIn.setStyle(Paint.Style.FILL);
        mPaintIn.setColor(getResources().getColor(R.color.colorPrimary));
    }
}
