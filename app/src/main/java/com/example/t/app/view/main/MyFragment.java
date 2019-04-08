package com.example.t.app.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.t.app.R;
import com.example.t.app.activity.RegisterActivity;
import com.example.t.app.activity_set.SystemSetActivity;
import com.example.t.app.base.BaseFragment;
import com.example.t.app.mvp.Contract;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import butterknife.Unbinder;

public class MyFragment extends BaseFragment implements Contract.BaseView {
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.line)
    RelativeLayout line;
    @BindView(R.id.line2)
    RelativeLayout line2;
    @BindView(R.id.line3)
    RelativeLayout line3;
    @BindView(R.id.line4)
    RelativeLayout line4;
    @BindView(R.id.line5)
    RelativeLayout line5;
    @BindView(R.id.line6)
    RelativeLayout line6;
    Unbinder unbinder;

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void loadData() {

    }

    @Nullable
    @Override
    protected int getFrgamentLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    public void setPresenter(Contract.BasePresenter basePresenter) {

    }

    @Override
    public void onDataSucess(Object o) {

    }

    @Override
    public void onDataFaile(Object o) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Optional
    @OnClick({R.id.tv1, R.id.tv2, R.id.line, R.id.line2, R.id.line3, R.id.line4, R.id.line5, R.id.line6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv1:
                Intent intent = new Intent(getActivity(), RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.line:
                Toast.makeText(getActivity(), "课程  ", Toast.LENGTH_SHORT).show();

                break;
            case R.id.line2:
                Toast.makeText(getActivity(), "收藏", Toast.LENGTH_SHORT).show();

                break;
            case R.id.line3:
                Toast.makeText(getActivity(), "预约", Toast.LENGTH_SHORT).show();

                break;
            case R.id.line4:
                Toast.makeText(getActivity(), "订单", Toast.LENGTH_SHORT).show();

                break;
            case R.id.line5:
                Toast.makeText(getActivity(), "帮助", Toast.LENGTH_SHORT).show();

                break;
            case R.id.line6:
                Intent intent1 = new Intent(getActivity(), SystemSetActivity.class);
                startActivity(intent1);
                break;
        }
    }


}
