package com.example.t.app.global;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.socialize.PlatformConfig;

import java.util.Vector;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/24 09:59
 * 作 者：T
 * 微信：704003376
 */
public class MyApplication extends Application {
    public static Context mCtontext;
    public static Vector<Activity> objectVector;
    public SharedPreferences msp;

    @Override
    public void onCreate() {
        mCtontext = this;
        objectVector = new Vector<Activity>();
        msp = getSharedPreferences("config", MODE_PRIVATE);
        super.onCreate();
        UMConfigure.setLogEnabled(true);
        // 参数一：当前上下文context；
        // 参数二：应用申请的Appkey（需替换）；
        // 参数三：渠道名称；
        // 参数四：设备类型，必须参数，传参数为UMConfigure.DEVICE_TYPE_PHONE则表示手机；传参数为UMConfigure
        // .DEVICE_TYPE_BOX则表示盒子；默认为手机；
        // 参数五：Push推送业务的secret 填充Umeng Message Secret对应信息（需替换）
        UMConfigure.init(this, "5c065105f1f556e2e000010f", "MyYouMeng", UMConfigure
                .DEVICE_TYPE_PHONE, "e6469a9a7298d3a7abe2cfbba8745c67");
        //获取消息推送代理示例
        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
                Log.e("tag", "注册成功：deviceToken：-------->  " + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.e("tag", "注册失败：-------->  " + "s:" + s + ",s1:" + s1);
            }
        });


        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns" +
                ".whalecloud.com");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");

        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        Log.d("TAG", "本应用程序的最大内存为：" + maxMemory + "KB");
    }
}
