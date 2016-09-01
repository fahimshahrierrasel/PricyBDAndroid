package com.treebricks.priceybd.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fahim on 9/1/16.
 */
public class Brand {

    @SerializedName("BRAND_ID")
    private String brandID;

    @SerializedName("BRAND_NAME")
    private String brandName;

    @SerializedName("BRAND_IMG")
    private String brandImg;

    public Brand() {
    }

    public Brand(String brandID, String brandName, String brandImg) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.brandImg = brandImg;
    }

    public String getBrandID() {
        return brandID;
    }

    public void setBrandID(String brandID) {
        this.brandID = brandID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandImg() {
        return brandImg;
    }

    public void setBrandImg(String brandImg) {
        this.brandImg = brandImg;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandID='" + brandID + '\'' +
                ", brandName='" + brandName + '\'' +
                ", brandImg='" + brandImg + '\'' +
                '}';
    }
}