package com.barryyang.barryyangdemo.android.scopedstorage;

import com.barryyang.barryyangdemo.utils.Cfg;
import com.barryyang.barryyangdemo.utils.LogUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : BarryYang
 * @date : 2020/10/30 11:41 AM
 * @desc :Android10及以上存储
 */
public class AndroidQStorageImpl implements IStorage {

    private static final String TAG = "AndroidQStorageImpl";

    @Override
    public String readFile() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(StorageUtils.getExternalFilePath(null) + "/barryyangdemo/" + "/scopedstorage/" + "scopedstorage.txt");
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
        String rootPath = StorageUtils.getExternalFilePath(null) + "/barryyangdemo/";
        showLog("根目录路径" + rootPath);
        File rootFile = new File(rootPath);
        if (!rootFile.exists()) {
            boolean mkdirs = rootFile.mkdirs();
            showLog(mkdirs ? "创建ROOT_PATH文件夹成功" : "创建文件夹失败");
        }
        File scopeFile = new File(rootPath + "/scopedstorage/");
        if (!scopeFile.exists()) {
            boolean mkdirs = scopeFile.mkdirs();
            showLog(mkdirs ? "创建ROOT_SCOPED_PATH文件夹成功" : "创建文件夹失败");
        }
        File fileName = new File(rootPath + "/scopedstorage/" + "scopedstorage.txt");
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
            fileOutputStream = new FileOutputStream(StorageUtils.getExternalFilePath(null) + "/barryyangdemo/" + "/scopedstorage/" + "scopedstorage.txt", true);
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
