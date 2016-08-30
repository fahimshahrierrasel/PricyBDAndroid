package com.treebricks.priceybd.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fahim on 8/29/16.
 */
public class MobilePrice {
    @SerializedName("PRICE_ID")
    private String priceID;

    @SerializedName("MOBILE_ID")
    private String mobileID;

    @SerializedName("SHOP_ID")
    private String shopId;

    @SerializedName("PRICE")
    private String price;

    public String getPriceID() {
        return priceID;
    }

    public void setPriceID(String priceID) {
        this.priceID = priceID;
    }

    public String getMobileID() {
        return mobileID;
    }

    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
