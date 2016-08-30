package com.treebricks.priceybd.models;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * Created by fahim on 8/29/16.
 */


public class AllShortDetails {

    @SerializedName("devices")
    private List<MobileShortDetail> devices = new ArrayList<MobileShortDetail>();

    /**
     *
     * @return
     * The devices
     */
    public List<MobileShortDetail> getDevices() {
        return devices;
    }

    /**
     *
     * @param devices
     * The devices
     */
    public void setDevices(List<MobileShortDetail> devices) {
        this.devices = devices;
    }

}