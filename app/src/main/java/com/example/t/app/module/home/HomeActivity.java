package com.example.t.app.module.home;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.t.app.R;
import com.example.t.app.base.BaseActivity;
import com.example.t.app.global.MyApplication;
import com.example.t.app.util.SystemFacade;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/25 10:43
 * 作 者：T
 * 微信：704003376
 */

public class HomeActivity extends BaseActivity {
    @Nullable
    @BindView(R.id.vp)
    ViewPager vp;

    @Override
    protected void initView() {
        MyApplication.objectVector.add(this);
        addFragment(R.id.ll_container, new HomeFragment());
        translucentStatusBarAndImmersive(this);
    }

    //影藏底部栏
    private void translucentStatusBarAndImmersive(Activity activity) {
        if (!SystemFacade.hasKitKat()) {
            return;
        }
        //如果系统版本大于API 19 小于 API 小于 API 21
        if (SystemFacade.hasKitKat() && !SystemFacade.hasLollipop()) {

            Window window = activity.getWindow();
            //在 4.4 api 19 和 API 20 添加FLAG_TRANSLUCENT_STATUS 是让系统状态栏为透明，同时系统会制动设置View
            // .SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | NewsView.SYSTEM_UI_FLAG_LAYOUT_STABLE
            //所以布局延伸到了状态下面
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        } else if (SystemFacade.hasLollipop()) {
            Window window = activity.getWindow();
            //添加Flag把状态栏设为可绘制模式
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            //设置状态栏为透明
            window.setStatusBarColor(Color.TRANSPARENT);
            //设置让布局延伸到状态栏下面
            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        }
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void loadData() {


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            clickTwoExit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private boolean mFlag;

    private void clickTwoExit() {
        if (!mFlag) {
            mFlag = true;
            Toast.makeText(HomeActivity.this, R.string.click_two_exit_message, Toast
                    .LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mFlag = false;
                }
            }, 2000);

        } else {
            for (Activity activity : MyApplication.objectVector) {
                activity.finish();
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
//        ButterKnife.bind(this);
    }
}
