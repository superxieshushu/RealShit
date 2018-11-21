package com.saltedfish.realshit.data;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by SaltedFish on 2018/11/14.
 * 接口
 */

public interface ApiService {

    @GET("/api/today")
    Observable<TodayInfo> fetchTodayInfo();


    @GET("/api/data/{category}/{pageSize}/{Page}")
    Observable<AndroidInfo> fetchAndroidInfo(@Path("category") String category,
                                             @Path("pageSize") String pageSize,
                                             @Path("Page") String page);

    @GET("/api/data/{category}/{pageSize}/{Page}")
    Observable<IOSInfo> fetchIOSInfo(@Path("category") String category,
                                     @Path("pageSize") String pageSize,
                                     @Path("Page") String page);

    @GET("/api/data/{category}/{pageSize}/{Page}")
    Observable<BenefitInfo> fetchBenefitInfo(@Path("category") String category,
                                             @Path("pageSize") String pageSize,
                                             @Path("Page") String page);
}
