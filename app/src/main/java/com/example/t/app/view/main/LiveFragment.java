package com.example.t.app.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.t.app.R;
import com.example.t.app.activity.ShortVideoActivity;
import com.example.t.app.activity_live_add.LiveAddActivity;
import com.example.t.app.adapter.LiveFragmentAdapater;
import com.example.t.app.base.BaseFragment;
import com.example.t.app.entity.LiveTitle;
import com.example.t.app.live.fragment.BlankFragment;
import com.example.t.app.mvp.Contract;
import com.example.t.app.mvp.presenter.LivePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;
import butterknife.Unbinder;

public class LiveFragment extends BaseFragment implements Contract.BaseView {


    @BindView(R.id.type_add)
    ImageView typeAdd;
    @BindView(R.id.vp1)
    ViewPager vp1;
    @Nullable
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.luzhi)
    TextView luzhi;

    Unbinder unbinder;
    private int a;


    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        if (getUserVisibleHint()) {
            LivePresenter livePresenter = new LivePresenter(this);
            livePresenter.start();
        }
    }

    @Override
    protected void loadData() {

    }

    @Nullable
    @Override
    protected int getFrgamentLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    public void setPresenter(Contract.BasePresenter basePresenter) {

    }

    @Override
    public void onDataSucess(Object o) {
        if (o instanceof LiveTitle) {
            LiveTitle shouYe = (LiveTitle) o;
            List<String> list = shouYe.getRESULT();
            ArrayList<Fragment> fragments = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                BlankFragment blankFragment = BlankFragment.NewInstance(list.get(i), i);
                fragments.add(blankFragment);
            }
            LiveFragmentAdapater adapater = new LiveFragmentAdapater(getFragmentManager(),
                    (ArrayList<String>) list, fragments);
            //设置ViewPager预加载页面个数
            vp1.setOffscreenPageLimit(3);
            vp1.setAdapter(adapater);
            tab.setupWithViewPager(vp1);
            vp1.setCurrentItem(a);
        }
    }

    @Override
    public void onDataFaile(Object o) {

    }

    @Override
    public void onComplete() {

    }

    public void setType(int a) {
        this.a = a;
        if (vp1 != null) {
            vp1.setCurrentItem(a);
        }
    }

    @Optional
    @OnClick({R.id.type_add, R.id.luzhi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.type_add:
                Intent intent1 = new Intent(getActivity(), LiveAddActivity.class);
                startActivity(intent1);
                break;
            case R.id.luzhi:
                startActivity(new Intent(getContext(), ShortVideoActivity.class));
                break;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

}
