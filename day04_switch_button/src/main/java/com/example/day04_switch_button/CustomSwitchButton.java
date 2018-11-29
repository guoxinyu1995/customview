package com.example.day04_switch_button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
//按钮切换
public class CustomSwitchButton extends RelativeLayout {
    private Context mContext;
    private boolean isChecked = false;
    public CustomSwitchButton(Context context) {
        super(context);
        mContext = context;
        init();
    }
    public CustomSwitchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }
    private void init() {
        final ImageView imageView = new ImageView(mContext);
        imageView.setBackgroundResource(R.drawable.off);
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isChecked){
                    imageView.setBackgroundResource(R.drawable.off);
                }else{
                    imageView.setBackgroundResource(R.drawable.on);
                }
                isChecked = !isChecked;
            }
        });
        addView(imageView);
    }
}
