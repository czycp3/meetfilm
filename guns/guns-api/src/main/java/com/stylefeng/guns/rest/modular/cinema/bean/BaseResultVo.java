package com.stylefeng.guns.rest.modular.cinema.bean;


import java.io.Serializable;

public class BaseResultVo implements Serializable {
    private Integer status;
    private Data data;
    private String imgPre;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }

    @Override
    public String toString() {
        return "BaseResultVo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", imgPre='" + imgPre + '\'' +
                '}';
    }
}
