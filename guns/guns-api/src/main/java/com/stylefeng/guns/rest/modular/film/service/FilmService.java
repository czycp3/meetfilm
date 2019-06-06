package com.stylefeng.guns.rest.modular.film.service;

import com.stylefeng.guns.core.exception.ServiceException;
import com.stylefeng.guns.rest.modular.film.bean.MtimeFilmT;
import com.stylefeng.guns.rest.modular.film.bean.RequestVo.FilmRequestVo;
import com.stylefeng.guns.rest.modular.film.bean.film.ConditionParam;
import com.stylefeng.guns.rest.modular.film.bean.resultvo.FilmConditionVo;
import com.stylefeng.guns.rest.modular.film.bean.resultvo.FilmInfoResponseVo;
import com.stylefeng.guns.rest.modular.film.bean.resultvo.FilmResponseVo;

/**
 * @author czy
 * @date 2019/6/4 17:09
 */
public interface FilmService {
    /**
     * 测试
     * @param id 影片ID
     * @return MtimeFilmT
     */
    MtimeFilmT getFilmById(int id);

    /**
     * 影片条件列表查询接口
     * @param  conditionParam catId,sourceId,yearId
     * @return FilmConditionVo
     */
    FilmConditionVo getConditionList(ConditionParam conditionParam) throws ServiceException;

    /**
     * 影片查询接口
     * @param filmRequestVo
     * @return
     */
    FilmResponseVo getFilms(FilmRequestVo filmRequestVo);

    /**
     * 影片详情查询接口
     * @param searchType
     * @return
     */
    FilmInfoResponseVo getFilmInfo(int searchType);
}
