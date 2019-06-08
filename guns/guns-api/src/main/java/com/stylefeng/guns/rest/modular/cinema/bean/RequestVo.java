package com.stylefeng.guns.rest.modular.cinema.bean;

import java.io.Serializable;

/**
 * @Author: zero
 * @Date: 2019/6/4 22:30
 * @Version 1.0
 */
public class RequestVo implements Serializable {
    Integer brandId =99;
    Integer hallType =99;
    Integer districtId=99;
    Integer pageSize=12;
    Integer nowPage=1;
    Integer areaId=99;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

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

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public void setHallType(Integer hallType) {
        this.hallType = hallType;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public Integer getHallType() {
        return hallType;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
}
