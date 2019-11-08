package com.kaicom.model;

import java.util.Date;

public class BikeLocation extends BikeLocationKey {
    private String deviceId;

    private Double lat;

    private Double lng;

    private Byte batVol;

    private Short alt;

    private Short speed;

    private Short course;

    private Date time;

    private Byte signalDb;

    private Byte gnss;

    private Byte lockStatus;

    private Byte uploadStatus;

    private Short mcc;

    private Short mnc;

    private String lac;

    private Integer btVersion;

    private Integer gsmVersion;

    private Date createTime;

    private String tel;

    private String alarm;

    private Integer gpsStatus;

    private Short cn;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
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

    public Short getAlt() {
        return alt;
    }

    public void setAlt(Short alt) {
        this.alt = alt;
    }

    public Short getSpeed() {
        return speed;
    }

    public void setSpeed(Short speed) {
        this.speed = speed;
    }

    public Short getCourse() {
        return course;
    }

    public void setCourse(Short course) {
        this.course = course;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Byte getSignalDb() {
        return signalDb;
    }

    public void setSignalDb(Byte signalDb) {
        this.signalDb = signalDb;
    }

    public Byte getGnss() {
        return gnss;
    }

    public void setGnss(Byte gnss) {
        this.gnss = gnss;
    }

    public Byte getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(Byte lockStatus) {
        this.lockStatus = lockStatus;
    }

    public Byte getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(Byte uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    public Short getMcc() {
        return mcc;
    }

    public void setMcc(Short mcc) {
        this.mcc = mcc;
    }

    public Short getMnc() {
        return mnc;
    }

    public void setMnc(Short mnc) {
        this.mnc = mnc;
    }

    public String getLac() {
        return lac;
    }

    public void setLac(String lac) {
        this.lac = lac == null ? null : lac.trim();
    }

    public Integer getBtVersion() {
        return btVersion;
    }

    public void setBtVersion(Integer btVersion) {
        this.btVersion = btVersion;
    }

    public Integer getGsmVersion() {
        return gsmVersion;
    }

    public void setGsmVersion(Integer gsmVersion) {
        this.gsmVersion = gsmVersion;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getAlarm() {
        return alarm;
    }

    public void setAlarm(String alarm) {
        this.alarm = alarm == null ? null : alarm.trim();
    }

    public int getGpsStatus() {
        return gpsStatus;
    }

    public void setGpsStatus(int gpsStatus) {
        this.gpsStatus = gpsStatus ;
    }

    public Short getCn() {
        return cn;
    }

    public void setCn(Short cn) {
        this.cn = cn;
    }
}