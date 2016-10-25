package com.hjh.news;

import android.app.Application;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

/**
 * Created by HJH on 2016/10/25.
 */

public class MyApp extends Application {
    private ImageLoaderConfiguration  mImageLoaderConfiguration;
    @Override
    public void onCreate() {
        super.onCreate();
        DisplayImageOptions displayImageOptions=new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.ic_search_api_holo_light)
                .cacheOnDisk(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .build();
        File cacheDir= StorageUtils.getCacheDirectory(this);
        mImageLoaderConfiguration=new ImageLoaderConfiguration
                .Builder(this)
                .memoryCacheExtraOptions(400,480)
                .threadPoolSize(3)
                .diskCache(new UnlimitedDiskCache(cacheDir))
                .diskCacheSize(10*1024*1024).diskCacheFileCount(20)
                .defaultDisplayImageOptions(displayImageOptions)
                .build()
        ;
        ImageLoader.getInstance().init(mImageLoaderConfiguration);
    }
}
