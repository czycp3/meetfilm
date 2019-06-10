package com.stylefeng.guns.rest.modular.pay.bean;

import java.io.Serializable;

/**
 * @author czy
 * @date 2019/6/8 22:30
 */
public class PayStatusInfo implements Serializable {
    private String orderId;
    private int orderStatus;
    private String orderMsg;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderMsg() {
        return orderMsg;
    }

    public void setOrderMsg(String orderMsg) {
        this.orderMsg = orderMsg;
    }

    @Override
    public String toString() {
        return "PayStatusInfo{" +
                "orderId='" + orderId + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderMsg='" + orderMsg + '\'' +
                '}';
    }
}
