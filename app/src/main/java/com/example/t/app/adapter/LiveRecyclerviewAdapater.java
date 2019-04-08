package com.example.t.app.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.t.app.R;
import com.example.t.app.entity.LiveContent;

import java.util.List;

public class LiveRecyclerviewAdapater extends RecyclerView.Adapter<LiveRecyclerviewAdapater
        .ViewHolder> {
    private Context context;
    private List<LiveContent.RESULTBean.NewsListBean> list;
    LayoutInflater layoutInflater;

    public LiveRecyclerviewAdapater(Context context, List<LiveContent.RESULTBean.NewsListBean>
            list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LiveRecyclerviewAdapater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        View view = layoutInflater.inflate(R.layout.item_live, null);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        LiveContent.RESULTBean.NewsListBean bean = list.get(position);
        if (!bean.getNewsImg().contains("https:"))
            Glide.with(context).load("https:" + bean.getNewsImg()).into(holder.img);
        else {
            Glide.with(context).load(bean.getNewsImg()).into(holder.img);
        }
        holder.title.setText(bean.getTitle());
        holder.time.setText("时间：" + bean.getPublishTime());
        if (bean.getSource() == null) {
            holder.source.setText("无类型");
        } else {
            holder.source.setText("类型：" + bean.getSource());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem.OnClick(list.get(position).getNewsId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        TextView time;
        TextView source;

        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            time = itemView.findViewById(R.id.time);
            source = itemView.findViewById(R.id.source);
        }
    }

    OnClickItem2 onClickItem;

    public void setOnClickItem2(OnClickItem2 onClickItem) {
        this.onClickItem = onClickItem;
    }

    public interface OnClickItem2 {
        void OnClick(String url);
    }

    //在此方面可以为Item添加动画
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object>
            payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }
}
