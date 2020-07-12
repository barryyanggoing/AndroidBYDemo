package com.barryyang.barryyangdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import android.os.Bundle;
import android.view.View;

/**
 * 测试各种
 *
 * @author barryyang
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraintlayout_constrainthelper);

//        final CircularRevealHelper circularRevealHelper = findViewById(R.id.circularRevealHelper);
//        final ConstraintLayout constraintLayout = findViewById(R.id.root);
//        findViewById(R.id.TextView3).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                circularRevealHelper.setReferencedIds(new int[]{R.id.TextView3, R.id.TextView4});
//                circularRevealHelper.updatePostLayout(constraintLayout);
//            }
//        });


//        final Placeholder placeholder = findViewById(R.id.placeholder);
//        findViewById(R.id.TextView1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                placeholder.setContentId(R.id.TextView1);
//            }
//        });
    }
}