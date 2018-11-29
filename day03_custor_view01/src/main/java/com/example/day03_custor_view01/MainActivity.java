package com.example.day03_custor_view01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;

public class MainActivity extends AppCompatActivity {

    private CircleView2 circleView2;
    private CircleView01 circleView01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        circleView01 = findViewById(R.id.circle1);
        circleView2 = findViewById(R.id.circle2);
        circleView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float degress = (float) (720+Math.random()*1000);
                RotateAnimation animation = new RotateAnimation(0,degress,250,250);
                animation.setDuration(5000);
                animation.setFillAfter(true);
                circleView01.startAnimation(animation);
            }
        });
    }
}
