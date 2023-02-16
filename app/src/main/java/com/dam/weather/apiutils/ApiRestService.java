package com.dam.weather.apiutils;

import com.dam.weather.data.WeatherRes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiRestService {
    public static final String BASE_URL = "https://api.darksky.net/forecast/"; //we need to add the api key

    @GET("{key}/{latitude},{longitude}?exclude=minutely,hourly,daily,alerts,flags&lang=en")
    Call<WeatherRes> getWeather(@Path("key") String key, @Path("latitude") Double latitude, @Path("longitude") Double longitude);
}
