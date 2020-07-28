package com.barryyang.barryyangdemo.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author : BarryYang
 * @date : 2020/7/27 5:00 PM
 * @desc :bitmap优化
 */
public class BitmapActivity extends AppCompatActivity {

    private static final String TAG = "BitmapActivity";

    /**
     * density	    0.75	1	    1.5	    2	    3	    3.5	     4
     * densityDpi	120	    160	    240	    320	    480	    560	     640
     * DpiFolder	ldpi	mdpi	hdpi	xhdpi	xxhdpi	xxxhdpi	 xxxxhdpi
     * <p>
     * bitmap内存占用：总像数*每个像数占用的字节数
     * 1.总像数：横向像数数量*竖向像数数量
     * 2.每个像数占用的字节数：由bitmap可配置参数Config来决定
     * <p>
     * 具体
     * Bitmap内存占用 ≈ 像素数据总大小 = 图片宽 × 图片高× (设备分辨率/资源目录分辨率)^2 × 每个像素的字节大小
     * 如下：
     * 17,280,000 = 800 * 600 * (480 / 160 )^2 * 4
     */

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        //优化前
        bitmapWithDrawable("mdpi", R.id.iv_bitmap_m, R.mipmap.testm, (TextView) findViewById(R.id.tv_m_info));
        bitmapWithDrawable("hdpi", R.id.iv_bitmap_h, R.mipmap.testh, (TextView) findViewById(R.id.tv_h_info));
        bitmapWithDrawable("xhdpi", R.id.iv_bitmap_xh, R.mipmap.testxh, (TextView) findViewById(R.id.tv_xh_info));
        bitmapWithDrawable("xxhdpi", R.id.iv_bitmap_xxh, R.mipmap.testxxh, (TextView) findViewById(R.id.tv_xxh_info));
        //优化后
        optimizeBitmap((TextView) findViewById(R.id.tv_m_info), R.mipmap.testm, Bitmap.Config.RGB_565, 2);
        optimizeBitmap((TextView) findViewById(R.id.tv_h_info), R.mipmap.testh, Bitmap.Config.RGB_565, 2);
        optimizeBitmap((TextView) findViewById(R.id.tv_xh_info), R.mipmap.testxh, Bitmap.Config.RGB_565, 2);
        optimizeBitmap((TextView) findViewById(R.id.tv_xxh_info), R.mipmap.testxxh, Bitmap.Config.RGB_565, 2);
    }

    /**
     * 优化bitmap
     *
     * @param textView
     * @param resId
     * @param config
     * @param perSize
     */
    private void optimizeBitmap(TextView textView, int resId, Bitmap.Config config, float perSize) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = config;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), resId, options);
        options.inJustDecodeBounds = false;
        options.inSampleSize = 2;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId, options);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float size = width * height * perSize / 1024f / 1024f;
        String s = textView.getText().toString();
        textView.setText(s + "\n" + "优化后占用内存大小：" + size + "M");
    }

    /**
     * 打印图片的相关信息
     *
     * @param resType
     * @param id
     * @param resId
     * @param textView
     */
    private void bitmapWithDrawable(String resType, int id, int resId, TextView textView) {
        ImageView imageView = findViewById(id);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resId);
        imageView.setImageBitmap(bitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config config = bitmap.getConfig();
        float size = width * height * 4f / 1024f / 1024f;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int densityDpi = displayMetrics.densityDpi;
        float density = displayMetrics.density;
        LogUtil.printLogDebug(TAG, resType + ",分辨率：" + width + "x" + height + ",config:" + config + ",占用内存图片大小："
                + size + "M" + ",densityDpi:" + densityDpi + ",density:" + density);
        textView.setText(resType + "\n分辨率：" + width + "x" + height + "\nconfig:" + config + "\n占用内存图片大小："
                + size + "M" + "\ndensityDpi:" + densityDpi + "\ndensity:" + density);
    }
}
