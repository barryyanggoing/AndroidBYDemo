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
import com.barryyang.barryyangdemo.utils.Cfg;
import com.barryyang.barryyangdemo.utils.LogUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : BarryYang
 * @date : 2020/7/31 5:36 PM
 * @desc :Android  Q 适配
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
            if (grantResults[0] == 1001) {
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
            File rootFile = new File(Cfg.ROOT_PATH);
            if (!rootFile.exists()) {
                boolean mkdirs = rootFile.mkdirs();
                showLog(mkdirs ? "创建ROOT_PATH文件夹成功" : "创建文件夹失败");
            }
            File scopeFile = new File(Cfg.ROOT_SCOPED_PATH);
            if (!scopeFile.exists()) {
                boolean mkdirs = scopeFile.mkdirs();
                showLog(mkdirs ? "创建ROOT_SCOPED_PATH文件夹成功" : "创建文件夹失败");
            }
            File fileName = new File(Cfg.SCOPED_STORAGE_FILE_PATH);
            if (!fileName.exists()) {
                try {
                    boolean newFile = fileName.createNewFile();
                    showLog(newFile ? "创建文件scopedstorage.txt成功" : "创建文件scopedstorage.txt失败");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(Cfg.SCOPED_STORAGE_FILE_PATH, true);
                fileOutputStream.write("BarryYang输入输出流测试DEMO\n".getBytes());
                fileOutputStream.flush();
                showLog("写入BarryYang输入输出流测试DEMO成功");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
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
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(Cfg.SCOPED_STORAGE_FILE_PATH);
                int len;
                //先把字节存入到缓冲数组中，一下读取整个数组的数据
                byte[] buf = new byte[1024 * 4];
                while ((len = fileInputStream.read(buf)) != -1) {
                    String s = new String(buf, 0, len);
                    showLog("读取文件成功：" + s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
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
