package com.barryyang.barryyangdemo.http;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * @author : BarryYang
 * @date : 2020/7/30 4:12 PM
 * @desc :
 */
public interface MovieService {

    @GET("top250")
    Call<MovieSubject> getTop250(@Query("start") int start, @Query("count") int count);

    @FormUrlEncoded
    @POST("top250")
    Call<MovieSubject> postTop250(@Field("start") int start, @Field("count") int count);

    @GET("top250")
    Observable<MovieSubject> getRxJavaTop250(@Query("start") int start, @Query("count") int count);
}
