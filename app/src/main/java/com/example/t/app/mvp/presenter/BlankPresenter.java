package com.example.t.app.mvp.presenter;

import android.util.Log;

import com.example.t.app.entity.Detail;
import com.example.t.app.entity.LiveContent;
import com.example.t.app.live.fragment.BlankFragment;
import com.example.t.app.live.fragment.DetailActivity;
import com.example.t.app.mvp.Contract;
import com.example.t.app.mvp.model.RxJavaDataImpl;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class BlankPresenter implements Contract.BasePresenter {
    BlankFragment blankFragment;
    DetailActivity detailActivity;

    public BlankPresenter(Contract.BaseView baseView) {
        if (baseView instanceof BlankFragment) {
            blankFragment = (BlankFragment) baseView;
        }
        if (baseView instanceof DetailActivity) {
            detailActivity = (DetailActivity) baseView;
        }
    }

    @Override
    public void start() {

    }

    public void Http2(String s) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("appKey", "7568716838834cb4b5dd1969c4488622");
        map.put("newsId", s);
        RxJavaDataImpl.getData("http://api.shujuzhihui.cn/api/news/detail", map, new Observer() {
            public Disposable d;

            @Override
            public void onSubscribe(Disposable d) {
                this.d = d;
            }

            @Override
            public void onNext(Object value) {
                if (value instanceof ResponseBody) {
                    ResponseBody body = (ResponseBody) value;
                    try {
                        String string = body.string();
                        Gson gson = new Gson();
                        Detail detail = gson.fromJson(string, Detail.class);
                        detailActivity.onDataSucess(detail);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e("qwe", "Live详情页面网络请求报错了" + e.getMessage());
            }

            @Override
            public void onComplete() {
                if (null != d && d.isDisposed()) {
                    d.dispose();
                }
            }
        });
    }

    public void Http(String s) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("appKey", "7568716838834cb4b5dd1969c4488622");
        map.put("category", s);
        RxJavaDataImpl.getData("http://api.shujuzhihui.cn/api/news/list", map, new Observer() {
            public Disposable d;

            @Override
            public void onSubscribe(Disposable d) {
                this.d = d;
            }

            @Override
            public void onNext(Object value) {
                if (value instanceof ResponseBody) {
                    ResponseBody body = (ResponseBody) value;
                    try {
                        String string = body.string();
                        Gson gson = new Gson();
                        LiveContent liveContent = gson.fromJson(string, LiveContent.class);
                        blankFragment.onDataSucess(liveContent);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e("qwe", "Live列表页面网络请求报错了" + e.getMessage());
            }

            @Override
            public void onComplete() {
                if (null != d && d.isDisposed()) {
                    d.dispose();
                }
            }
        });
    }
}
