package com.barryyang.barryyangdemo.components;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.barryyang.barryyangdemo.R;

/**
 * @author : BarryYang
 * @date : 2020/7/31 1:13 PM
 * @desc :
 */
public class ComponentsActivity extends AppCompatActivity {

    private TextView mTvUserInfo;

    private OrderViewModel mUserViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components);
        getLifecycle().addObserver(new ActivityLifeObserver());
        mTvUserInfo = findViewById(R.id.tv_userinfo);
        loadData();
    }

    public void changeUserInfo(View view) {
        mUserViewModel.changeData(this);
    }

    private void loadData() {
        mUserViewModel = ViewModelProviders.of(this).get(OrderViewModel.class);
        mUserViewModel.getData(this).observe(this, new Observer<Order>() {
            @Override
            public void onChanged(Order order) {
                mTvUserInfo.setText(order.toString());
            }
        });
    }
}
