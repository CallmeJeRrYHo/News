package com.hjh.news.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.hjh.news.Fragment.MainFragment;
import com.hjh.news.R;

public class MainActivity extends BaseAct {

    private Toolbar tb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb= (Toolbar) findViewById(R.id.tb_main);
        setToolbar();
    }

    private void setToolbar() {
        tb.setTitle(R.string.tb_main);
        tb.inflateMenu(R.menu.main);
        tb.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_search:
                        Toast.makeText(getApplication(),"shou",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }

    @Override
    public Fragment getFragment() {
        return new MainFragment();
    }
}
