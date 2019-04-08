package com.example.t.app.mvp.model;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/24 15:13
 * 作 者：T
 * 微信：704003376
 */
public interface APIServicde<T> {

    @GET
    Observable<ResponseBody> getData(@Url String url);

    @GET
    Observable<ResponseBody> getData(@Url String url, @QueryMap HashMap<String, Object> params);

    @POST
    @FormUrlEncoded
    Observable<ResponseBody> postData(@Url String url, @FieldMap Map<String, Object> params);

    @POST
    @FormUrlEncoded
    Observable<ResponseBody> postData(@Url String url);


    @POST
    @FormUrlEncoded
    Observable<ResponseBody> postData(@HeaderMap Map<String, Object> headers,
                                      @Url String url, @FieldMap Map<String, Object> params);


    @POST
    @FormUrlEncoded
    Observable<ResponseBody> postData(@HeaderMap Map<String, Object> headers,
                                      @Url String url);

    @GET
    @Streaming
    Observable<ResponseBody> downloadFile(@Url String url);

    @POST
    @Multipart
    Observable<ResponseBody> uploadFile(@Url String url, @Part Part part);

    @POST
    @Multipart
    Observable<ResponseBody> uploadFiles(@Url String url, @Part List<File> list);


}
