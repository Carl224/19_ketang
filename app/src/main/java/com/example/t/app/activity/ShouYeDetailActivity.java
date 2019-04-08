package com.example.t.app.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.alipay.sdk.app.EnvUtils;
import com.alipay.sdk.app.PayTask;
import com.bumptech.glide.Glide;
import com.example.t.app.R;
import com.example.t.app.base.BaseActivity;
import com.example.t.app.util.OrderInfoUtil2_0;
import com.example.t.app.util.PayResult;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * 重要说明：
 * <p>
 * 本 Demo 只是为了方便直接向商户展示支付宝的整个支付流程，所以将加签过程直接放在客户端完成
 * （包括OrderInfoUtil2_0）。
 * <p>
 * 在真实 App 中，私钥（如 RSA_PRIVATE 等）数据严禁放在客户端，同时加签过程务必要放在服务端完成，
 * 否则可能造成商户私密数据泄露或被盗用，造成不必要的资金损失，面临各种安全风险。
 */
public class ShouYeDetailActivity extends BaseActivity {
    @BindView(R.id.jiaozi)
    JZVideoPlayerStandard jiaozi;
    @BindView(R.id.alipay)
    Button alipay;


    /**
     * 用于支付宝支付业务的入参 app_id。
     */
    private static final String APPID = "2016092300581162";
    /**
     * pkcs8 格式的商户私钥。
     * <p>
     * 如下私钥，RSA2_PRIVATE 或者 RSA_PRIVATE 只需要填入一个，如果两个都设置了，本 Demo 将优先
     * 使用 RSA2_PRIVATE。RSA2_PRIVATE 可以保证商户交易在更加安全的环境下进行，建议商户使用
     * RSA2_PRIVATE。
     * <p>
     * 建议使用支付宝提供的公私钥生成工具生成和获取 RSA2_PRIVATE。
     * 工具地址：https://doc.open.alipay.com/docs/doc.htm?treeId=291&articleId=106097&docType=1
     */
    private static final String RSA2_PRIVATE =
            "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCIt6UESK3p6bcSbv03R36KUwjU+6pFRZAE0IhGQd8otR/Iu1xdwwF0JyQeA7qow4Jr1goxXHMw+R" +
                    "/96HDLRRRHGnAZKIAdUtZE1nlrkzPYa7E1ULQbOmvw+XdGvduQgzvc+QkB0/Wdam4lst4LeMRfafpAyvh7wG5kcI4bno+ZOle2Ine/Qkn" +
                    "/EeMUHhr1i7RSwQRsQO6pwA6oc9z76mUP/EiL4glcOowvFXIZrEZuSEs6h2fEjUacEMFkjpPJvdQqKWGd7ZKlNtvE3dIC3" +
                    "/4xBp3Qrwh0uNaVYbjIZ1hQogOfBpSDUNtZ8voWBfzhqdBbgtlZba6s/R+GGX" +
                    "+iLQFNAgMBAAECggEAHB3YfAcObTq5gbr9rG6xoXTuLg8Lt29U7QiN3hUR9ec6ACg4GLhQBjk+fkW6D5cVrWO5eOlQb1PstmUlPUiZoP3Y6" +
                    "/OeVWmB02pgUjVVxj5vlU1hnO/o3wgO9ad6DkBPAWTd61hR/Ou0d2BPtgBCMnUzGDwl2h17FoDnWNrFIXfGARhbWY61D+rkbQy03TmY2Mibv2jRvQzBtXgH6Mw2n" +
                    "/ijIA2B9jmjWKbLLNR2l3f+twtOMVQtWivZT+TbGIWbWLdo/DiLOEJHFu8Xys+kVeBI9MKBcYM69KYUO+JFYh6UN9IkfCBjVksxH1+geTQGVrw8vMPlG" +
                    "/0TUAiohNNMAQKBgQDfl1qrluhB3aDacuXA+3Eeuoh5npH3xgZ843P/rcFAN1i+jXDAc+zzDzno318EKuxlPCUGTfk/UC8aU/UNb7/l8A25IotayBWafkkzljYo2" +
                    "/Enkgi1DPlbLtFrWs381vp1o44rTSqIizOO9RuAXz8Ccl0aOX5tSqRBx+85PNy9gQKBgQCciLi+8IIsUjgB6DKnqdOo4pyEHgRW2Wu3yoM8" +
                    "+x3y0BFNlIU6ZrI8bbreq2X/+cPxj2vkZSw7mVqT4sh/OL09YzJN9sbvQPiyRDjJ2KxuxjzgoPjyCsdpn+fY/wHDBcrWwmfhZmCu1tQ" +
                    "/NDMVgjfB5GNVujqp5BJzNDGiVgvBzQKBgFPhKgi5QkSDanbJJ9wv+A35GH3XuRbk2UY85iWC/76hhM9nrGbmlnvQuH7eXXzoxWptF863rcvMvv73hDUYOTt" +
                    "/xQYxKWpTKZedzMRnk8XcTSn1JQMW7O0CMVo+5Iv38lnzk8A24L/8yMjWtwx" +
                    "/rtmyIa9W5lEF8X0kDmDArmcBAoGAfsL5WSbLQ7kRQfoXi08r6Iga16K3QN2xLZUB0lBJYGi+mmS7vx+LFwSFX+zNHQ3Wb7gFV1/XAiyd" +
                    "/USZuOzp0tyR0DEXyIiE3VgB5PNiMBK5Ge9BqkCwXAjyZ/eaJaR7Lo8gMJgHk47FMqnC9JgPLyUUjEfTWeEoT8LkruGfg8ECgYEAvmZJwtMHdqPNzU15Kp0bcLn" +
                    "+49etvLVz1e1EaSdViQy4V4xT9liSw8U5edUtJPZeD7BKJBBUq06dByvSgRo9R7lgbMSH0zq7IbNYBEOnG0A5i5yDN1Ju4/OkzD70An5EbcwD9xNBdCX+P" +
                    "/+HWRbtTWd4MjQeFBs65MVzD9CMAqQ=";
    private static final String RSA_PRIVATE = "";
    private static final int SDK_PAY_FLAG = 1;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();//返回码
//                     判断resultStatus 为9000则代表支付成功
                    switch (resultStatus) {
                        case "9000":
                            Toast.makeText(ShouYeDetailActivity.this, "支付成功" + payResult, Toast.LENGTH_SHORT).show();
                            break;
                        case "8000":
                            Toast.makeText(ShouYeDetailActivity.this, "正在处理中" + payResult, Toast.LENGTH_SHORT).show();
                            break;
                        case "4000":
                            Toast.makeText(ShouYeDetailActivity.this, "支付成功" + payResult, Toast.LENGTH_SHORT).show();
                            break;
                        case "5000":
                            Toast.makeText(ShouYeDetailActivity.this, "重复请求" + payResult, Toast.LENGTH_SHORT).show();
                            break;
                        case "6001":
                            Toast.makeText(ShouYeDetailActivity.this, "已取消支付" + payResult, Toast.LENGTH_SHORT).show();
                            break;
                        case "6002":
                            Toast.makeText(ShouYeDetailActivity.this, "网络连接出错" + payResult, Toast.LENGTH_SHORT).show();
                            break;
                        case "6004":
                            Toast.makeText(ShouYeDetailActivity.this, "正在处理中" + payResult, Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(ShouYeDetailActivity.this, "支付失败" + payResult, Toast.LENGTH_SHORT).show();
                            break;
                    }
//                    if (TextUtils.equals(resultStatus, "9000")) {
//                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
//                        showAlert(ShouYeDetailActivity.this, "支付成功===" + payResult);
//                    } else {
//                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
//                        showAlert(ShouYeDetailActivity.this, "支付失败===" + payResult);
//                    }
                    break;
                }
            }
        }

        ;
    };

    @Override
    protected void initView() {
        jiaozi.setUp("http://jzvd.nathen" +
                        ".cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0" +
                        "-5287d2089db37e62345123a1be272f8b.mp4"
                , JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "嫂子闭眼睛");
        Glide.with(this).load("http://p.qpic" +
                ".cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640").into(jiaozi
                .thumbImageView);
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EnvUtils.setEnv(EnvUtils.EnvEnum.SANDBOX);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_shouyedetail;
    }

    @Override
    protected void loadData() {

    }

    @OnClick(R.id.alipay)
    public void onViewClicked() {
        if (TextUtils.isEmpty(APPID) || (TextUtils.isEmpty(RSA2_PRIVATE) && TextUtils.isEmpty
                (RSA_PRIVATE))) {
            showAlert(this, "APPID或者应用私钥错误");
            return;
        }

        /*
         * 这里只是为了方便直接向商户展示支付宝的整个支付流程；所以Demo中加签过程直接放在客户端完成；
         * 真实App里，privateKey等数据严禁放在客户端，加签过程务必要放在服务端完成；
         * 防止商户私密数据泄露，造成不必要的资金损失，及面临各种安全风险；
         *
         * orderInfo 的获取必须来自服务端；
         */
        boolean rsa2 = (RSA2_PRIVATE.length() > 0);
        Map<String, String> params = OrderInfoUtil2_0.buildOrderParamMap(APPID, rsa2);
        String orderParam = OrderInfoUtil2_0.buildOrderParam(params);

        String privateKey = rsa2 ? RSA2_PRIVATE : RSA_PRIVATE;
        String sign = OrderInfoUtil2_0.getSign(params, privateKey, rsa2);
        final String orderInfo = orderParam + "&" + sign;

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(ShouYeDetailActivity.this);
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Log.i("msp", result.toString());

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };

        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    private static void showAlert(Context ctx, String info) {
        showAlert(ctx, info, null);
    }

    private static void showAlert(Context ctx, String info, DialogInterface.OnDismissListener
            onDismiss) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            new AlertDialog.Builder(ctx)
                    .setMessage(info)
                    .setPositiveButton("确定", null)
                    .setOnDismissListener(onDismiss)
                    .show();
        }
    }


}
