package com.treebricks.priceybd.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by fahim on 9/1/16.
 */
public class Brand {

    @SerializedName("BrandID")
    private String brandID;

    @SerializedName("BrandName")
    private String brandName;

    @SerializedName("BrandImage")
    private String brandImage;

    public Brand() {
    }

    public Brand(String brandID, String brandName, String brandImage) {
        this.brandID = brandID;
        this.brandName = brandName;
        this.brandImage = brandImage;
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

    public String getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(String brandImage) {
        this.brandImage = brandImage;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandID='" + brandID + '\'' +
                ", brandName='" + brandName + '\'' +
                ", brandImage='" + brandImage + '\'' +
                '}';
    }
}