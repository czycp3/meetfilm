package com.stylefeng.guns.rest.modular.pay.bean;

import java.io.Serializable;

/**
 * @author czy
 * @date 2019/6/8 22:31
 */
public class PayStatusVo implements Serializable {
    private int status;
    private PayStatusInfo data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public PayStatusInfo getData() {
        return data;
    }

    public void setData(PayStatusInfo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PayStatusVo{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
