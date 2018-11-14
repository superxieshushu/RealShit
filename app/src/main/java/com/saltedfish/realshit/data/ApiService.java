package com.saltedfish.realshit.data;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by SaltedFish on 2018/11/14.
 * 接口
 */

public interface ApiService {

    @GET("/api/today")
    Observable<TodayInfo> fetchTodayInfo();

}
