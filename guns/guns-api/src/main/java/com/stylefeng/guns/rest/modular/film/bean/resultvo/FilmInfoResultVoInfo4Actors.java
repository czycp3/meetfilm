package com.stylefeng.guns.rest.modular.film.bean.resultvo;

import com.stylefeng.guns.rest.modular.film.bean.film.Actor;
import com.stylefeng.guns.rest.modular.film.bean.film.Director;

import java.io.Serializable;
import java.util.List;

public class FilmInfoResultVoInfo4Actors implements Serializable {
    private Director director;
    private List<Actor> actors;

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
