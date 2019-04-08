package com.example.t.app.view.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.t.app.R;
import com.example.t.app.base.BaseFragment;
import com.example.t.app.mvp.Contract;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import butterknife.Unbinder;

public class CacheFragment extends BaseFragment implements Contract.BaseView {
    @BindView(R.id.img_cache)
    ImageView imgCache;
    @BindView(R.id.bianji)
    TextView bianji;
    Unbinder unbinder;
    private boolean flag;

    @Override
    protected void initView(View view) {
        imgCache = view.findViewById(R.id.img_cache);
    }

    @Override
    protected void loadData() {

    }

    @Nullable
    @Override
    protected int getFrgamentLayoutId() {
        return R.layout.fragment_cache;
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
    @OnClick(R.id.bianji)
    public void onViewClicked() {

    }
}
