package com.example.t.app.in;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.t.app.R;
import com.example.t.app.module.home.HomeActivity;
import com.example.t.app.util.SystemFacade;

import butterknife.OnTouch;

public class SplashActivity extends AppCompatActivity {

    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        };
        handler.postDelayed(runnable, 2000);

        translucentStatusBarAndImmersive(this);
    }

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
    public void onBackPressed() {
        super.onBackPressed();
        //移除回调
        handler.removeCallbacks(runnable);
    }

}
