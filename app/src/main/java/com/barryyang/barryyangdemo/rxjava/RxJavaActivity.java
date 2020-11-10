package com.barryyang.barryyangdemo.rxjava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.LogUtil;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

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

    @SuppressLint("CheckResult")
    public void threadTest(View view) {
        Observable<Integer> observable = getObservable();
        observable
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        LogUtil.printLogDebug(TAG, "accept:" + Thread.currentThread().getName());
                    }
                })
                .map(new Function<Integer, Boolean>() {
                    @Override
                    public Boolean apply(@NonNull Integer integer) throws Exception {
                        LogUtil.printLogDebug(TAG, "apply:" + Thread.currentThread().getName());
                        return integer > 3;
                    }
                })
                .subscribeWith(new DisposableObserver<Object>() {

                    @Override
                    public void onNext(@NonNull Object o) {
                        LogUtil.printLogDebug(TAG, "onNext:" + Thread.currentThread().getName());
                    }


                    @Override
                    public void onError(@NonNull Throwable e) {
                        LogUtil.printLogDebug(TAG, "onError:" + Thread.currentThread().getName());
                    }

                    @Override
                    public void onComplete() {
                        LogUtil.printLogDebug(TAG, "onComplete:" + Thread.currentThread().getName());
                    }
                });
    }

    /**
     * 模仿okhttpUtils:okhttp在子线程执行，onresponse后在主线程
     *
     * @return
     */
    private Observable<Integer> getObservable() {
        return Observable.just(4).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
