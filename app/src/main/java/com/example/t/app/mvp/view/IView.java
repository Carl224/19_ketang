package com.example.t.app.mvp.view;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/24 14:28
 * 作 者：T
 * 微信：704003376
 */
public interface IView<T> {
    void onDataSucess(T t);

    void onDataFaile(T t);

    void onComplete();
}
