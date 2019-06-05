package com.stylefeng.guns.rest.modular.cinema.bean;

<<<<<<< HEAD
import java.io.Serializable;

/**
 * @Author: zero
 * @Date: 2019/6/4 22:01
 * @Version 1.0
 */
public class BaseResultVo implements Serializable {
    Integer status;
    Data data;
    Integer nowPage;
    Integer totalPage;
=======

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
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e

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

<<<<<<< HEAD
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
=======
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
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
    }
}
