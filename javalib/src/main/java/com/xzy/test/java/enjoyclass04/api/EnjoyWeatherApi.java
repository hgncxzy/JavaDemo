package com.xzy.test.java.enjoyclass04.api;




import com.xzy.test.javademo.enjoyclass04.retrofit.annotation.Field;
import com.xzy.test.javademo.enjoyclass04.retrofit.annotation.GET;
import com.xzy.test.javademo.enjoyclass04.retrofit.annotation.POST;
import com.xzy.test.javademo.enjoyclass04.retrofit.annotation.Query;

import okhttp3.Call;

public interface EnjoyWeatherApi {

    @POST("/v3/weather/weatherInfo")
    Call postWeather(@Field("city") String city, @Field("key") String key);


    @GET("/v3/weather/weatherInfo")
    Call getWeather(@Query("city") String city, @Query("key") String key);
}
