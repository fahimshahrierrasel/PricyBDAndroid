package com.treebricks.priceybd.rest;

import com.treebricks.priceybd.models.AllBrands;
import com.treebricks.priceybd.models.AllPrices;
import com.treebricks.priceybd.models.AllShortDetails;
import com.treebricks.priceybd.models.MobileDetail;
import com.treebricks.priceybd.models.MobileShortDetail;
import com.treebricks.priceybd.models.Shop;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by fahim on 8/29/16.
 */
public interface ApiInterface
{
    @GET("device/{id}")
    Call<MobileDetail> getMobileDetail(@Path("id")int id);

    @GET("devicesshortinfo")
    Call<AllShortDetails> getAllMobileShortDetail();

    @GET("deviceprice/{id}")
    Call<AllPrices> getAllPrices(@Path("id") int id);

    @GET("shop/{id}")
    Call<Shop> getshop(@Path("id") int id);

    @GET("brands")
    Call<AllBrands> getBrands();
}
