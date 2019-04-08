package com.example.t.app.module.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.t.app.R;
import com.example.t.app.adapter.HomeAdapter;
import com.example.t.app.base.BaseFragment;
import com.example.t.app.entity.GankInfo;
import com.example.t.app.global.MyApplication;
import com.example.t.app.mvp.Contract;
import com.example.t.app.view.main.MainActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/24 14:49
 * 作 者：T
 * 微信：704003376
 */
public class HomeFragment extends BaseFragment implements Contract.BaseView {
    @BindView(R.id.vp)
    ViewPager vp;
    Unbinder unbinder;
    private HomePresenter mHomePresenter;
    private boolean isVisibleToUser;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
    }

    @Override
    protected void loadData() {
        if (isVisibleToUser) {
            mHomePresenter = new HomePresenter(this);
            mHomePresenter.start();
        }
    }


    @Override
    protected int getFrgamentLayoutId() {
        return R.layout.fragment_home;
    }


    @Override
    public void setPresenter(Contract.BasePresenter basePresenter) {
        if (mHomePresenter instanceof Contract.BasePresenter) {
            this.mHomePresenter = (HomePresenter) basePresenter;
        }
    }

    @Override
    public void onDataSucess(Object object) {
        if (object instanceof GankInfo) {
            GankInfo info = (GankInfo) object;
            Log.e("111", info.toString() + "+++++++++++++++++++++");
        }
    }

    @Override
    public void onDataFaile(Object o) {
//        Log.e("111", "请求数据失败......" + o.toString());
    }

    @Override
    public void onComplete() {
//        Log.e("111", "请求数据完成......");
    }


    @Override
    protected void initView(View view) {
        vp = view.findViewById(R.id.vp);
        ArrayList<ImageView> list = new ArrayList<>();
        ImageView imageView = new ImageView(MyApplication.mCtontext);
        imageView.setImageResource(R.mipmap.g1);
        list.add(imageView);
        ImageView imageView2 = new ImageView(MyApplication.mCtontext);
        imageView2.setImageResource(R.mipmap.g2);
        list.add(imageView2);
        ImageView imageView3 = new ImageView(MyApplication.mCtontext);
        imageView3.setImageResource(R.mipmap.g3);
        list.add(imageView3);
        ImageView imageView4 = new ImageView(MyApplication.mCtontext);
        imageView4.setImageResource(R.mipmap.g4);
        list.add(imageView4);

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

//        WindowManager win = getActivity().getWindowManager();
//        Display display = win.getDefaultDisplay();
//        int height = display.getHeight();
//        int width = display.getWidth();
//        imageView.setMaxWidth(width);
//        imageView.setMaxHeight(height);
//        imageView2.setMaxWidth(width);
//        imageView2.setMaxHeight(height);
//        imageView3.setMaxWidth(width);
//        imageView3.setMaxHeight(height);
//        imageView4.setMaxWidth(width);
//        imageView4.setMaxHeight(height);

        HomeAdapter homeAdapter = new HomeAdapter(list);
        vp.setAdapter(homeAdapter);
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
}
