package com.treebricks.priceybd.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fahim on 8/29/16.
 */
public class ApiClient
{
    public static final String BASE_URL = "http://pricybdapi.192.168.0.30.xip.io:8888";
    public static Retrofit retrofit = null;

    public  static Retrofit getClient()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
