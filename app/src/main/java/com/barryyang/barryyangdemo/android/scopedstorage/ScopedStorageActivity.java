package com.barryyang.barryyangdemo.android.scopedstorage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.LogUtil;

/**
 * @author : BarryYang
 * @date : 2020/7/31 5:36 PM
 * @desc :Android  Q 适配
 * <p>
 * 但是在android10的时候，Google还是为开发者考虑，留了一手。在targetSdkVersion = 29应用中，设置android:requestLegacyExternalStorage="true"，
 * 就可以不启动分区存储，让以前的文件读取正常使用。但是targetSdkVersion = 30中不行了，强制开启分区存储。
 * 当然，作为人性化的android，还是为开发者留了一小手，如果是覆盖安装呢，可以增加android:preserveLegacyExternalStorage="true"，
 * 暂时关闭分区存储，好让开发者完成数据迁移的工作。为什么是暂时呢？因为只要卸载重装，就会失效了。
 */
public class ScopedStorageActivity extends AppCompatActivity {

    private static final String TAG = "ScopedStorageActivity";

    private boolean hasPermission;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scopedstorage);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                || ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1001);
        } else {
            hasPermission = true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1001) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                showToast("已经同意");
                hasPermission = true;
            } else {
                hasPermission = false;
                showToast("没有读写权限");
            }
        }
    }

    /**
     * 创建文件
     *
     * @param view
     */
    public void createFile(View view) {
        if (hasPermission) {
            ScopedStorageManager.getInstance().createFile();
        } else {
            showToast("没有权限");
        }
    }

    /**
     * 写入文件
     *
     * @param view
     */
    public void writeFile(View view) {
        if (hasPermission) {
            ScopedStorageManager.getInstance().writeFile();
        } else {
            showToast("没有权限");
        }
    }

    /**
     * 读取文件
     *
     * @param view
     */
    public void readFile(View view) {
        if (hasPermission) {
            ScopedStorageManager.getInstance().readFile();
        } else {
            showToast("没有权限");
        }
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private void showLog(String msg) {
        LogUtil.printLogDebug(TAG, msg);
    }
}
