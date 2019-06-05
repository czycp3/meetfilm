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


}
