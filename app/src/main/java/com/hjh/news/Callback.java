package com.hjh.news;

import com.hjh.news.bean.Result;

import java.util.ArrayList;

public interface Callback{
    void onSuccess();
    void onError();
    void onComplete(ArrayList<Result.ResultBean.DataBean> datas);
}
