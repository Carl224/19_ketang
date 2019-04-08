package com.example.t.app.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;


public class ZhuCeActivity extends BaseActivity {
    @BindView(R.id.zhuce_guanbi)
    ImageView zhuceGuanbi;
    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.get_code)
    Button getCode;
    @BindView(R.id.liuweishu)
    EditText liuweishu;
    @BindView(R.id.but_denglu)
    Button butDenglu;
    @BindView(R.id.finish)
    TextView finish;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x001) {
                getCode.setText(--a + "秒");
                if (a == 0) {
                    timer.cancel();
                    a = 60;
                    flag = true;
                    getCode.setEnabled(true);
                    getCode.setText("获取验证码");
                }
            }
        }
    };
    private int a = 60;
    private boolean flag = true;
    private Timer timer = new Timer();

    @Override
    protected void initView() {
        getCode.setClickable(false);
        butDenglu.setClickable(false);
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
                    getCode.setEnabled(true);
                    getCode.setClickable(true);
                } else {
                    getCode.setEnabled(false);
                    getCode.setClickable(false);
                }
            }
        });
        liuweishu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() >= 6) {
                    butDenglu.setEnabled(true);
                    butDenglu.setClickable(true);
                } else {
                    butDenglu.setEnabled(false);
                    butDenglu.setClickable(false);
                }
            }
        });
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_zhuce;
    }

    @Override
    protected void loadData() {

    }


    @Optional
    @OnClick({R.id.zhuce_guanbi, R.id.get_code, R.id.but_denglu, R.id.finish})
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.zhuce_guanbi:
                finish();
                break;
            case R.id.get_code:
                if (flag) {
                    getCode.setEnabled(false);
                    flag = false;
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Message message = handler.obtainMessage();
                            message.what = 0x001;
                            handler.sendMessage(message);
                        }
                    }, 0, 1000);
                }
                break;
            case R.id.but_denglu:
                Toast.makeText(this, "测试中", Toast.LENGTH_SHORT).show();
                break;
            case R.id.finish:
                finish();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
        timer = null;
    }
}
