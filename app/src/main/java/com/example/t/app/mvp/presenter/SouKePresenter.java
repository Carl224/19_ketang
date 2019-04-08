package com.example.t.app.mvp.presenter;

import android.util.Log;

import com.example.t.app.entity.DiQuBean;
import com.example.t.app.entity.ErJiBean;
import com.example.t.app.entity.YiJiBean;
import com.example.t.app.mvp.Contract;
import com.example.t.app.mvp.model.RxJavaDataImpl;
import com.example.t.app.mvp.view.IView;
import com.example.t.app.view.main.SouKeFragment;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class SouKePresenter implements Contract.BasePresenter {
    SouKeFragment souKeFragment;

    public SouKePresenter(SouKeFragment souKeFragment) {
        this.souKeFragment = souKeFragment;
    }

    @Override
    public void start() {
        final HashMap<String, Object> body = new HashMap<>();
        body.put("key", "qazwsxEDVGFT34fdghgtr4dAS3");
        RxJavaDataImpl.postData("http://seven.haoyunyun.cn/productSelect", body, new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                if (value instanceof ResponseBody) {
                    ResponseBody body1 = (ResponseBody) value;
                    try {
                        String string = body1.string();
                        Gson gson = new Gson();
                        YiJiBean yiJiBean = gson.fromJson(string, YiJiBean.class);
                        souKeFragment.onDataSucess(yiJiBean);
                        souKeFragment.setPresenter(SouKePresenter.this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e("qwe", "souke请求错误");
            }

            @Override
            public void onComplete() {

            }
        });
        HashMap<String, Object> body2 = new HashMap<>();
        body2.put("key", "qazwsxEDVGFT34fdghgtr4dAS3");
        RxJavaDataImpl.postData("http://seven.haoyunyun.cn/addressRead", body2, new Observer() {
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

                        DiQuBean diQuBean = gson.fromJson(string, DiQuBean.class);
                        souKeFragment.onDataSucess(diQuBean);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e("qwe", "地区请求错误" + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void erji(int i) {
        final HashMap<String, Object> body = new HashMap<>();
        body.put("id", i + "");
        body.put("key", "qazwsxEDVGFT34fdghgtr4dAS3");
        RxJavaDataImpl.postData("http://seven.haoyunyun.cn/productRead", body, new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                if (value instanceof ResponseBody) {
                    ResponseBody body1 = (ResponseBody) value;
                    try {
                        String string = body1.string();
                        Gson gson = new Gson();
                        ErJiBean erJiBean = gson.fromJson(string, ErJiBean.class);
                        souKeFragment.onDataSucess(erJiBean);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e("qwe", "二级请求错误" + e.getMessage());
            }

            @Override
            public void onComplete() {

            }
        });
    }


}
