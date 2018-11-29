package com.example.day03_custom_view02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText ed_one;
    private EditText ed_two;
    private EditText ed_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //获取资源id
        ed_one = findViewById(R.id.ed_one);
        ed_two = findViewById(R.id.ed_two);
        ed_three = findViewById(R.id.ed_three);
        btn = findViewById(R.id.btn);
        //点击确定
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer one = Integer.valueOf(ed_one.getText().toString());
                Integer two = Integer.valueOf(ed_two.getText().toString());
                Integer three = Integer.valueOf(ed_three.getText().toString());
                if(one>=0&&one<=100 && two>=0&&two<=100 && three>=0&&three<=100){
                    Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                    intent.putExtra("one",one);
                    intent.putExtra("two",two);
                    intent.putExtra("three",three);
                    startActivity(intent);
                }else if(one>100 || two>100 || three>100){
                    ed_one.setText(0+"");
                    ed_two.setText(0+"");
                    ed_three.setText(0+"");
                }

            }
        });
    }
}
