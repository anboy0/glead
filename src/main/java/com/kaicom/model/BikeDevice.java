package com.kaicom.model;

import java.util.Date;

public class BikeDevice extends BikeDeviceKey {
    private String apn;

    private String ip;

    private Integer port;

    private Short uploadInterval;

    private Short lockCanUpload;

    private Short lockUploadInterval;

    private Byte gsonserEnable;

    private Byte gsonserWakeupUploadEnable;

    private String led;

    private Integer unlockTimes;

    private Short lockStatus;

    private Integer gsmVersion;

    private Integer btVersion;

    private Byte chargeStatus;

    private String btKey;

    private String btPwd;

    private Short province;

    private Short city;

    private Byte type;

    private String btMac;

    private String iccid;

    private Date regTime;

    private Byte isReg;

    private Byte status;

    private Date uploadTime;

    private Double lat;

    private Double lng;

    private Byte batVol;

    private Byte configChanged;

    private String tel;

    private Short lastCharge;

    private Integer groupId;

    public String getApn() {
        return apn;
    }

    public void setApn(String apn) {
        this.apn = apn == null ? null : apn.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Short getUploadInterval() {
        return uploadInterval;
    }

    public void setUploadInterval(Short uploadInterval) {
        this.uploadInterval = uploadInterval;
    }

    public Short getLockCanUpload() {
        return lockCanUpload;
    }

    public void setLockCanUpload(Short lockCanUpload) {
        this.lockCanUpload = lockCanUpload;
    }

    public Short getLockUploadInterval() {
        return lockUploadInterval;
    }

    public void setLockUploadInterval(Short lockUploadInterval) {
        this.lockUploadInterval = lockUploadInterval;
    }

    public Byte getGsonserEnable() {
        return gsonserEnable;
    }

    public void setGsonserEnable(Byte gsonserEnable) {
        this.gsonserEnable = gsonserEnable;
    }

    public Byte getGsonserWakeupUploadEnable() {
        return gsonserWakeupUploadEnable;
    }

    public void setGsonserWakeupUploadEnable(Byte gsonserWakeupUploadEnable) {
        this.gsonserWakeupUploadEnable = gsonserWakeupUploadEnable;
    }

    public String getLed() {
        return led;
    }

    public void setLed(String led) {
        this.led = led == null ? null : led.trim();
    }

    public Integer getUnlockTimes() {
        return unlockTimes;
    }

    public void setUnlockTimes(Integer unlockTimes) {
        this.unlockTimes = unlockTimes;
    }

    public Short getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(Short lockStatus) {
        this.lockStatus = lockStatus;
    }

    public Integer getGsmVersion() {
        return gsmVersion;
    }

    public void setGsmVersion(Integer gsmVersion) {
        this.gsmVersion = gsmVersion;
    }

    public Integer getBtVersion() {
        return btVersion;
    }

    public void setBtVersion(Integer btVersion) {
        this.btVersion = btVersion;
    }

    public Byte getChargeStatus() {
        return chargeStatus;
    }

    public void setChargeStatus(Byte chargeStatus) {
        this.chargeStatus = chargeStatus;
    }

    public String getBtKey() {
        return btKey;
    }

    public void setBtKey(String btKey) {
        this.btKey = btKey == null ? null : btKey.trim();
    }

    public String getBtPwd() {
        return btPwd;
    }

    public void setBtPwd(String btPwd) {
        this.btPwd = btPwd == null ? null : btPwd.trim();
    }

    public Short getProvince() {
        return province;
    }

    public void setProvince(Short province) {
        this.province = province;
    }

    public Short getCity() {
        return city;
    }

    public void setCity(Short city) {
        this.city = city;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getBtMac() {
        return btMac;
    }

    public void setBtMac(String btMac) {
        this.btMac = btMac == null ? null : btMac.trim();
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid == null ? null : iccid.trim();
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Byte getIsReg() {
        return isReg;
    }

    public void setIsReg(Byte isReg) {
        this.isReg = isReg;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Byte getBatVol() {
        return batVol;
    }

    public void setBatVol(Byte batVol) {
        this.batVol = batVol;
    }

    public Byte getConfigChanged() {
        return configChanged;
    }

    public void setConfigChanged(Byte configChanged) {
        this.configChanged = configChanged;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public Short getLastCharge() {
        return lastCharge;
    }

    public void setLastCharge(Short lastCharge) {
        this.lastCharge = lastCharge;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}