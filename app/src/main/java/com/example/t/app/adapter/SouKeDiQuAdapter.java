package com.example.t.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.t.app.R;
import com.example.t.app.entity.DiQuBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SouKeDiQuAdapter extends BaseAdapter {
    List<DiQuBean.ListBean> list;
    Context context;

    public SouKeDiQuAdapter(List<DiQuBean.ListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.souke_item, null);
            ViewHolder holder = ViewHolder.getViewHolderInstance(convertView);
            holder.tv.setText(list.get(position).getAddress());
        }
        return convertView;
    }

    private static class ViewHolder {

        TextView tv;

        public ViewHolder(View convertView) {
            tv = convertView.findViewById(R.id.tv);
        }

        public static ViewHolder getViewHolderInstance(View convertView) {
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            if (viewHolder == null) {
                viewHolder = new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            }
            return viewHolder;
        }
    }
}
