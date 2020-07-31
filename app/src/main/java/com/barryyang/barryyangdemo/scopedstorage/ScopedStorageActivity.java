package com.barryyang.barryyangdemo.scopedstorage;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.Cfg;
import com.barryyang.barryyangdemo.utils.LogUtil;

import java.io.File;

/**
 * @author : BarryYang
 * @date : 2020/7/31 5:36 PM
 * @desc :Android  Q 适配
 */
public class ScopedStorageActivity extends AppCompatActivity {

    private static final String TAG = "ScopedStorageActivity";

    private boolean mHasPermission = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scopedstorage);
        requestPermission();
    }

    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            LogUtil.printLogDebug(TAG, "Android 10存在写权限");
            mHasPermission = true;
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1001);
        }
    }

    /**
     * Android Q下创建文件
     * <p>
     * Scoped Storage策略是否打开,当修改了requestLegacyExternalStorage属性的值，必须要卸载掉旧APK，重新安装才会生效。
     */
    private void createRootFileLessQ() {
        boolean externalStorageLegacy = Environment.isExternalStorageLegacy();
        LogUtil.printLogDebug(TAG, "Scoped Storage策略是否打开:" + externalStorageLegacy);
        File file = new File(Cfg.ROOT_PATH);
        if (!file.exists()) {
            boolean mkdir = file.mkdir();
            LogUtil.printLogDebug(TAG, mkdir ? "创建根目录成功" : "创建根目录失败");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1001) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                LogUtil.printLogDebug(TAG, "Android 10存在写权限");
                mHasPermission = true;
            } else {
                LogUtil.printLogDebug(TAG, "请在设置中同意权限");
            }
        }
    }

    /**
     * 创建根目录文件
     *
     * @param view
     */
    public void createFile(View view) {
        if (mHasPermission) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                createRootFileLessQ();
            } else {
                LogUtil.printLogDebug(TAG, "请使用Android10的方式创建文件夹");
                createRootFileQ();
            }
        } else {
            Toast.makeText(this, "请授权", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Android Q下创建文件夹，创建的路径不一样
     */
    private void createRootFileQ() {

    }
}
