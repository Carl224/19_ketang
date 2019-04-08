package com.example.t.app.activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.t.app.R;
import com.example.t.app.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YanZhengMaActivity extends BaseActivity {
    @BindView(R.id.huitui)
    ImageView huitui;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.code)
    EditText code;
    @BindView(R.id.get_code_but)
    TextView getCodeBut;
    @BindView(R.id.but_kuaisudenglu)
    Button butkuaisudenglu;
    private boolean flag = false;
    private boolean flag2 = false;

    @Override
    protected void initView() {
        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() == 11) {
                    flag = true;
                    if (flag && flag2) {
                        butkuaisudenglu.setEnabled(true);
                    }
                }
            }
        });
        code.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() == 6) {
                    flag2 = true;
                    if (flag && flag2) {
                        butkuaisudenglu.setEnabled(true);
                    }
                }
            }
        });

    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_yanzhengma;
    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.huitui, R.id.get_code_but, R.id.but_kuaisudenglu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.huitui:
                finish();
                break;
            case R.id.get_code_but:
                Toast.makeText(this, "获取验证码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.but_kuaisudenglu:
                Toast.makeText(this, "快速登录", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
