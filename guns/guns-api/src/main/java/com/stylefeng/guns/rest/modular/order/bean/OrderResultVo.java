package com.stylefeng.guns.rest.modular.order.bean;

import java.io.Serializable;

/**
 * @Author: zero
 * @Date: 2019/6/10 19:46
 * @Version 1.0
 */
public class OrderResultVo implements Serializable {
    /**
     * 订单状态码，前端使用
     */
    Integer status;
    /**
     * 查询订单的返回信息
     */
    String msg;
    /**
     * 订单信息集合
     */
    OrderMsgData data;

    public OrderResultVo() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public OrderMsgData getData() {
        return data;
    }

    public void setData(OrderMsgData data) {
        this.data = data;
    }
}
