package com.barryyang.barryyangdemo.okhttp;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.LogUtil;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author : BarryYang
 * @date : 2020/11/5 2:43 PM
 * @desc :
 */
public class OkHttpActivity extends AppCompatActivity {

    private static final String TAG = "OkHttpActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
    }

    public void okhttpRequest(View view) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor()
//                .addInterceptor()
                ;
        final OkHttpClient build = okHttpClient.build();
//        Disposable subscribe = Observable.create(new ObservableOnSubscribe<Object>() {
//
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Exception {
        Request request = new Request.Builder()
                .url("http://moon-apis.mting.info/yyting/userclient/ClientGetStrategy.action?imei=TEFaWS0wMjAwMDAwMDAwMDA%3D&nwt=1&q=6601&sc=4cd4b8e9bbce687a1b3c166ccc4edf5f&strategyType=1&token=3hXPeQXh8MnP1SZKF6GjFg**_XDPkXCgu7vtlCyjzJCRcUA**")
                .addHeader("name", "header")
                .build();
        //  try {
        build.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                LogUtil.printLogDebug(TAG, e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                LogUtil.printLogDebug(TAG, response.body().toString());
            }
        });
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Object>() {
//                    @Override
//                    public void accept(Object o) throws Exception {
//
//                    }
//                });

    }
}
