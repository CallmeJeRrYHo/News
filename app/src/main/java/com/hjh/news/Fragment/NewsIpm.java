package com.hjh.news.Fragment;

import com.hjh.news.bean.Result;

import java.util.ArrayList;

/**
 * Created by HJH on 2016/10/25.
 */

public interface NewsIpm {
    void setNews(ArrayList<Result.ResultBean.DataBean> dataBeen);
    void showProgressBar();
    void hideProgressBar();
}
