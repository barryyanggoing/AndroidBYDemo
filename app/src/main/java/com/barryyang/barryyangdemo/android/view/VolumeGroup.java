package com.barryyang.barryyangdemo.android.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.barryyang.barryyangdemo.R;

public class VolumeGroup extends LinearLayout {

    private static final int MAX_VOLUME_COUNT = 21;

    public VolumeGroup(Context context) {
        this(context, null);
    }

    public VolumeGroup(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VolumeGroup(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setHorizontalGravity(HORIZONTAL);
    }

    public void addVolumeView() {
        for (int count = 0; count < MAX_VOLUME_COUNT; count++) {
            VolumeView volumeView = new VolumeView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
            layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.dimen_10);
            volumeView.setLayoutParams(layoutParams);
            addView(volumeView);
        }
    }
}
