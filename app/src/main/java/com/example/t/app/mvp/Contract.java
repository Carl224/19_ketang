package com.example.t.app.mvp;

import com.example.t.app.mvp.presenter.IPresenter;
import com.example.t.app.mvp.view.IView;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/24 14:31
 * 作 者：T
 * 微信：704003376
 */
public interface Contract {

    interface BaseView extends IView {
        void setPresenter(BasePresenter basePresenter);
    }

    interface BasePresenter extends IPresenter {

    }

}
