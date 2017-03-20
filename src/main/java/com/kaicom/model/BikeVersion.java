package com.kaicom.model;

import java.util.Date;

public class BikeVersion {
    private Integer id;

    private String vendorId;

    private String productId;

    private String gsmUrl;

    private String btUrl;

    private Date createTime;

    private Byte status;

    private Integer gsmVersion;

    private Integer btVersion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId == null ? null : vendorId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getGsmUrl() {
        return gsmUrl;
    }

    public void setGsmUrl(String gsmUrl) {
        this.gsmUrl = gsmUrl == null ? null : gsmUrl.trim();
    }

    public String getBtUrl() {
        return btUrl;
    }

    public void setBtUrl(String btUrl) {
        this.btUrl = btUrl == null ? null : btUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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
}