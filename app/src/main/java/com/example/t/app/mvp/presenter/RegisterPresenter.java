package com.example.t.app.mvp.presenter;

import com.example.t.app.activity.RegisterActivity;
import com.example.t.app.mvp.Contract;

public class RegisterPresenter implements Contract.BasePresenter {
    private RegisterActivity registerActivity;

    public RegisterPresenter(RegisterActivity registerActivity) {
        this.registerActivity = registerActivity;
    }

    @Override
    public void start() {

    }

    public void register(String phone, String paw) {

    }
}
