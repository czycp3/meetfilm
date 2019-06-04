package com.stylefeng.guns.rest.modular.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.modular.film.bean.MtimeFilmT;
import com.stylefeng.guns.rest.modular.film.mapper.MtimeFilmTMapper;
import com.stylefeng.guns.rest.modular.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
