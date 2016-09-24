package com.treebricks.priceybd.rest;

import com.treebricks.priceybd.models.AllBrands;
import com.treebricks.priceybd.models.AllModels;
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

    @GET("devicebyname/{name}")
    Call<MobileDetail> getMobileDetailbyName(@Path("id")String name);

    @GET("devicesshortinfo")
    Call<AllShortDetails> getAllMobileShortDetail();

    @GET("deviceprice/{id}")
    Call<AllPrices> getAllPrices(@Path("id") int id);

    @GET("shop/{id}")
    Call<Shop> getshop(@Path("id") int id);

    @GET("brands")
    Call<AllBrands> getBrands();

    @GET("directsortdevices/Brand/{brandName}")
    Call<AllShortDetails> getDeviceByBrand(@Path("brandName") String brandName);

    @GET("sortdevices/BatteryCapacity/{capacity}")
    Call<AllShortDetails> sortDeviceByBattery(@Path("capacity") int capacity);

    @GET("sortdevices/MemoryInternal/{romSize}")
    Call<AllShortDetails> sortDeviceByRom(@Path("romSize") int romSize);

    @GET("sortdevices/MemoryRam/{ramSize}")
    Call<AllShortDetails> sortDeviceByRam(@Path("ramSize") int ramSize);

    @GET("sortdevices/SecondaryCamera/{camera}")
    Call<AllShortDetails> sortDeviceBySelfieCamera(@Path("camera") int camera);

    @GET("sortdevices/PrimaryCamera/{camera}")
    Call<AllShortDetails> sortDeviceByPrimaryCamera(@Path("camera") int camera);

    @GET("sortdevices/Cpu/{speed}")
    Call<AllShortDetails> sortDeviceByProcessorSpeed(@Path("speed") float speed);

    @GET("sortbyprice/{price}")
    Call<AllShortDetails> sortDeviceByPrice(@Path("price") int price);

    @GET("alldevicesname")
    Call<AllModels> getAllModelNames();

    @GET("shortinfo/{modelName}")
    Call<MobileShortDetail> getShortInfo(@Path("modelName") String ModelName);

}
