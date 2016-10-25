package com.hjh.news.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.hjh.news.R;

/**
 * Created by HJH on 2016/10/24.
 */

public abstract class BaseAct extends AppCompatActivity {

    private android.support.v4.app.Fragment mFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragment=getFragment();
        if (mFragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_main,mFragment).commit();
        }
    }


    public abstract Fragment getFragment();
}
