package com.stylefeng.guns.rest.modular.film.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.stylefeng.guns.core.exception.ServiceException;
import com.stylefeng.guns.rest.modular.film.bean.MtimeFilmT;


import com.stylefeng.guns.rest.modular.film.bean.RequestVo.FilmRequestVo;
import com.stylefeng.guns.rest.modular.film.bean.film.ConditionParam;
import com.stylefeng.guns.rest.modular.film.bean.resultvo.FilmConditionVo;
import com.stylefeng.guns.rest.modular.film.bean.resultvo.FilmInfoResponseVo;
import com.stylefeng.guns.rest.modular.film.bean.resultvo.FilmResponseVo;
import com.stylefeng.guns.rest.modular.film.service.FilmService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping("/film/getConditionList")
    public FilmConditionVo getConditionList( ConditionParam conditionParam) throws ServiceException {
        FilmConditionVo conditionVo = filmService.getConditionList(conditionParam);
        Logger logger = Logger.getLogger(this.getClass());
        logger.info(conditionVo);
        return conditionVo;
    }

    //多条件查询影片
    @RequestMapping("/film/getFilms")
    public FilmResponseVo getFilms(FilmRequestVo filmRequestVo){
        FilmResponseVo filmResponseVo = filmService.getFilms(filmRequestVo);
        return filmResponseVo;
    }

    //影片详情查询
    @RequestMapping("/film/films/{searchType}")
    public FilmInfoResponseVo getFilmInfo(@PathVariable("searchType") int searchType){
        FilmInfoResponseVo filmInfoResponseVo = filmService.getFilmInfo(searchType);
        return filmInfoResponseVo;
    }
}
