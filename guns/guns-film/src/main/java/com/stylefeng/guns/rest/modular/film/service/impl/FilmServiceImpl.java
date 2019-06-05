package com.stylefeng.guns.rest.modular.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.modular.film.bean.MtimeFilmT;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.Category;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.FilmYear;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.Source;
import com.stylefeng.guns.rest.modular.film.bean.film.ConditionParam;
import com.stylefeng.guns.rest.modular.film.bean.resultvo.ConditionData;
import com.stylefeng.guns.rest.modular.film.bean.resultvo.FilmConditionVo;
import com.stylefeng.guns.rest.modular.film.mapper.MtimeFilmTMapper;
import com.stylefeng.guns.rest.modular.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author czy
 * @date 2019/6/4 17:13
 */
@Service(interfaceClass = FilmService.class)
@Component
public class FilmServiceImpl implements FilmService{

    @Autowired
    MtimeFilmTMapper mtimeFilmTMapper;

    @Override
    public MtimeFilmT getFilmById(int id) {
        return mtimeFilmTMapper.selectById(id);
    }

    @Override
    public FilmConditionVo getConditionList(ConditionParam conditionParam) {
        String catId = conditionParam.getCatId() == null ? "99" : conditionParam.getCatId();
        String sourceId = conditionParam.getSourceId() == null ? "99" : conditionParam.getSourceId();
        String yearId = conditionParam.getYearId() == null ? "99" : conditionParam.getYearId();
        List<Category> catList =  mtimeFilmTMapper.queryFilmByCat(catId);
        List<Source> sourceList =  mtimeFilmTMapper.queryFilmBySource(sourceId);
        List<FilmYear> yearList =  mtimeFilmTMapper.queryFilmByYear(yearId);

        FilmConditionVo filmConditionVo = new FilmConditionVo();
        ConditionData conditionData = new ConditionData();

        conditionData.setCatInfo(catList);
        conditionData.setSourceInfo(sourceList);
        conditionData.setYearInfo(yearList);

        filmConditionVo.setStatus(0);
        filmConditionVo.setData(conditionData);
        return filmConditionVo;
    }
}
