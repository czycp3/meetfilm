package com.stylefeng.guns.rest.modular.film.bean.resultvo;

import java.io.Serializable;

public class FilmInfoResultVoInfo4 implements Serializable {
    private String biography;
    private FilmInfoResultVoInfo4Actors actors;
    private FilmInfoResultVoImgVo imgVO;

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public FilmInfoResultVoInfo4Actors getActors() {
        return actors;
    }

    public void setActors(FilmInfoResultVoInfo4Actors actors) {
        this.actors = actors;
    }

    public FilmInfoResultVoImgVo getImgVO() {
        return imgVO;
    }

    public void setImgVO(FilmInfoResultVoImgVo imgVO) {
        this.imgVO = imgVO;
    }
}
