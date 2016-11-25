package com.example.radek.localweather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherFactory {

    private WeatherFactory() {

    }

    public static WeatherApi getApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.apixu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(WeatherApi.class);
    }
}
