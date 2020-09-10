package com.barryyang.barryyangdemo.java.stream;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author : BarryYang
 * @date : 2020/7/28 10:28 PM
 * @desc :输入输出流
 */
public class StreamActivity extends AppCompatActivity {

    private static final String TAG = "StreamActivity";

    private boolean hasPermission = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);
        int hasReadPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int hasWritePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (hasReadPermission == PackageManager.PERMISSION_GRANTED && hasWritePermission == PackageManager.PERMISSION_GRANTED) {
            hasPermission = true;
            createFile(Cfg.ROOT_PATH, Cfg.FILE_NAME);
            createFile(Cfg.ROOT_PATH, Cfg.RANDOM_FILE_NAME);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1001);
        }
    }

    private File createFileDir(String path) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private File createFile(String path, String fileName) {
        createFileDir(path);
        File file = new File(path, fileName);
        try {
            if (!file.exists()) {
                boolean newFile = file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1001) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                hasPermission = true;
                createFile(Cfg.ROOT_PATH, Cfg.FILE_NAME);
            } else {
                hasPermission = false;
            }
        } else {
            hasPermission = false;
        }
    }

    /**
     * 输出流，写入数据
     *
     * @param view
     */
    public void outputStream(View view) {
        if (hasPermission) {
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(Cfg.STREAM_PATH, true);
                fileOutputStream.write("BarryYang输入输出流测试DEMO\n".getBytes());
                //刷新输出流
                fileOutputStream.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileOutputStream != null) {
                        //关闭输出流
                        fileOutputStream.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            Toast.makeText(this, "请授权", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 输入流，读取数据
     *
     * @param view
     */
    public void inputStream(View view) {
        if (hasPermission) {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(Cfg.STREAM_PATH);
                int len;
                //先把字节存入到缓冲数组中，一下读取整个数组的数据
                byte[] buf = new byte[1024 * 4];
                while ((len = fileInputStream.read(buf)) != -1) {
                    String s = new String(buf, 0, len);
                    LogUtil.printLogDebug(TAG, s);
                    Toast.makeText(this, s, Toast.LENGTH_LONG).show();
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
            Toast.makeText(this, "请授权", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 随机读取文件
     *
     * @param view
     */
    public void randomAccessFileRead(View view) {
        if (hasPermission) {
            RandomAccessFile randomAccessFile = null;
            try {
                randomAccessFile = new RandomAccessFile(Cfg.RANDOM_PATH, "rw");
                int counter = randomAccessFile.readInt();
                String content = randomAccessFile.readUTF();
                LogUtil.printLogDebug(TAG, counter + "-->" + content);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            Toast.makeText(this, "请授权", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 随机写入文件
     *
     * @param view
     */
    public void randomAccessFileWrite(View view) {
        if (hasPermission) {
            RandomAccessFile randomAccessFile = null;
            try {
                randomAccessFile = new RandomAccessFile(Cfg.RANDOM_PATH, "rw");
                randomAccessFile.writeInt(0);
                randomAccessFile.writeUTF("BarryYang随机访问文件测试DEMO");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            Toast.makeText(this, "请授权", Toast.LENGTH_LONG).show();
        }
    }
}
