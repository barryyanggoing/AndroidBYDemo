package com.barryyang.barryyangdemo.android.scopedstorage;

import android.os.Build;
import android.text.TextUtils;

import com.barryyang.barryyangdemo.utils.Cfg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author : BarryYang
 * @date : 2020/8/12 3:52 PM
 * @desc :Android Q音频文件和电子书籍迁移到新的目录
 */
public class DownloadFileTransfer {

    private static final DownloadFileTransfer INSTANCE = new DownloadFileTransfer();

    private DownloadFileTransfer() {
    }

    public static DownloadFileTransfer getInstance() {
        return INSTANCE;
    }

    public void transfer() {
        File file = new File(Cfg.ROOT_PATH);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && file.exists()) {
            copyFolder(Cfg.ROOT_SCOPED_PATH, StorageUtils.getExternalFilePath(null) + "/barryyangdemo/" + "/scopedstorage/");
            deleteFileDirs(file.getAbsolutePath());
        }
    }

    /**
     * 上面deleteFileDir（）方法写的有问题，重写一个方法
     *
     * @param path
     */
    private void deleteFileDirs(String path) {
        if (TextUtils.isEmpty(path)) {
            return;
        }
        File file = new File(path);
        if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            int count = files.length;
            for (int i = 0; i < count; i++) {
                deleteFileDirs(files[i].getAbsolutePath());
            }
            file.delete();
        }
    }

    /**
     * 文件迁移
     *
     * @param pOldPath
     * @param pNewPath
     */
    private void copyFolder(String pOldPath, String pNewPath) {
        try {
            File oldFile = new File(pOldPath);
            String[] file = oldFile.list();
            if (file != null && file.length > 0) {
                for (String childFileName : file) {
                    File temp = new File(pOldPath + File.separator + childFileName);
                    if (temp.isFile()) {
                        FileInputStream input = new FileInputStream(temp);
                        FileOutputStream output = new FileOutputStream(pNewPath + File.separator + childFileName);
                        byte[] b = new byte[1024 * 5];
                        int len;
                        while ((len = input.read(b)) != -1) {
                            output.write(b, 0, len);
                        }
                        output.flush();
                        output.close();
                        input.close();
                    } else if (temp.isDirectory()) {
                        File newFile = new File(pNewPath + File.separator + childFileName);
                        if (!newFile.exists()) {
                            newFile.mkdirs();
                        }
                        copyFolder(pOldPath + File.separator + childFileName, pNewPath + File.separator + childFileName);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
