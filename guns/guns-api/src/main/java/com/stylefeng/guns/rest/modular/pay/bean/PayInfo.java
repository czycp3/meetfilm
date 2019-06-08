package com.stylefeng.guns.rest.modular.pay.bean;

import java.io.Serializable;

/**
 * @author czy
 * @date 2019/6/8 18:24
 */
public class PayInfo implements Serializable {
    private String orderId;
    private String QRCodeAddress;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getQRCodeAddress() {
        return QRCodeAddress;
    }

    public void setQRCodeAddress(String QRCodeAddress) {
        this.QRCodeAddress = QRCodeAddress;
    }

    @Override
    public String toString() {
        return "PayInfo{" +
                "orderId='" + orderId + '\'' +
                ", QRCodeAddress='" + QRCodeAddress + '\'' +
                '}';
    }
}
