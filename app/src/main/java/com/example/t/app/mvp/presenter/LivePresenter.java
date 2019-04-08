package com.example.t.app.mvp.presenter;

import android.util.Log;

import com.example.t.app.entity.LiveTitle;
import com.example.t.app.mvp.Contract;
import com.example.t.app.mvp.model.RxJavaDataImpl;
import com.example.t.app.view.main.LiveFragment;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

public class LivePresenter implements Contract.BasePresenter {
    private LiveFragment liveFragment;

    public LivePresenter(LiveFragment liveFragment) {
        this.liveFragment = liveFragment;
    }

    @Override
    public void start() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("appKey", "7568716838834cb4b5dd1969c4488622");
        RxJavaDataImpl.getData("http://api.shujuzhihui.cn/api/news/categories?", map, new Observer() {
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
                        LiveTitle liveShouYe = gson.fromJson(string, LiveTitle.class);
                        liveFragment.onDataSucess(liveShouYe);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.e("qwe", "LiveFragment页面网络请求错了" + e.getMessage());
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
