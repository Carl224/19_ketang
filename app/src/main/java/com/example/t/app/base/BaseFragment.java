package com.example.t.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/24 13:56
 * 作 者：T
 * 微信：704003376
 */
public abstract class BaseFragment extends Fragment {
    private Unbinder mUnBinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getFrgamentLayoutId(), container, false);
//        mUnBinder = ButterKnife.bind(getActivity(), view);
        initView(view);
        loadData();
        return view;
    }


    protected abstract void initView(View view);

    @Override
    public void onStart() {
        loadData();
        super.onStart();
    }

    protected abstract void loadData();

    protected abstract int getFrgamentLayoutId();

    @Override
    public void onDestroy() {
        if (mUnBinder != null)
            mUnBinder.unbind();
        super.onDestroy();
    }
}
