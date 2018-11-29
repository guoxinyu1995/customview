package com.example.day03_custom_view02;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
//柱状图
public class LoginActivity extends AppCompatActivity {
    private List<Integer> list;
    private TreeView treeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //接收值
        Intent intent = getIntent();
        list = new ArrayList<>();
        int one = intent.getIntExtra("one", 0);
        int two = intent.getIntExtra("two", 0);
        int three = intent.getIntExtra("three", 0);
        list.add(one);
        list.add(two);
        list.add(three);
        treeView = findViewById(R.id.tree);
        treeView.setList(list);
    }
}
