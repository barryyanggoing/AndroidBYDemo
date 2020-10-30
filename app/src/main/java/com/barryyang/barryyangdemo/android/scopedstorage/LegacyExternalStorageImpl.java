package com.barryyang.barryyangdemo.android.scopedstorage;

import android.widget.Toast;

import com.barryyang.barryyangdemo.utils.Cfg;
import com.barryyang.barryyangdemo.utils.LogUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : BarryYang
 * @date : 2020/10/30 11:41 AM
 * @desc :Android10以下存储
 */
public class LegacyExternalStorageImpl implements IStorage {

    private static final String TAG = "LegacyExternalStorageImpl";

    @Override
    public String readFile() {
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
        return null;
    }

    @Override
    public void createFile() {
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
    }

    @Override
    public void writeFile() {
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
    }

    private void showLog(String msg) {
        LogUtil.printLogDebug(TAG, msg);
    }
}
