package com.treebricks.priceybd.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fahim on 9/1/16.
 */
public class AllBrands {

    @SerializedName("brands")
    private List<Brand> brands = new ArrayList<Brand>();


    public AllBrands() {
    }


    public AllBrands(List<Brand> brands) {
        this.brands = brands;
    }


    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

}