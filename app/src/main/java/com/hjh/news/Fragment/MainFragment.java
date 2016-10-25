package com.hjh.news.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hjh.news.Pesenter;
import com.hjh.news.R;
import com.hjh.news.adapter.ClickListener;
import com.hjh.news.adapter.NewListAdapter;
import com.hjh.news.bean.Result;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements NewsIpm {

    private ArrayList<Result.ResultBean.DataBean> mArrayList=new ArrayList();
    private View v;
    private RecyclerView mRecyclerView;
    private NewListAdapter adapter;
    private Pesenter mPesenter;
    private ProgressBar mProgressBar;
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_main, container, false);
        mPesenter=new Pesenter(this);
        initView();
        mPesenter.setData();
        return v;
    }

    private void initView() {
        mRecyclerView= (RecyclerView) v.findViewById(R.id.rv_main);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mProgressBar= (ProgressBar) v.findViewById(R.id.pb_main);
    }


    @Override
    public void setNews(ArrayList<Result.ResultBean.DataBean> dataBeen) {
        adapter=new NewListAdapter(getContext(), dataBeen, new ClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(getContext(),""+pos,Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.INVISIBLE);
    }

}
