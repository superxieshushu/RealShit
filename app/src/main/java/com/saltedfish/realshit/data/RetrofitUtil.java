package com.saltedfish.realshit.data;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SaltedFish on 2018/11/14.
 * RetrofitUtil
 */

public class RetrofitUtil {
    private static RetrofitUtil sInstance;
    private static ApiService sApiService;

    private RetrofitUtil() {

    }

    public static RetrofitUtil getInstance() {
        if (sInstance == null) {
            synchronized (RetrofitUtil.class) {
                if (sInstance == null) {
                    initRetrofit();
                    sInstance = new RetrofitUtil();
                }
            }
        }
        return sInstance;
    }

    /**
     * 初始化retrofit
     */
    private static void initRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(getOKHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://gank.io")
                .build();
        sApiService = retrofit.create(ApiService.class);
    }

    /**
     * 初始化OkHttpClient
     *
     * @return OkHttpClient
     */
    private static OkHttpClient getOKHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);
        builder.connectTimeout(20, TimeUnit.SECONDS);
        return builder.build();
    }

    /**
     * 获取ApiService
     *
     * @return ApiService
     */
    public ApiService getApiService() {
        return sApiService;
    }
}
