package com.barryyang.barryyangdemo.android.deviceinfo;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.LogUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @author : BarryYang
 * @date : 2020/10/30 9:48 AM
 * @desc :
 */
public class DeviceInfoActivity extends AppCompatActivity {

    private static final String TAG = "DeviceInfoActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deviceinfo);
    }

    /**
     * 1.Android 6.0以下不需要申请权限,通过telephonyManager.getDeviceId()获取imei码
     * 2.Android 6.0-Android 8.0：需要申请READ_PHONE_STATE权限，可以通过getDeviceId()方法获取到IMEI码，如果用户拒绝了权限，会抛出java.lang.SecurityException异常
     */
    public void getImei(View view) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            String deviceId = telephonyManager.getDeviceId();
            LogUtil.printLogDebug(TAG, "Android6.0以下获取imei:" + deviceId);
        } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                String deviceId = telephonyManager.getDeviceId();
                LogUtil.printLogDebug(TAG, "Android6.0-8.0以下获取imei:" + deviceId);
            }
        } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                String deviceId = telephonyManager.getImei();
                LogUtil.printLogDebug(TAG, "Android8.0-10.0以下获取imei:" + deviceId);
            }
        }
    }

    /**
     * Android 6.0以下系统：需要权限ACCESS_WIFI_STATE，不需要申请，配置文件中申明即可
     * Android6.0-7.0系统：android 6.0以后 将不再能通过 wifimanager 获取mac，获取到的mac将是固定的：02:00:00:00:00:00 。
     *
     * @param view
     */
    public void getMac(View view) {
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
//            WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
//            String macAddress = connectionInfo.getMacAddress();
//            //Android6.0以下手机系统macAddress:c8:f2:30:01:be:b7
//            LogUtil.printLogDebug(TAG, "Android6.0以下手机系统macAddress:" + macAddress);
//        } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
//            String macAddress = getMacFromFile();
//            LogUtil.printLogDebug(TAG, "Android6.0-7.0手机系统macAddress:" + macAddress);
//        } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
//            String macAddress = getMacFromHardware();
//            //Android7.0以后手机系统macAddress:b0:e5:ed:fe:da:49
//            LogUtil.printLogDebug(TAG, "Android7.0-10.0以后手机系统macAddress:" + macAddress);
//        } else {
//            LogUtil.printLogDebug(TAG, "Android11.0以后手机系统macAddress:");
//        }
    }

    /**
     * Android6-7获取MAC地址
     *
     * @return
     */
    private static String getMacFromFile() {
        String WifiAddress = "";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(new File("/sys/class/net/wlan0/address"));
            bufferedReader = new BufferedReader(fileReader);
            WifiAddress = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return WifiAddress;
    }

    /**
     * Android7及之后获取MAC地址
     *
     * @return
     */
    private static String getMacFromHardware() {
        String WifiAddress = "";
        try {
            Enumeration<NetworkInterface> enumeration = NetworkInterface.getNetworkInterfaces();
            if (enumeration == null) {
                return null;
            }
            while (enumeration.hasMoreElements()) {
                NetworkInterface netInterface = enumeration.nextElement();
                if (netInterface.getName().equals("wlan0")) {
                    byte[] b = netInterface.getHardwareAddress();
                    StringBuffer buffer = new StringBuffer();
                    for (int i = 0; i < b.length; i++) {
                        if (i != 0) {
                            buffer.append(':');
                        }
                        String str = Integer.toHexString(b[i] & 0xFF);
                        buffer.append(str.length() == 1 ? 0 + str : str);
                    }
                    WifiAddress = buffer.toString();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return WifiAddress;
    }

    /**
     * 获取设备Androidid,不需要权限，没有版本限制，但是不能保证唯一或者能获取到值
     *
     * @param view
     */
    public void getAndroidId(View view) {
        String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        LogUtil.printLogDebug(TAG, "AndroidId:" + androidId);
    }

    /**
     * 获取手机imsi信息
     *
     * @param view
     */
    public void getIMSI(View view) {
//        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
//            String imsi = telephonyManager.getSubscriberId();
//            LogUtil.printLogDebug(TAG, "IMSI:" + imsi);
//        } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
//            if (telephonyManager != null && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
//                String imsi = telephonyManager.getSubscriberId();
//                LogUtil.printLogDebug(TAG, "IMSI:" + imsi);
//            }
//        } else {
//            //Caused by: java.lang.SecurityException: getSubscriberId: The user 10797 does not meet the requirements to access device identifiers.
//            if (telephonyManager != null && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
//                String imsi = telephonyManager.getSubscriberId();
//                LogUtil.printLogDebug(TAG, "Android10以上IMSI:" + imsi);
//            }
//        }
    }

    /**
     * 获取SerialNo
     *
     * @param view
     */
    public void getSerialNo(View view) {
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
//            String serial = Build.SERIAL;
//            LogUtil.printLogDebug(TAG, "Android8.0以下:" + serial);
//        } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
//                String serial = Build.getSerial();
//                LogUtil.printLogDebug(TAG, "Android8.0-10.0:" + serial);
//            }
//        } else {
//            LogUtil.printLogDebug(TAG, "Android10.0以上:");
//        }
    }
}
