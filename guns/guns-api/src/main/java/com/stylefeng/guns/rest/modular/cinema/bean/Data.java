package com.stylefeng.guns.rest.modular.cinema.bean;


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
}
