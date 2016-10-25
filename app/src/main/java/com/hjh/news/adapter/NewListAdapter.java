package com.hjh.news.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hjh.news.R;
import com.hjh.news.bean.Result;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by HJH on 2016/10/24.
 */

public class NewListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private Context mContext;
    private ArrayList<Result.ResultBean.DataBean> datas;
    private ClickListener mClickListener;


    public NewListAdapter(Context c, ArrayList<Result.ResultBean.DataBean> datas, ClickListener listener){
        this.mContext=c;
        this.datas=datas;
        this.mClickListener=listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder vh=new ViewHolder(View.inflate(mContext, R.layout.item_newlist,null));
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mClickListener.onClick(position);
            }
        });
        Result.ResultBean.DataBean bean=datas.get(position);
        holder.mTvTitle.setText(bean.getTitle());
        holder.mTvType.setText(bean.getType());
        holder.mTvTime.setText(bean.getDate());
        holder.mTvUserName.setText(bean.getAuthor_name());
        ImageLoader.getInstance().displayImage(bean.getThumbnail_pic_s(),holder.mIvImage);

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

}


class ViewHolder extends RecyclerView.ViewHolder{

    TextView mTvTitle,mTvUserName,mTvTime,mTvType;
    RelativeLayout item;
    ImageView mIvUserImage,mIvImage;
    public ViewHolder(View itemView) {
        super(itemView);
        item= (RelativeLayout) itemView.findViewById(R.id.rl_item);
        mTvTitle= (TextView) itemView.findViewById(R.id.tv_title_item);
        mTvTime= (TextView) itemView.findViewById(R.id.tv_time_item);
        mIvImage= (ImageView) itemView.findViewById(R.id.iv_image_item);
        mIvUserImage= (ImageView) itemView.findViewById(R.id.iv_user_image_item);
        mTvType= (TextView) itemView.findViewById(R.id.tv_type_item);
        mTvUserName= (TextView) itemView.findViewById(R.id.tv_user_name_item);
    }


}
