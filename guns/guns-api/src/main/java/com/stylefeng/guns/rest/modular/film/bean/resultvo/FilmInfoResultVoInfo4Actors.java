package com.stylefeng.guns.rest.modular.film.bean.resultvo;

import com.stylefeng.guns.rest.modular.film.bean.film.Actor;
import com.stylefeng.guns.rest.modular.film.bean.film.Director;

import java.io.Serializable;

public class FilmInfoResultVoInfo4Actors implements Serializable {
    private Director director;
    private Actor actors;

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Actor getActors() {
        return actors;
    }

    public void setActors(Actor actors) {
        this.actors = actors;
    }
}
