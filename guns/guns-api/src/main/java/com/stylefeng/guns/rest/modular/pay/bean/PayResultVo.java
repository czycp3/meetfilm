package com.stylefeng.guns.rest.modular.pay.bean;

import java.io.Serializable;

/**
 * @author czy
 * @date 2019/6/8 18:22
 */
public class PayResultVo implements Serializable {
    private int status;
    private String imgPre;
    private PayInfo data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }

    public PayInfo getData() {
        return data;
    }

    public void setData(PayInfo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PayResultVo{" +
                "status=" + status +
                ", imgPre='" + imgPre + '\'' +
                ", data=" + data +
                '}';
    }
}
