package com.example.t.app.live.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.t.app.R;
import com.example.t.app.base.BaseActivity;
import com.example.t.app.entity.Detail;
import com.example.t.app.mvp.presenter.BlankPresenter;
import com.example.t.app.mvp.Contract;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailActivity extends BaseActivity implements Contract.BaseView {

    //    @Nullable
//    @BindView(R.id.title)
//    TextView title;
//    @Nullable
//    @BindView(R.id.publishTime)
//    TextView publishTime;
//    @Nullable
//    @BindView(R.id.source)
//    TextView source;
    @Nullable
    @BindView(R.id.wv)
    WebView wv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int getActivityLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    protected void loadData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        BlankPresenter presenter = new BlankPresenter(this);
        presenter.Http2(url);
    }

    @Override
    public void setPresenter(Contract.BasePresenter basePresenter) {

    }


    @Override
    public void onDataSucess(Object o) {
        if (o instanceof Detail) {
            Detail detail = (Detail) o;
            final Detail.RESULTBean result = detail.getRESULT();
//            title.setText(result.getTitle());
//            publishTime.setText("更新时间：" + result.getPublishTime());
//            source.setText("来源：" + result.getSource());
            toolbar.setSubtitle(result.getSource());
            toolbar.setTitle(result.getTitle());

            WebSettings webSettings = wv.getSettings();//获取webview设置属性
            //把html中的内容放大webview等宽的一列中
            webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
            webSettings.setJavaScriptEnabled(true);//支持js
//            webSettings.setBuiltInZoomControls(true); // 显示放大缩小
            webSettings.setSupportZoom(true); // 可以缩放

            wv.setWebViewClient(new MyWebViewClient());
            wv.addJavascriptInterface(new JavaScriptInterface(this), "imagelistner");//这个是给图片设置点击监听的，如果你项目需要webview中图片，点击查看大图功能，可以这么添加
            wv.loadDataWithBaseURL(null, result.getContent(), "text/html", "utf-8", null);
        }
    }

    @Override
    public void onDataFaile(Object o) {

    }

    @Override
    public void onComplete() {

    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            imgReset();//重置webview中img标签的图片大小
            // html加载完成之后，添加监听图片的点击js函数
            addImageClickListner();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }


        /**
         * 对图片进行重置大小，宽度就是手机屏幕宽度，高度根据宽度比便自动缩放
         */
        private void imgReset() {
            wv.loadUrl("javascript:(function(){" +
                    "var objs = document.getElementsByTagName('img'); " +
                    "for(var i=0;i<objs.length;i++)  " +
                    "{"
                    + "var img = objs[i];   " +
                    "    img.style.maxWidth = '100%'; img.style.height = 'auto';  " +
                    "}" +
                    "})()");
        }

        private void addImageClickListner() {
            // 这段js函数的功能就是，遍历所有的img节点，并添加onclick函数，
            // 函数的功能是在图片点击的时候调用本地java接口并传递url过去
            wv.loadUrl("javascript:(function(){" +
                    "var objs = document.getElementsByTagName(\"img\"); " +
                    "for(var i=0;i<objs.length;i++)  " +
                    "{"
                    + "window.imagelistner.readImageUrl(objs[i].src);"
                    + "    objs[i].onclick=function()  " +
                    "    {  "
                    + "        window.imagelistner.openImage(this.src);  " +
                    "    }  " +
                    "}" +
                    "})()");
        }
    }

    class JavaScriptInterface {
        private Context context;
        private List<String> images = new ArrayList<>();
        public JavaScriptInterface(Context context) {
            this.context = context;
        }
        @JavascriptInterface
        public void readImageUrl(String img) {  //把所有图片的url保存在ArrayList<String>中
            images.add(img);
        }

        //点击图片回调方法
        //必须添加注解,否则无法响应
        @JavascriptInterface
        public void openImage(String img) {
            Log.i("TAG", "响应点击事件!");
            Toast.makeText(context, "响应点击事件", Toast.LENGTH_SHORT).show();

            int index = 0;
            ArrayList<String> list = addImages();
            for (String url : list)
                if (url.equals(img)) index = list.indexOf(img);//获取点击图片在整个页面图片中的位置

            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("list_image", list);
            bundle.putInt("index", index);
            intent.putExtra("bundle", bundle);//将所有图片的url以及点击图片的位置作为参数传给启动的activity
            intent.setClass(context, ShowWebImageActivity.class);//BigImageActivity查看大图的类，自己定义就好
            DetailActivity.this.startActivity(intent);//启动ViewPagerActivity,用于显示图片
        }

        //去重复
        private ArrayList<String> addImages() {
            ArrayList<String> list = new ArrayList<>();
            Set set = new HashSet();
            for (String cd : images) {
                if (set.add(cd)) {
                    list.add(cd);
                }
            }
            return list;
        }
    }
}
