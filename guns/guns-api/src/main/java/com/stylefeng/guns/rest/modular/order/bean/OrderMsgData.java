package com.stylefeng.guns.rest.modular.order.bean;

import java.io.Serializable;

/**
 * 订单详细信息
 * @Author: zero
 * @Date: 2019/6/8 21:11
 * @Version 1.0
 */
public class OrderMsgData implements Serializable {
    /**
     * 订单ID
     */
    String orderId;
    /**
     * 电影片名
     */
    String filmName;
    /**
     * 电影播放时间
     */
    String fieldTime;
    /**
     * 影院名称（含地区）
     */
    String cinemaName;
    /**
     * 座位号
     */
    String seatsName;
    /**
     * 订单的电影票总价格
     */
    String orderPrice;
    /**
     * 订单完成状态
     */
    String orderStatus;
    /**
     * 处理订单时间标记
     */
    String orderTimestamp;

    public OrderMsgData() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFieldTime() {
        return fieldTime;
    }

    public void setFieldTime(String fieldTime) {
        this.fieldTime = fieldTime;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getSeatsName() {
        return seatsName;
    }

    public void setSeatsName(String seatsName) {
        this.seatsName = seatsName;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderTimestamp() {
        return orderTimestamp;
    }

    public void setOrderTimestamp(String orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }
}
