package com.stylefeng.guns.rest.modular.order.bean;

import java.io.Serializable;

/**
 * 订单查询模块的返回信息
 * @Author: zero
 * @Date: 2019/6/8 21:10
 * @Version 1.0
 */
public class OrderBaseVo implements Serializable {
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
    OrderMsgData[] data;

    public OrderBaseVo() {
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

    public OrderMsgData[] getData() {
        return data;
    }

    public void setData(OrderMsgData[] data) {
        this.data = data;
    }
}
