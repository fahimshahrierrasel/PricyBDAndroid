package com.treebricks.priceybd.models;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fahim on 8/29/16.
 */

public class MobileShortDetail {

    @SerializedName("MobileID")
    private String mobileID;

    @SerializedName("Brand")
    private String brand;

    @SerializedName("ModelName")
    private String modelName;

    @SerializedName("Photo")
    private String photo;


    public MobileShortDetail() {
    }

    public MobileShortDetail(String mobileID, String brand, String modelName, String photo) {
        this.mobileID = mobileID;
        this.brand = brand;
        this.modelName = modelName;
        this.photo = photo;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "MobileShortDetail{" +
                "mobileID='" + mobileID + '\'' +
                ", brand='" + brand + '\'' +
                ", modelName='" + modelName + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}