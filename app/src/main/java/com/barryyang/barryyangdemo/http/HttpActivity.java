package com.barryyang.barryyangdemo.http;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.barryyang.barryyangdemo.R;
import com.barryyang.barryyangdemo.utils.LogUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
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
        httpRequest_Post();
    }

    private void httpRequest_Post() {
        try {
            URL url = new URL(BASE_URL);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("Post");
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            urlConnection.connect();

            String body = "userName=zhangsan&password=123456";
            OutputStream outputStream = urlConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write(body);
            outputStream.close();

            int responseCode = urlConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = urlConnection.getInputStream();
                StringBuilder sb = new StringBuilder();
                String line;
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }
                String result = sb.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
