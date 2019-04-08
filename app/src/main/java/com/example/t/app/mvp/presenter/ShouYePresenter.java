package com.example.t.app.mvp.presenter;

import android.util.Log;

import com.example.t.app.entity.BannerBean;
import com.example.t.app.entity.ReDian;
import com.example.t.app.entity.ShouYeListBean;
import com.example.t.app.mvp.Contract;
import com.example.t.app.mvp.model.RxJavaDataImpl;
import com.example.t.app.view.main.ShouYeFragment;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class ShouYePresenter implements Contract.BasePresenter {
    //绑定fragment
    ShouYeFragment shouYeFragment;

    public ShouYePresenter(ShouYeFragment shouYeFragment) {
        this.shouYeFragment = shouYeFragment;
        shouYeFragment.setPresenter(this);
    }

    @Override
    public void start() {
        RxJavaDataImpl.getData("http://seven.haoyunyun.cn/pictureShow", new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                if (value instanceof ResponseBody) {
                    try {
                        ResponseBody body = (ResponseBody) value;
                        String s = body.string();
                        Gson gson = new Gson();
                        BannerBean bean = gson.fromJson(s, BannerBean.class);
                        List<BannerBean.ListBean> list = bean.getList();
                        shouYeFragment.onDataSucess(list);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e("qwe首页轮播图", "网络请求错了" + e.getMessage());
            }

            @Override
            public void onComplete() {
            }
        });

        RxJavaDataImpl.getData("http://seven.haoyunyun.cn/articleRead", new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                if (value instanceof ResponseBody) {
                    ResponseBody body = (ResponseBody) value;
                    try {
                        String string = body.string();
                        Gson gson = new Gson();
                        ReDian reDian = gson.fromJson(string, ReDian.class);
                        shouYeFragment.onDataSucess(reDian);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e("qwe首页请求错误", e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void http(final int id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("key", "qazwsxEDVGFT34fdghgtr4dAS3");
        map.put("id", id + "");
        Log.e("qwe", id + "");
        RxJavaDataImpl.postData("http://seven.haoyunyun.cn/proRead", map, new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                if (value instanceof ResponseBody) {
                    ResponseBody responseBody = (ResponseBody) value;
                    try {
                        String string = responseBody.string();
                        Gson gson = new Gson();
                        ShouYeListBean shouYeListBean = gson.fromJson(string, ShouYeListBean.class);
                        shouYeListBean.setId(id);
                        shouYeFragment.onDataSucess(shouYeListBean);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e("qwe", "首页列表请求失败" + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }
}
