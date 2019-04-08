package com.example.t.app.mvp.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;

import com.example.t.app.constants.Constants;
import com.example.t.app.global.MyApplication;
import com.example.t.app.util.SDCardUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/24 15:26
 * 作 者：T
 * 微信：704003376
 */
public class RetrofitManager {
    private static final long MAX_CACHE_SIZE = 1024 * 1024 * 10;
    private static RetrofitManager manager;
    private Retrofit mRetrotit;

    private RetrofitManager() {
        init();
    }

    private void init() {
        File file = null;
        if (SDCardUtil.siAvaliable(MAX_CACHE_SIZE)) {
            // storage/sdcard/cache
            file = new File(Environment.getExternalStorageDirectory(), "cache");
        } else {
            file = new File(MyApplication.mCtontext.getCacheDir(), "");
        }
        Cache cache = new Cache(file, MAX_CACHE_SIZE);
        OkHttpClient.Builder builder = new OkHttpClient.Builder().
                cache(cache).connectTimeout(15, TimeUnit.SECONDS).
                readTimeout(10, TimeUnit.SECONDS).
                retryOnConnectionFailure(true);

        OkHttpClient okhttpClient = getOkhttpClient(MyApplication.mCtontext);
        mRetrotit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).
                client(okhttpClient).build();
    }


    public static synchronized RetrofitManager getManagerInstance() {
        if (manager == null) {
            synchronized (RetrofitManager.class) {
                if (manager == null) {
                    manager = new RetrofitManager();
                }
            }
        }
        return manager;
    }


    public APIServicde
    getApiService() {
        return mRetrotit.create(APIServicde.class);
    }

    //以下为拦截器
    private OkHttpClient getOkhttpClient(Context context) {
        //创建缓存路径，定义缓存文件的大小
        Cache cache = new Cache(new File(context.getCacheDir(), "Cache"), 1024 * 1024 * 10);
        MyCacheinterceptor myCacheinterceptor = new MyCacheinterceptor(context);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(myCacheinterceptor)
                .addNetworkInterceptor(myCacheinterceptor)
                .cache(cache)
                .build();
        return okHttpClient;
    }

    private class MyCacheinterceptor implements Interceptor {
        private Context context;

        public MyCacheinterceptor(Context context) {
            this.context = context;
        }

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            //这里就是说判读我们的网络条件，要是有网络的话我么就直接获取网络上面的数据，要是没有网络的话我么就去缓存里面取数据
            if (!isNetworkAvailable(context)) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();

            }
            Response originalResponse = chain.proceed(request);
            if (isNetworkAvailable(context)) {
                int maxAge = 0;
                return originalResponse.newBuilder()
                        // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 15;
                return originalResponse.newBuilder()
                        // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .removeHeader("Pragma")
                        //这里的设置的是我们的没有网络的缓存时间，想设置多少就是多少。
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }

        }
    }

    //网络判断请求
    public static boolean isNetworkAvailable(Context context) {
        if (context != null) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = cm.getActiveNetworkInfo();
            if (info != null) {
                return info.isAvailable();
            }
        }
        return false;
    }
}
