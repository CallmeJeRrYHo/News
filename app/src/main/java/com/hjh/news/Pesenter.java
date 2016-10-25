package com.hjh.news;

import com.hjh.news.Fragment.NewsIpm;
import com.hjh.news.bean.Result;
import com.hjh.news.bean.ResultModle;

import java.util.ArrayList;

/**
 * Created by HJH on 2016/10/25.
 */

public class Pesenter {
    private NewsIpm mNewsIpm;
    private ResultModle mResultModle;
    public Pesenter(NewsIpm ipm){
        this.mNewsIpm=ipm;
        this.mResultModle=new Result();
    }

    public void setData(){
        mNewsIpm.showProgressBar();
        mResultModle.getNews(new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {

            }

            @Override
            public void onComplete(ArrayList<Result.ResultBean.DataBean> datas) {
                mNewsIpm.setNews(datas);
                mNewsIpm.hideProgressBar();
            }
        });
    }
}
