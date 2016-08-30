package com.treebricks.priceybd.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fahim on 8/29/16.
 */
public class Shop {
    @SerializedName("SHOP_ID")
    private String shopId;

    @SerializedName("SHOP_NAME")
    private String shopName;

    @SerializedName("SHOP_ADDRESS")
    private String shopAddress;

    @SerializedName("SHOP_EMAIL")
    private String shopMail;

    @SerializedName("SHOP_MOBILE_NUMBER")
    private String shopMobileNumber;

    @SerializedName("LATITUDE")
    private String latitude;

    @SerializedName("LONGITUDE")
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
