package com.treebricks.priceybd.models;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fahim on 9/24/16.
 */

public class AllModels {

    @SerializedName("models")
    private List<String> models = new ArrayList<String>();

    /**
     *
     * @return
     * The models
     */
    public List<String> getModels() {
        return models;
    }

    /**
     *
     * @param models
     * The models
     */
    public void setModels(List<String> models) {
        this.models = models;
    }

}