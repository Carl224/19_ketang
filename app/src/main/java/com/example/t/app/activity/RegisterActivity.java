package com.example.t.app.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.t.app.R;
import com.example.t.app.base.BaseActivity;
import com.example.t.app.base.MySwipeBackActivity;
import com.example.t.app.mvp.Contract;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Optional;

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.guanbi)
    ImageView guanbi;
    @BindView(R.id.zhuce)
    TextView zhuce;

    @BindView(R.id.phone)
    EditText phone;
    @BindView(R.id.clean)
    ImageView clean;
    @BindView(R.id.eye)
    CheckBox eye;
    @BindView(R.id.paw)
    EditText paw;
    @BindView(R.id.jizhu)
    CheckBox jizhu;
    @BindView(R.id.wangji)
    TextView wangji;
    @BindView(R.id.but_denglu)
    Button butDenglu;
    @BindView(R.id.yanzhengma)
    TextView yanzhengma;
    @BindView(R.id.yijian)
    TextView yijian;
    @BindView(R.id.sanfang_qq)
    ImageView sanfangQq;
    @BindView(R.id.sanfang_weixin)
    ImageView sanfangWeixin;
    @BindView(R.id.sanfang_weibo)
    ImageView sanfangWeibo;


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
                if (s.toString().length() != 0) {
                    clean.setVisibility(View.VISIBLE);
                } else {
                    clean.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void loadData() {

    }

    @Optional
    @OnClick({R.id.clean, R.id.guanbi, R.id.zhuce, R.id.wangji, R.id.but_denglu, R.id.yanzhengma,
            R.id.yijian, R.id.sanfang_qq,
            R.id.sanfang_weixin, R.id.sanfang_weibo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.clean:
                phone.setText("");
                break;
            case R.id.guanbi:
                //返回上个页面
                finish();
                break;
            case R.id.zhuce:
                //跳转注册页面
                Intent intent = new Intent(this, ZhuCeActivity.class);
                startActivity(intent);
                break;
            case R.id.wangji:
                //跳转忘记密码页面
                Intent intent2 = new Intent(this, ForGetPawActivity.class);
                startActivity(intent2);
                break;
            case R.id.but_denglu:
                //发送登录请求
                Toast.makeText(this, "这是一个登陆按钮", Toast.LENGTH_SHORT).show();
                String login = phone.getText().toString();
                String mima = paw.getText().toString();

                break;
            case R.id.yanzhengma:
                //跳转验证码登录页面
                Intent intent1 = new Intent(this, YanZhengMaActivity.class);
                startActivity(intent1);
                break;
            case R.id.yijian:
                //跳转一键登录页面
                Toast.makeText(this, "这是一个预留按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sanfang_qq:
                //三方QQ登录
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String>
                            map) {
                        Toast.makeText(RegisterActivity.this, "成功了", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                        Toast.makeText(RegisterActivity.this, "失败：" + throwable.getMessage(), Toast
                                .LENGTH_LONG).show();
                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {
                        Toast.makeText(RegisterActivity.this, "取消了", Toast.LENGTH_LONG).show();
                    }
                });

                break;
            case R.id.sanfang_weixin:
                //三方微信登录
                Toast.makeText(this, "三方微信", Toast.LENGTH_SHORT).show();
                UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.WEIXIN, new UMAuthListener
                        () {
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {

                    }

                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String>
                            map) {

                    }

                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                    }

                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {

                    }
                });
                break;
            case R.id.sanfang_weibo:
                //三方微博登录
                Toast.makeText(this, "三方微博", Toast.LENGTH_SHORT).show();

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Optional
    @OnClick(R.id.eye)
    public void onViewClicked() {
        String s = paw.getText().toString();
        if (!s.isEmpty()) {
//            eye.setEnabled(true);
//            eye.setDrawingCacheEnabled(true);
            if (eye.isChecked()) {
                paw.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else {
                paw.setInputType(InputType.TYPE_CLASS_TEXT | InputType
                        .TYPE_TEXT_VARIATION_PASSWORD);
            }
        } else {
//            eye.setEnabled(false);
//            eye.setDrawingCacheEnabled(false);
            boolean checked = eye.isChecked();
            eye.setChecked(!checked);
            Toast.makeText(this, "您还没有输入密码", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //防止内存泄漏
        UMShareAPI.get(this).release();
    }

}