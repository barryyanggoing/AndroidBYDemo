package com.barryyang.barryyangdemo.rxjava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.LogUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author : BarryYang
 * @date : 2020/7/31 10:40 AM
 * @desc :
 */
public class RxJavaActivity extends AppCompatActivity {

    private static final String TAG = "RxJavaActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava);
    }

    public void threadTest(View view) {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Object> emitter) throws Exception {
                emitter.onNext(0);
                emitter.onComplete();
                LogUtil.printLogDebug("当前线程1：" + Thread.currentThread().getName());
            }
        })
                .subscribeOn(Schedulers.io())
                .delay(1, TimeUnit.MILLISECONDS)
                //.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        LogUtil.printLogDebug("当前线程2：" + Thread.currentThread().getName());
                    }
                });

//        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
//                LogUtil.printLogDebug(TAG, "subscribe" + Thread.currentThread().getName());
//                emitter.onNext("文章1");
//                emitter.onNext("文章2");
//                emitter.onNext("文章3");
//                emitter.onComplete();
//            }
//        })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .map(new Function<String, String>() {
//                    @Override
//                    public String apply(@NonNull String s) throws Exception {
//                        LogUtil.printLogDebug(TAG, "apply" + Thread.currentThread().getName());
//                        return s;
//                    }
//                });
//
//        Observer<String> observer = new Observer<String>() {
//
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//                LogUtil.printLogDebug(TAG, "onSubscribe" + Thread.currentThread().getName());
//            }
//
//            @Override
//            public void onNext(@NonNull String s) {
//                LogUtil.printLogDebug(TAG, "onNext:" + s + "-->" + Thread.currentThread().getName());
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                LogUtil.printLogDebug(TAG, "onError" + Thread.currentThread().getName());
//            }
//
//            @Override
//            public void onComplete() {
//                LogUtil.printLogDebug(TAG, "onComplete" + Thread.currentThread().getName());
//            }
//        };
//
//        observable.subscribe(observer);

    }

}
