package com.stylefeng.guns.rest.modular.cinema.bean;

<<<<<<< HEAD
import java.io.Serializable;
import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/6/4 22:03
 * @Version 1.0
 */
public class Data implements Serializable {
    List<MtimeCinemaT> cinemas;
    List<MtimeBrandDictT> mtimeBrandDictTList;
    List<MtimeAreaDictT> mtimeAreaDictTList;
    List<MtimeHallDictT> mtimeHallDictTList;

    public List<MtimeCinemaT> getCinemas() {
        return cinemas;
    }

    public void setCinemas(List<MtimeCinemaT> cinemas) {
        this.cinemas = cinemas;
    }

    public List<MtimeBrandDictT> getMtimeBrandDictTList() {
        return mtimeBrandDictTList;
    }

    public void setMtimeBrandDictTList(List<MtimeBrandDictT> mtimeBrandDictTList) {
        this.mtimeBrandDictTList = mtimeBrandDictTList;
    }

    public List<MtimeAreaDictT> getMtimeAreaDictTList() {
        return mtimeAreaDictTList;
    }

    public void setMtimeAreaDictTList(List<MtimeAreaDictT> mtimeAreaDictTList) {
        this.mtimeAreaDictTList = mtimeAreaDictTList;
    }

    public List<MtimeHallDictT> getMtimeHallDictTList() {
        return mtimeHallDictTList;
    }

    public void setMtimeHallDictTList(List<MtimeHallDictT> mtimeHallDictTList) {
        this.mtimeHallDictTList = mtimeHallDictTList;
    }



    public Data() {
    }


=======

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {
    List<MtimeHallFilmInfoT> filmList;
    MtimeCinemaT cinemaInfo;
    MtimeHallFilmInfoT filmInfo;
    MtimeHallDictT hallInfo;

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

    public MtimeCinemaT getCinemaInfo() {
        return cinemaInfo;
    }

    public void setCinemaInfo(MtimeCinemaT cinemaInfo) {
        this.cinemaInfo = cinemaInfo;
    }

    public List<MtimeHallFilmInfoT> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<MtimeHallFilmInfoT> filmList) {
        this.filmList = filmList;
    }

    @Override
    public String toString() {
        return "Data{" +
                "cinemaInfo=" + cinemaInfo +
                ", filmList=" + filmList +
                ", filmInfo=" + filmInfo +
                ", hallInfo=" + hallInfo +
                '}';
    }
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
}
