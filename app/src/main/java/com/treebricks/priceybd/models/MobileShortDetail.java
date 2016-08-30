package com.treebricks.priceybd.models;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fahim on 8/29/16.
 */

public class MobileShortDetail {

    @SerializedName("MOBILE_ID")
    private String mobileID;

    @SerializedName("BRAND")
    private String brand;

    @SerializedName("MODEL_NAME")
    private String modelName;

    @SerializedName("THUMBNAIL")
    private String thumbnail;


    public MobileShortDetail() {
    }

    public MobileShortDetail(String mobileID, String brand, String modelName, String thumbnail) {
        this.mobileID = mobileID;
        this.brand = brand;
        this.modelName = modelName;
        this.thumbnail = thumbnail;
    }

    public String getMobileID() {
        return mobileID;
    }

    public void setMobileID(String mobileID) {
        this.mobileID = mobileID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "MobileShortDetail{" +
                "mobileID='" + mobileID + '\'' +
                ", brand='" + brand + '\'' +
                ", modelName='" + modelName + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}