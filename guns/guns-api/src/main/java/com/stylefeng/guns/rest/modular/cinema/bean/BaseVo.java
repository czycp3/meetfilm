package com.stylefeng.guns.rest.modular.cinema.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/6/8 11:00
 * @Version 1.0
 */
public class BaseVo implements Serializable {
    Integer status = 0;
    List<MtimeCinemaT> data;
    Integer nowPage;
    Integer totalPage;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<MtimeCinemaT> getData() {
        return data;
    }

    public void setData(List<MtimeCinemaT> data) {
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
}
