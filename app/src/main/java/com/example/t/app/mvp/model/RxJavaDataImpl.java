package com.example.t.app.mvp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.Multipart;
import retrofit2.http.Part;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/25 09:37
 * 作 者：T
 * 微信：704003376
 */
public class RxJavaDataImpl<T> {


    public static <T> void getData(String url, Observer observer) {
        RetrofitManager.getManagerInstance().getApiService().
                getData(url).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(observer);
    }

    public static <T> void getData(String url, HashMap<String, Object> params, Observer observer) {
        if (params != null) {
            RetrofitManager.getManagerInstance().getApiService().
                    getData(url, params).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribeOn(Schedulers.io()).
                    subscribe(observer);
        } else {
            getData(url, observer);
        }
    }

    public static void postData(String url, Map<String, Object> map, Observer observer) {
        if (map != null) {
            RetrofitManager.getManagerInstance().getApiService().
                    postData(url, map).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(observer);
        } else {
            RetrofitManager.getManagerInstance().getApiService().
                    postData(url).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(observer);
        }
    }

    public static void postData(String url, Map<String, Object> headerMap, Map<String, Object> params, Observer observer) {
        if (params != null) {
            RetrofitManager.getManagerInstance().getApiService().
                    postData(headerMap, url, params).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(observer);
        } else {
            RetrofitManager.getManagerInstance().getApiService().
                    postData(headerMap, url).
                    subscribeOn(Schedulers.io()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(observer);
        }
    }


    public static <T> void downloadFile(String url, Observer observer) {
        RetrofitManager.getManagerInstance().getApiService().
                downloadFile(url).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(observer);
    }


    public static <T> void uploadFile(String url, Part part, Observer observer) {
        RetrofitManager.getManagerInstance().
                getApiService().uploadFile(url, part).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(observer);
    }

    public static <T> void uploadFile(String url, List<Multipart> uploadFiles, Observer observer) {
        RetrofitManager.getManagerInstance().
                getApiService().uploadFiles(url, uploadFiles).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(observer);
    }


}
