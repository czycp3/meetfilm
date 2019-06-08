package com.stylefeng.guns.rest.modular.cinema.bean;

import java.io.Serializable;

/**
 * @Author: zero
 * @Date: 2019/6/4 22:01
 * @Version 1.0
 */
public class BaseResultVo implements Serializable {
    Integer status = 0;
    Data data;
    Integer nowPage;
    Integer totalPage;

    private String imgPre;
    private String msg;

    @Override
    public String toString() {
        return "BaseResultVo{" +
                "status=" + status +
                ", data=" + data +
                ", nowPage=" + nowPage +
                ", totalPage=" + totalPage +
                ", imgPre='" + imgPre + '\'' +
                ", msg='" + msg + '\'' +
                '}';
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

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
