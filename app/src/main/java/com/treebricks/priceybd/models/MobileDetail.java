package com.treebricks.priceybd.models;
import com.google.gson.annotations.SerializedName;


/**
 * Created by fahim on 8/29/16.
 */

public class MobileDetail {

    @SerializedName("MobileID")
    public String mobileID;
    
    @SerializedName("Brand")
    public String brand;
    
    @SerializedName("ModelName")
    public String modelName;

    @SerializedName("NetTechnology")
    public String netTechnology;
    
    @SerializedName("2GBands")
    public String _2GBands;
    
    @SerializedName("3GBands")
    public String _3GBands;
    
    @SerializedName("4GBands")
    public String _4GBands;
    
    @SerializedName("Speed")
    public String speed;

    @SerializedName("GPRS")
    public String gPRS;

    @SerializedName("EDGE")
    public String eDGE;

    @SerializedName("Announced")
    public String announced;

    @SerializedName("Status")
    public String status;

    @SerializedName("BodyDimensions")
    public String bodyDimensions;

    @SerializedName("BodyWeight")
    public String bodyWeight;

    @SerializedName("SimType")
    public String simType;

    @SerializedName("BodyFeatures")
    public String bodyFeatures;

    @SerializedName("DisplayType")
    public String displayType;

    @SerializedName("DisplaySize")
    public String displaySize;

    @SerializedName("DisplayResolution")
    public String displayResolution;

    @SerializedName("DisplayProtection")
    public String displayProtection;

    @SerializedName("DisplayFeatures")
    public String displayFeatures;

    @SerializedName("Os")
    public String os;

    @SerializedName("Chipset")
    public String chipset;

    @SerializedName("CpuType")
    public String cpuType;

    @SerializedName("Gpu")
    public String gpu;

    @SerializedName("MemoryRam")
    public String memoryRam;

    @SerializedName("MemoryOption")
    public String memoryOption;

    @SerializedName("MemoryExpand")
    public String memoryExpand;

    @SerializedName("PrimaryCameraFeatures")
    public String primaryCameraFeatures;

    @SerializedName("Video")
    public String video;

    @SerializedName("SecondaryCameraFeatures")
    public String secondaryCameraFeatures;

    @SerializedName("CameraFeatures")
    public String cameraFeatures;

    @SerializedName("SoundAlertTypes")
    public String soundAlertTypes;

    @SerializedName("SoundLoudspeaker")
    public String soundLoudspeaker;

    @SerializedName("SoundJack")
    public String soundJack;

    @SerializedName("SoundFeatures")
    public String soundFeatures;

    @SerializedName("Wifi")
    public String wifi;

    @SerializedName("Bluetooth")
    public String bluetooth;

    @SerializedName("Gps")
    public String gps;

    @SerializedName("Nfc")
    public String nfc;

    @SerializedName("Radio")
    public String radio;

    @SerializedName("Usb")
    public String usb;

    @SerializedName("Sensors")
    public String sensors;

    @SerializedName("Messaging")
    public String messaging;

    @SerializedName("Browser")
    public String browser;

    @SerializedName("Java")
    public String mJava;

    @SerializedName("OtherFeatures")
    public String otherFeatures;

    @SerializedName("BatteryType")
    public String batteryType;

    @SerializedName("BatteryCapacity")
    public String batteryCapacity;

    @SerializedName("BatteryTalktime")
    public String batteryTalktime;

    @SerializedName("BatteryMusicplay")
    public String batteryMusicplay;

    @SerializedName("Colors")
    public String colors;

    @SerializedName("Performance")
    public String performance;

    @SerializedName("Photo")
    public String photo;

    public MobileDetail() {
    }

    public MobileDetail(String mobileID, String brand, String modelName, String netTechnology,
                        String _2GBands, String _3GBands, String _4GBands, String speed, String gPRS,
                        String eDGE, String announced, String status, String bodyDimensions,
                        String bodyWeight, String simType, String bodyFeatures, String displayType,
                        String displaySize, String displayResolution, String displayProtection,
                        String displayFeatures, String os, String chipset, String cpuType, String gpu,
                        String memoryRam, String memoryOption, String memoryExpand, String primaryCameraFeatures,
                        String video, String secondaryCameraFeatures, String cameraFeatures, String soundAlertTypes,
                        String soundLoudspeaker, String soundJack, String soundFeatures, String wifi, String bluetooth,
                        String gps, String nfc, String radio, String usb, String sensors, String messaging,
                        String browser, String mJava, String otherFeatures, String batteryType,
                        String batteryCapacity, String batteryTalktime, String batteryMusicplay,
                        String colors, String performance, String photo) {
        this.mobileID = mobileID;
        this.brand = brand;
        this.modelName = modelName;
        this.netTechnology = netTechnology;
        this._2GBands = _2GBands;
        this._3GBands = _3GBands;
        this._4GBands = _4GBands;
        this.speed = speed;
        this.gPRS = gPRS;
        this.eDGE = eDGE;
        this.announced = announced;
        this.status = status;
        this.bodyDimensions = bodyDimensions;
        this.bodyWeight = bodyWeight;
        this.simType = simType;
        this.bodyFeatures = bodyFeatures;
        this.displayType = displayType;
        this.displaySize = displaySize;
        this.displayResolution = displayResolution;
        this.displayProtection = displayProtection;
        this.displayFeatures = displayFeatures;
        this.os = os;
        this.chipset = chipset;
        this.cpuType = cpuType;
        this.gpu = gpu;
        this.memoryRam = memoryRam;
        this.memoryOption = memoryOption;
        this.memoryExpand = memoryExpand;
        this.primaryCameraFeatures = primaryCameraFeatures;
        this.video = video;
        this.secondaryCameraFeatures = secondaryCameraFeatures;
        this.cameraFeatures = cameraFeatures;
        this.soundAlertTypes = soundAlertTypes;
        this.soundLoudspeaker = soundLoudspeaker;
        this.soundJack = soundJack;
        this.soundFeatures = soundFeatures;
        this.wifi = wifi;
        this.bluetooth = bluetooth;
        this.gps = gps;
        this.nfc = nfc;
        this.radio = radio;
        this.usb = usb;
        this.sensors = sensors;
        this.messaging = messaging;
        this.browser = browser;
        this.mJava = mJava;
        this.otherFeatures = otherFeatures;
        this.batteryType = batteryType;
        this.batteryCapacity = batteryCapacity;
        this.batteryTalktime = batteryTalktime;
        this.batteryMusicplay = batteryMusicplay;
        this.colors = colors;
        this.performance = performance;
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

    public String getNetTechnology() {
        return netTechnology;
    }

    public void setNetTechnology(String netTechnology) {
        this.netTechnology = netTechnology;
    }

    public String get_2GBands() {
        return _2GBands;
    }

    public void set_2GBands(String _2GBands) {
        this._2GBands = _2GBands;
    }

    public String get_3GBands() {
        return _3GBands;
    }

    public void set_3GBands(String _3GBands) {
        this._3GBands = _3GBands;
    }

    public String get_4GBands() {
        return _4GBands;
    }

    public void set_4GBands(String _4GBands) {
        this._4GBands = _4GBands;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getgPRS() {
        return gPRS;
    }

    public void setgPRS(String gPRS) {
        this.gPRS = gPRS;
    }

    public String geteDGE() {
        return eDGE;
    }

    public void seteDGE(String eDGE) {
        this.eDGE = eDGE;
    }

    public String getAnnounced() {
        return announced;
    }

    public void setAnnounced(String announced) {
        this.announced = announced;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBodyDimensions() {
        return bodyDimensions;
    }

    public void setBodyDimensions(String bodyDimensions) {
        this.bodyDimensions = bodyDimensions;
    }

    public String getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(String bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public String getSimType() {
        return simType;
    }

    public void setSimType(String simType) {
        this.simType = simType;
    }

    public String getBodyFeatures() {
        return bodyFeatures;
    }

    public void setBodyFeatures(String bodyFeatures) {
        this.bodyFeatures = bodyFeatures;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
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

    public String getDisplayProtection() {
        return displayProtection;
    }

    public void setDisplayProtection(String displayProtection) {
        this.displayProtection = displayProtection;
    }

    public String getDisplayFeatures() {
        return displayFeatures;
    }

    public void setDisplayFeatures(String displayFeatures) {
        this.displayFeatures = displayFeatures;
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

    public String getCpuType() {
        return cpuType;
    }

    public void setCpuType(String cpuType) {
        this.cpuType = cpuType;
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

    public String getMemoryOption() {
        return memoryOption;
    }

    public void setMemoryOption(String memoryOption) {
        this.memoryOption = memoryOption;
    }

    public String getMemoryExpand() {
        return memoryExpand;
    }

    public void setMemoryExpand(String memoryExpand) {
        this.memoryExpand = memoryExpand;
    }

    public String getPrimaryCameraFeatures() {
        return primaryCameraFeatures;
    }

    public void setPrimaryCameraFeatures(String primaryCameraFeatures) {
        this.primaryCameraFeatures = primaryCameraFeatures;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getSecondaryCameraFeatures() {
        return secondaryCameraFeatures;
    }

    public void setSecondaryCameraFeatures(String secondaryCameraFeatures) {
        this.secondaryCameraFeatures = secondaryCameraFeatures;
    }

    public String getCameraFeatures() {
        return cameraFeatures;
    }

    public void setCameraFeatures(String cameraFeatures) {
        this.cameraFeatures = cameraFeatures;
    }

    public String getSoundAlertTypes() {
        return soundAlertTypes;
    }

    public void setSoundAlertTypes(String soundAlertTypes) {
        this.soundAlertTypes = soundAlertTypes;
    }

    public String getSoundLoudspeaker() {
        return soundLoudspeaker;
    }

    public void setSoundLoudspeaker(String soundLoudspeaker) {
        this.soundLoudspeaker = soundLoudspeaker;
    }

    public String getSoundJack() {
        return soundJack;
    }

    public void setSoundJack(String soundJack) {
        this.soundJack = soundJack;
    }

    public String getSoundFeatures() {
        return soundFeatures;
    }

    public void setSoundFeatures(String soundFeatures) {
        this.soundFeatures = soundFeatures;
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public String getNfc() {
        return nfc;
    }

    public void setNfc(String nfc) {
        this.nfc = nfc;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
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

    public String getMessaging() {
        return messaging;
    }

    public void setMessaging(String messaging) {
        this.messaging = messaging;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getmJava() {
        return mJava;
    }

    public void setmJava(String mJava) {
        this.mJava = mJava;
    }

    public String getOtherFeatures() {
        return otherFeatures;
    }

    public void setOtherFeatures(String otherFeatures) {
        this.otherFeatures = otherFeatures;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getBatteryTalktime() {
        return batteryTalktime;
    }

    public void setBatteryTalktime(String batteryTalktime) {
        this.batteryTalktime = batteryTalktime;
    }

    public String getBatteryMusicplay() {
        return batteryMusicplay;
    }

    public void setBatteryMusicplay(String batteryMusicplay) {
        this.batteryMusicplay = batteryMusicplay;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}