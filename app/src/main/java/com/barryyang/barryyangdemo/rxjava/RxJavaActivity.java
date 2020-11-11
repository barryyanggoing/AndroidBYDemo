package com.barryyang.barryyangdemo.rxjava;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.LogUtil;

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
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext("文章1");
                emitter.onNext("文章2");
                emitter.onNext("文章3");
                emitter.onComplete();
            }
        });

        Observer<String> observer = new Observer<String>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                LogUtil.printLogDebug(TAG, "onSubscribe");
            }

            @Override
            public void onNext(@NonNull String s) {
                LogUtil.printLogDebug(TAG, "onNext:" + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                LogUtil.printLogDebug(TAG, "onError");
            }

            @Override
            public void onComplete() {
                LogUtil.printLogDebug(TAG, "onComplete");
            }
        };
        observable.subscribe(observer);
    }

}
