package com.stylefeng.guns.rest.modular.cinema.bean;

import java.io.Serializable;

/**
 * @Author: zero
 * @Date: 2019/6/4 22:30
 * @Version 1.0
 */
public class RequestVo implements Serializable {
    String brandId;
    String hallType;
    String districtId;
    String pageSize;
    Integer nowPage;
    String areaId;

    @Override
    public String toString() {
        return "RequestVo{" +
                "brandId='" + brandId + '\'' +
                ", hallType='" + hallType + '\'' +
                ", districtId='" + districtId + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", nowPage='" + nowPage + '\'' +
                '}';
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getHallType() {
        return hallType;
    }

    public void setHallType(String hallType) {
        this.hallType = hallType;
    }

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
}
