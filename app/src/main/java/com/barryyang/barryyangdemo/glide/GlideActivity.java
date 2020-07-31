package com.barryyang.barryyangdemo.glide;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

/**
 * @author : BarryYang
 * @date : 2020/7/31 11:20 AM
 * @desc :
 */
public class GlideActivity extends AppCompatActivity {

    private final String imgUrl = "https://avatar.csdn.net/9/7/A/3_zhangphil.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        ImageView imageView = findViewById(R.id.iv_glide);
        loadImage(imageView);
    }

    /**
     * 设置图片
     *
     * @param imageView
     */
    private void loadImage(ImageView imageView) {
        Glide.with(this).load(imgUrl).apply(RequestOptions.bitmapTransform(new RoundedCorners(50))).into(imageView);
    }
}
