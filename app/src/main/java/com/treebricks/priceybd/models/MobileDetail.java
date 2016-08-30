package com.treebricks.priceybd.models;
import com.google.gson.annotations.SerializedName;


/**
 * Created by fahim on 8/29/16.
 */

public class MobileDetail {

    @SerializedName("MOBILE_ID")
    private int mobileId;

    @SerializedName("BRAND")
    private String brand;

    @SerializedName("MODEL_NAME")
    private String modelName;

    @SerializedName("NETWORK")
    private String network;

    @SerializedName("LAUNCH")
    private String launch;

    @SerializedName("DISPLAY_SIZE")
    private String displaySize;

    @SerializedName("DISPLAY_RESOLUTION")
    private String displayResolution;

    @SerializedName("DISPLAY_TYPE")
    private String displayType;

    @SerializedName("SIM_TYPE")
    private String simType;

    @SerializedName("WEIGHT")
    private String weight;

    @SerializedName("OS")
    private String os;

    @SerializedName("CHIPSET")
    private String chipset;

    @SerializedName("CPU")
    private String cpu;

    @SerializedName("GPU")
    private String gpu;

    @SerializedName("MEMORY_RAM")
    private String memoryRam;

    @SerializedName("MEMORY_INTERNAL")
    private String memoryInternal;

    @SerializedName("MEMORY_EXTERNAL")
    private String memoryExternal;

    @SerializedName("PRIMARY_CAMERA")
    private String primaryCamera;

    @SerializedName("SECONDARY_CAMERA")
    private String secondaryCamera;

    @SerializedName("CAMERA_FEATURES")
    private String cameraFeatures;

    @SerializedName("BATTERY_TYPE")
    private String batteryType;

    @SerializedName("BLUETOOTH")
    private String bluetooth;

    @SerializedName("WIFI")
    private String wifi;

    @SerializedName("NFC")
    private String nfc;

    @SerializedName("OTG")
    private String otg;

    @SerializedName("RADIO")
    private String radio;

    @SerializedName("GPS")
    private String gps;

    @SerializedName("USB")
    private String usb;

    @SerializedName("SENSORS")
    private String sensors;

    @SerializedName("COLORS")
    private String colors;

    @SerializedName("DIMENSIONS")
    private String dimensions;

    @SerializedName("PHOTO")
    private String photo;

    @SerializedName("THUMBNAIL")
    private String thumbnail;

    public MobileDetail() {
    }

    public MobileDetail(int mobileId, String brand, String modelName, String network,
                        String launch, String displaySize, String displayResolution,
                        String displayType, String simType, String weight, String os,
                        String chipset, String cpu, String gpu, String memoryRam,
                        String memoryInternal, String memoryExternal, String primaryCamera,
                        String secondaryCamera, String cameraFeatures, String batteryType,
                        String bluetooth, String wifi, String nfc, String otg, String radio,
                        String gps, String usb, String sensors, String colors, String dimensions,
                        String photo, String thumbnail)
    {
        this.mobileId = mobileId;
        this.brand = brand;
        this.modelName = modelName;
        this.network = network;
        this.launch = launch;
        this.displaySize = displaySize;
        this.displayResolution = displayResolution;
        this.displayType = displayType;
        this.simType = simType;
        this.weight = weight;
        this.os = os;
        this.chipset = chipset;
        this.cpu = cpu;
        this.gpu = gpu;
        this.memoryRam = memoryRam;
        this.memoryInternal = memoryInternal;
        this.memoryExternal = memoryExternal;
        this.primaryCamera = primaryCamera;
        this.secondaryCamera = secondaryCamera;
        this.cameraFeatures = cameraFeatures;
        this.batteryType = batteryType;
        this.bluetooth = bluetooth;
        this.wifi = wifi;
        this.nfc = nfc;
        this.otg = otg;
        this.radio = radio;
        this.gps = gps;
        this.usb = usb;
        this.sensors = sensors;
        this.colors = colors;
        this.dimensions = dimensions;
        this.photo = photo;
        this.thumbnail = thumbnail;
    }

    public int getMobileId() {
        return mobileId;
    }

    public void setMobileId(int mobileId) {
        this.mobileId = mobileId;
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

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getLaunch() {
        return launch;
    }

    public void setLaunch(String launch) {
        this.launch = launch;
    }

    public String getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(String displaySize) {
        this.displaySize = displaySize;
    }

    public String getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(String displayResolution) {
        this.displayResolution = displayResolution;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public String getSimType() {
        return simType;
    }

    public void setSimType(String simType) {
        this.simType = simType;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getMemoryRam() {
        return memoryRam;
    }

    public void setMemoryRam(String memoryRam) {
        this.memoryRam = memoryRam;
    }

    public String getMemoryInternal() {
        return memoryInternal;
    }

    public void setMemoryInternal(String memoryInternal) {
        this.memoryInternal = memoryInternal;
    }

    public String getMemoryExternal() {
        return memoryExternal;
    }

    public void setMemoryExternal(String memoryExternal) {
        this.memoryExternal = memoryExternal;
    }

    public String getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(String primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public String getSecondaryCamera() {
        return secondaryCamera;
    }

    public void setSecondaryCamera(String secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    public String getCameraFeatures() {
        return cameraFeatures;
    }

    public void setCameraFeatures(String cameraFeatures) {
        this.cameraFeatures = cameraFeatures;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getNfc() {
        return nfc;
    }

    public void setNfc(String nfc) {
        this.nfc = nfc;
    }

    public String getOtg() {
        return otg;
    }

    public void setOtg(String otg) {
        this.otg = otg;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getUsb() {
        return usb;
    }

    public void setUsb(String usb) {
        this.usb = usb;
    }

    public String getSensors() {
        return sensors;
    }

    public void setSensors(String sensors) {
        this.sensors = sensors;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "MobileDetail{" +
                "mobileId=" + mobileId +
                ", brand='" + brand + '\'' +
                ", modelName='" + modelName + '\'' +
                ", network='" + network + '\'' +
                ", launch='" + launch + '\'' +
                ", displaySize='" + displaySize + '\'' +
                ", displayResolution='" + displayResolution + '\'' +
                ", displayType='" + displayType + '\'' +
                ", simType='" + simType + '\'' +
                ", weight='" + weight + '\'' +
                ", os='" + os + '\'' +
                ", chipset='" + chipset + '\'' +
                ", cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", memoryRam='" + memoryRam + '\'' +
                ", memoryInternal='" + memoryInternal + '\'' +
                ", memoryExternal='" + memoryExternal + '\'' +
                ", primaryCamera='" + primaryCamera + '\'' +
                ", secondaryCamera='" + secondaryCamera + '\'' +
                ", cameraFeatures='" + cameraFeatures + '\'' +
                ", batteryType='" + batteryType + '\'' +
                ", bluetooth='" + bluetooth + '\'' +
                ", wifi='" + wifi + '\'' +
                ", nfc='" + nfc + '\'' +
                ", otg='" + otg + '\'' +
                ", radio='" + radio + '\'' +
                ", gps='" + gps + '\'' +
                ", usb='" + usb + '\'' +
                ", sensors='" + sensors + '\'' +
                ", colors='" + colors + '\'' +
                ", dimensions='" + dimensions + '\'' +
                ", photo='" + photo + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}