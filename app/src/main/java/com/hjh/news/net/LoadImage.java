package com.hjh.news.net;

/**
 * Created by HJH on 2016/10/25.
 */

public class LoadImage {
    private volatile static LoadImage mInstance;
    public LoadImage getmInstance(){

        if (mInstance==null){
            synchronized (LoadImage.class){
                if (mInstance==null){
                    mInstance=new LoadImage();
                }
            }
        }
        return mInstance;
    }

    private LoadImage(){

    }
}
