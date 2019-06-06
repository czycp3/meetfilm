package com.stylefeng.guns.rest.modular.film.bean.resultvo;

import java.io.Serializable;

/**
 * 影片详情查询返回结果
 */
public class FilmInfoResponseVo implements Serializable {
    private int status;
    private String imgPre;
    private FilmInfoResultVo data;

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

    public FilmInfoResultVo getData() {
        return data;
    }

    public void setData(FilmInfoResultVo data) {
        this.data = data;
    }
}
