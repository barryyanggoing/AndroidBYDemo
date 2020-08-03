package com.barryyang.barryyangdemo.http;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.LogUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author : BarryYang
 * @date : 2020/7/30 2:53 PM
 * @desc :okhttp+retrofit+com.barryyang.barryyangdemo.rxjava
 */
public class HttpActivity extends AppCompatActivity {

    private static final String TAG = "HttpActivity";

    private static final String BASE_URL = "https://api.douban.com/v2/movie/";

    private Retrofit mRetrofit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        initRetrofit();
    }

    private void initRetrofit() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
//                .addInterceptor()
//        .connectionPool()
                .connectTimeout(1000, TimeUnit.MILLISECONDS)
                .writeTimeout(1000, TimeUnit.MILLISECONDS)
                .readTimeout(1000, TimeUnit.MILLISECONDS);
        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public void postRequest(View view) {
        MovieService movieService = mRetrofit.create(MovieService.class);
        Call<MovieSubject> call = movieService.postTop250(0, 20);
        //异步请求
        call.enqueue(new Callback<MovieSubject>() {
            @Override
            public void onResponse(Call<MovieSubject> call, Response<MovieSubject> response) {
                if (response.body() != null) {
                    LogUtil.printLogDebug(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<MovieSubject> call, Throwable t) {
                LogUtil.printLogDebug(TAG, t.getMessage());
            }
        });
    }

    public void getRequest(View view) {
        MovieService movieService = mRetrofit.create(MovieService.class);
        Call<MovieSubject> call = movieService.getTop250(0, 20);
        //异步请求
        call.enqueue(new Callback<MovieSubject>() {
            @Override
            public void onResponse(Call<MovieSubject> call, Response<MovieSubject> response) {
                if (response.body() != null) {
                    LogUtil.printLogDebug(TAG, response.body().toString());
                }
            }

            @Override
            public void onFailure(Call<MovieSubject> call, Throwable t) {
                LogUtil.printLogDebug(TAG, t.getMessage());
            }
        });
    }

    public void getRxJavaRequest(View view) {
        MovieService movieService = mRetrofit.create(MovieService.class);
        Disposable disposable = movieService.getRxJavaTop250(0, 20)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MovieSubject>() {
                    @Override
                    public void accept(MovieSubject movieSubject) throws Exception {
                        LogUtil.printLogDebug(TAG, "movieSubject");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        LogUtil.printLogDebug(TAG, "throwable");
                    }
                });
    }
}
