package com.stylefeng.guns.rest.modular.order.bean;

import java.io.Serializable;

/**
 * 订单模块接口的请求参数
 * @Author: zero
 * @Date: 2019/6/8 20:27
 * @Version 1.0
 */
public class OrderVo implements Serializable {
    /**
     * 场次编号
     */
    Integer fieldId;
    /**
     * 购买座位编号
     */
    String soldSeats;
    /**
     * 购买座位的名称
     */
    String seatsName;
    /**
     * 当前页
     */
    Integer nowPage=1;
    /**
     * 每页多少条
     */
    Integer pageSize=5;

    public OrderVo() {
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public String getSoldSeats() {
        return soldSeats;
    }

    public void setSoldSeats(String soldSeats) {
        this.soldSeats = soldSeats;
    }

    public String getSeatsName() {
        return seatsName;
    }

    public void setSeatsName(String seatsName) {
        this.seatsName = seatsName;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
