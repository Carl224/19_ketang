package com.example.t.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
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

public class ShouYeListType1Adapter extends RecyclerView.Adapter<ShouYeListType1Adapter
        .ViewHolder> {

    private List<ShouYeListBean.ListBean> list;
    Context context;

    public ShouYeListType1Adapter(List<ShouYeListBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shouye_llist_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ShouYeListBean.ListBean bean = list.get(position);

        Glide.with(context).load(bean.getImg()).into(holder.itemImg);
        holder.itemName.setText(bean.getClassname());
        holder.itemKeshi.setText(bean.getCid() + "课时");
        if (TextUtils.isEmpty(bean.getNew_price().trim()) && bean.getNew_price().trim().equals
                ("0.00")) {
            holder.itemPrice.setText("免费");
        } else {
            holder.itemPrice.setText("￥" + bean.getNew_price());
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButClick.butClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_img)
        ImageView itemImg;
        @BindView(R.id.item_name)
        TextView itemName;
        @BindView(R.id.item_keshi)
        TextView itemKeshi;
        @BindView(R.id.item_price)
        TextView itemPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnButClick {
        void butClick();
    }

    OnButClick onButClick;

    public void setOnButClick(OnButClick onButClick) {
        this.onButClick = onButClick;
    }
}
