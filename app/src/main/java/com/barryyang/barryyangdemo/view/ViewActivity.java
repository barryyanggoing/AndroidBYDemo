package com.barryyang.barryyangdemo.view;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author : BarryYang
 * @date : 2020/7/27 11:50 AM
 * @desc :自定义view
 */
public class ViewActivity extends AppCompatActivity {

    private static final String TAG = "ViewActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);
        testMotionView();
    }

    /**
     * x，y,left,top都是相对父view
     */
    private void testMotionView() {
        final MotionView motionView = findViewById(R.id.motion_view);
        motionView.post(new Runnable() {
            @Override
            public void run() {
                int left = motionView.getLeft();
                int top = motionView.getTop();
                float x = motionView.getX();
                float y = motionView.getY();
                LogUtil.printLogDebug(TAG, "motionview相对于父view:" + left + "----" + top);
                LogUtil.printLogDebug(TAG, "motionview的坐标位置:" + x + "----" + y);
            }
        });
    }

    public void performAnimation(View view) {
        Button button = findViewById(R.id.btn_anim);
        ViewWrapper viewWrapper = new ViewWrapper(button);
        ObjectAnimator.ofInt(viewWrapper, "width", 500).setDuration(1000).start();
    }
}
