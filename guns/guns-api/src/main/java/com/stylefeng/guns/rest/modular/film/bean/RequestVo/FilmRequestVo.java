package com.stylefeng.guns.rest.modular.film.bean.RequestVo;

import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

public class FilmRequestVo implements Serializable {
    private int showType = 1;
    private int sortId = 1;
    private int catId = 99;
    private int sourceId = 99;
    private int yearId = 99;
    private int nowPage = 1;
    private int pageSize = 18;
    private int offset;

    public int getOffset() {
        return (nowPage - 1)*pageSize;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getShowType() {
        return showType;
    }

    public void setShowType(int showType) {
        this.showType = showType;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
        this.yearId = yearId;
    }
}
