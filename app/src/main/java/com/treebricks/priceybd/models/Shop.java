package com.treebricks.priceybd.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fahim on 8/29/16.
 */
public class Shop {
    @SerializedName("ShopID")
    private String shopId;

    @SerializedName("ShopName")
    private String shopName;

    @SerializedName("ShopAddress")
    private String shopAddress;

    @SerializedName("ShopEmail")
    private String shopMail;

    @SerializedName("ShopMobileNumber")
    private String shopMobileNumber;

    @SerializedName("Latitude")
    private String latitude;

    @SerializedName("Longitude")
    private String longitude;


    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopMail() {
        return shopMail;
    }

    public void setShopMail(String shopMail) {
        this.shopMail = shopMail;
    }

    public String getShopMobileNumber() {
        return shopMobileNumber;
    }

    public void setShopMobileNumber(String shopMobileNumber) {
        this.shopMobileNumber = shopMobileNumber;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopId='" + shopId + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", shopMail='" + shopMail + '\'' +
                ", shopMobileNumber='" + shopMobileNumber + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
