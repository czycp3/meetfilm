package com.stylefeng.guns.rest.modular.order.bean;

import java.io.Serializable;
import java.math.BigDecimal;

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
     * 订单座位号id
     */
    String seatsIds;
    /**
     * 座位号名字
     */
    String seatsName;
    /**
     * 电影票单价
     */
    BigDecimal ticketPrice;
    /**
     * 订单的电影票总价格
     */
    BigDecimal orderPrice;
    /**
     * 订单完成状态
     * 0-待支付,1-已支付,2-已关闭
     */
    String orderStatus;
    /**
     * 订单时间戳
     */
    String orderTimestamp;
    /**
     * 影厅名
     */
    String hallName;

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    /**
     * 电影图片地址
     */
    String src;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = "http://czycp3.oss-cn-shanghai.aliyuncs.com/"+src;
    }

    public OrderMsgData() {
    }

    public String getSeatsIds() {
        return seatsIds;
    }

    public void setSeatsIds(String seatsIds) {
        this.seatsIds = seatsIds;
    }

    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
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
        this.seatsName = seatsName.replace(","," ");
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus ="0".equals(orderStatus)?"待支付":("1".equals(orderStatus)?"已支付":"已关闭");
    }

    public String getOrderTimestamp() {
        return orderTimestamp==null?"0":orderTimestamp;
    }

    public void setOrderTimestamp(String orderTimestamp) {
        this.orderTimestamp = orderTimestamp;
    }
}
