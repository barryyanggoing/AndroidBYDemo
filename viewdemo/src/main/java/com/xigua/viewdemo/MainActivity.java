package com.xigua.viewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ScrollLinearLayout view = findViewById(R.id.ll_container);
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                view.smoothScroll(-200);
//            }
//        });
        HorizontalScrollViewEx horizontalScrollViewEx = findViewById(R.id.scrollview);
        for (int i = 0; i < 5; i++) {
            RecyclerListView recyclerListView = new RecyclerListView(this);
            recyclerListView.setAdapter();
            horizontalScrollViewEx.addView(recyclerListView);
        }
    }
}