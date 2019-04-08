package com.example.t.app.module.home;

import com.example.t.app.entity.GankInfo;
import com.example.t.app.mvp.Contract;
import com.example.t.app.mvp.model.RxJavaDataImpl;
import com.google.gson.Gson;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/24 14:53
 * 作 者：T
 * 微信：704003376
 */
public class HomePresenter implements Contract.BasePresenter {
    // 桥梁（链接V层和M层）    //处理业务逻辑
    private HomeFragment mHomeFragment;

    public HomePresenter(HomeFragment homeFragment) {
        this.mHomeFragment = homeFragment;
        mHomeFragment.setPresenter(this);
    }


    @Override
    public void start() {
        //从Modele层获取数据 将数据交给V层更新Ui
        RxJavaDataImpl.getData("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/20/1", new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                if (value instanceof ResponseBody) {
                    try {
                        ResponseBody responseBody = (ResponseBody) value;
                        String str = responseBody.string();
                        Gson gson = new Gson();
                        GankInfo gankInfo = gson.fromJson(str, GankInfo.class);
                        mHomeFragment.onDataSucess(gankInfo);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onError(Throwable e) {
                mHomeFragment.onDataFaile(e.getMessage());
            }

            @Override
            public void onComplete() {
                mHomeFragment.onComplete();

            }
        });


    }
}
