package com.stylefeng.guns.rest.modular.film.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.film.bean.MtimeFilmT;
import com.stylefeng.guns.rest.modular.film.service.FilmService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author czy
 * @date 2019/6/4 17:11
 */
@RestController
public class FilmController {

    @Reference
    FilmService filmService;

    @RequestMapping("/getFilmById")
    MtimeFilmT getFilmById(int id){
       return filmService.getFilmById(id);
    }
}
