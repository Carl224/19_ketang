package com.example.t.app.live.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.t.app.R;
import com.example.t.app.adapter.LiveRecyclerviewAdapater;
import com.example.t.app.base.BaseFragment;
import com.example.t.app.entity.LiveContent;
import com.example.t.app.mvp.Contract;
import com.example.t.app.mvp.presenter.BlankPresenter;

import java.util.List;


public class BlankFragment extends BaseFragment implements Contract.BaseView {


    RecyclerView liveLv;
    //Fragment的View加载完毕的标记
    private boolean isViewCreated;

    //Fragment对用户可见的标记
    private boolean isUIVisible;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        loadData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isUIVisible = true;
            loadData();
        }
    }

    @Override
    protected void initView(View view) {
        liveLv = view.findViewById(R.id.live_lv);
    }

    @Override
    protected void loadData() {
        if (isUIVisible == true && isViewCreated == true) {
            Bundle bundle = getArguments();
            if (bundle != null) {
                String id = bundle.getString("id");
                BlankPresenter blankPresenter = new BlankPresenter(this);
                blankPresenter.Http(id);
                Log.e("qwe", "可见了");
            }
        }
    }

    @Override
    protected int getFrgamentLayoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    public void setPresenter(Contract.BasePresenter basePresenter) {

    }

    @Override
    public void onDataSucess(Object o) {
        if (o instanceof LiveContent) {
            LiveContent liveContent = (LiveContent) o;
            List<LiveContent.RESULTBean.NewsListBean> list = liveContent.getRESULT().getNewsList();
            LiveRecyclerviewAdapater adapater = new LiveRecyclerviewAdapater(getActivity(), list);
            adapater.setOnClickItem2(new LiveRecyclerviewAdapater.OnClickItem2() {
                @Override
                public void OnClick(String url) {
                    Intent intent = new Intent(getActivity(), DetailActivity.class);
                    intent.putExtra("url", url);
                    startActivity(intent);
                }
            });
            //添加Android自带的分割线
            FragmentActivity activity = getActivity();
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(activity,
                    DividerItemDecoration.VERTICAL);
            liveLv.addItemDecoration(dividerItemDecoration);
            StaggeredGridLayoutManager stagg = new StaggeredGridLayoutManager(1,
                    StaggeredGridLayoutManager.VERTICAL);
            liveLv.setLayoutManager(stagg);
            liveLv.setAdapter(adapater);
            //设置条目动画
//            liveLv.setItemAnimator(new DefaultItemAnimator());//默认动画
            int resId = R.anim.layout_animation_fall_down;
            LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getActivity
                    (), resId);
            liveLv.setLayoutAnimation(animation);
        }
    }

    @Override
    public void onDataFaile(Object o) {

    }

    @Override
    public void onComplete() {

    }


    public static BlankFragment NewInstance(String id, int tag) {
        BlankFragment blankFragment = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        bundle.putInt("tag", tag);
        blankFragment.setArguments(bundle);
        return blankFragment;
    }
}
