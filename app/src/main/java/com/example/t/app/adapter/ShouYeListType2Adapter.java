package com.example.t.app.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.t.app.R;
import com.example.t.app.entity.ShouYeListBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShouYeListType2Adapter extends RecyclerView.Adapter<ShouYeListType2Adapter.ViewHolder> {


    private List<ShouYeListBean.ListBean> list;
    Context context;

    public ShouYeListType2Adapter(List<ShouYeListBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shouye_list_item2, null);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShouYeListBean.ListBean bean = list.get(position);

        Glide.with(context).load(bean.getImg()).into(holder.img);
        holder.name.setText(bean.getClassname());
        holder.keshi.setText(bean.getCid() + "课时");
        if (!TextUtils.isEmpty(bean.getNew_price().trim()) && bean.getNew_price().trim().equals("0.00")) {
            holder.price.setText("免费");
            holder.price.setTextColor(ContextCompat.getColor(context, R.color.green));
        } else {
            holder.price.setText("￥" + bean.getNew_price());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.keshi)
        TextView keshi;
        @BindView(R.id.price)
        TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
