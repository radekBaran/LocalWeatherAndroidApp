package com.example.radek.localweather;

import com.example.radek.localweather.weatherApi.RespBody;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET("v1/current.json")
    Call<RespBody> getWeather(@Query("q") String location, @Query("key") String key);
}
