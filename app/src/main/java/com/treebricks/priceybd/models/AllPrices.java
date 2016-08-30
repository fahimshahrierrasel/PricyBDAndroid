package com.treebricks.priceybd.models;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fahim on 8/29/16.
 */
public class AllPrices {

    @SerializedName("prices")
    @Expose
    private List<MobilePrice> prices = new ArrayList<MobilePrice>();

    /**
     *
     * @return
     * The prices
     */
    public List<MobilePrice> getPrices() {
        return prices;
    }

    /**
     *
     * @param prices
     * The prices
     */
    public void setPrices(List<MobilePrice> prices) {
        this.prices = prices;
    }
}
