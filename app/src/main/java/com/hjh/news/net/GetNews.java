package com.hjh.news.net;

import com.hjh.news.bean.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by HJH on 2016/10/24.
 */

public interface GetNews {
    @GET("toutiao/index")
    Call<Result> getNews(@Query("type") String type,@Query("key") String key);

    @GET("toutiao/index")
    Observable<Result> rxGetNews(@Query("type") String type, @Query("key") String key);

}
