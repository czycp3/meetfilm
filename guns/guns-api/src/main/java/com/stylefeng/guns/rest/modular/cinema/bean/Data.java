package com.stylefeng.guns.rest.modular.cinema.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/6/4 22:03
 * @Version 1.0
 */
public class Data implements Serializable {
    List<MtimeCinemaT> cinemas;
    List<MtimeCinemaT> CinemasData;

    public List<MtimeCinemaT> getCinemasData() {
        return CinemasData;
    }

    public void setCinemasData(List<MtimeCinemaT> cinemasData) {
        CinemasData = cinemasData;
    }

    List<MtimeBrandDictT> brandList;
    List<MtimeAreaDictT> areaList;
    List<MtimeHallDictT> halltypeList;
    List<MtimeHallFilmInfoT> filmList;
    MtimeCinemaT cinemaInfo;
    MtimeHallFilmInfoT filmInfo;
    MtimeHallDictT hallInfo;

    public Data() {
    }

    public List<MtimeCinemaT> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<MtimeCinemaT> cinemas) {
        this.cinemas = cinemas;
    }

    public List<MtimeBrandDictT> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<MtimeBrandDictT> brandList) {
        this.brandList = brandList;
    }

    public List<MtimeAreaDictT> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<MtimeAreaDictT> areaList) {
        this.areaList = areaList;
    }

    public List<MtimeHallDictT> getHalltypeList() {
        return halltypeList;
    }

    public void setHalltypeList(List<MtimeHallDictT> halltypeList) {
        this.halltypeList = halltypeList;
    }

    public List<MtimeHallFilmInfoT> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<MtimeHallFilmInfoT> filmList) {
        this.filmList = filmList;
    }

    public MtimeCinemaT getCinemaInfo() {
        return cinemaInfo;
    }

    public void setCinemaInfo(MtimeCinemaT cinemaInfo) {
        this.cinemaInfo = cinemaInfo;
    }

    public MtimeHallFilmInfoT getFilmInfo() {
        return filmInfo;
    }

    public void setFilmInfo(MtimeHallFilmInfoT filmInfo) {
        this.filmInfo = filmInfo;
    }

    public MtimeHallDictT getHallInfo() {
        return hallInfo;
    }

    public void setHallInfo(MtimeHallDictT hallInfo) {
        this.hallInfo = hallInfo;
    }
}
