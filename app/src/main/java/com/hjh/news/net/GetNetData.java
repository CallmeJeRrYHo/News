package com.hjh.news.net;

import com.hjh.news.Content;
import com.hjh.news.bean.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HJH on 2016/10/24.
 */

public  class GetNetData {
    private volatile static GetNetData mGetNetData;
    private final Retrofit retrofit;

    public static GetNetData getInstance(){
        if (mGetNetData==null) {
            synchronized (GetNetData.class) {
                if (mGetNetData == null) {
                    mGetNetData = new GetNetData();
                }
                return mGetNetData;
            }
        }
        return mGetNetData;
    }

    private GetNetData(){
        retrofit=new Retrofit.Builder()
                .baseUrl("http://v.juhe.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
    public void getAll(String type, final ResponseListener listener){
        GetNews getNews=retrofit.create(GetNews.class);
        Call<Result> call=getNews.getNews(type, Content.APP_KEY);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                listener.onFail();
            }
        });
    }

    public rx.Observable<Result> RxGetAll(String type){
        GetNews getNews=retrofit.create(GetNews.class);
        return getNews.rxGetNews(type, Content.APP_KEY);

    }



    public interface ResponseListener{
        void onSuccess(Result result);
        void onFail();
    }
}
