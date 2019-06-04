package com.stylefeng.guns.rest.modular.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.modular.film.bean.banner.Banner;
import com.stylefeng.guns.rest.modular.film.bean.film.Film;
import com.stylefeng.guns.rest.modular.film.bean.film.Films;
import com.stylefeng.guns.rest.modular.film.bean.resultvo.IndexData;
import com.stylefeng.guns.rest.modular.film.bean.resultvo.ResponseVo;
import com.stylefeng.guns.rest.modular.film.mapper.IndexMapper;
import com.stylefeng.guns.rest.modular.film.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author czy
 * @date 2019/6/3 20:40
 */
@Service(interfaceClass = IndexService.class)
@Component
public class IndexServiceImpl implements IndexService {
    private IndexMapper indexMapper;
    private ResponseVo responseVo;
    private IndexData indexData;

    @Autowired
    public IndexServiceImpl(IndexMapper indexMapper, ResponseVo responseVo, IndexData indexData) {
        this.indexMapper = indexMapper;
        this.responseVo = responseVo;
        this.indexData = indexData;
    }

    @Override
    public ResponseVo getIndex() {
        //查询主页banner信息
        List<Banner> bannerList;
        try {
            bannerList = indexMapper.queryBanners();
        }catch (Exception e){
            responseVo.setStatus(1);
            responseVo.setMsg("查询失败,无banner可加载");
            return responseVo;
        }
        //查询主页hotFilms信息
        List<Film> hotFilmList = indexMapper.queryFilms(1,null);
        int countHotFilm = indexMapper.queryCountFilm(1);
        Films hotFilms = new Films();
        hotFilms.setFilmNum(countHotFilm);
        hotFilms.setFilmInfo(hotFilmList);

        //查询主页soonFilms信息
        List<Film> soonFilmList = indexMapper.queryFilms(2,null);
        int countSoonFilm = indexMapper.queryCountFilm(2);
        Films soonFilms = new Films();
        soonFilms.setFilmNum(countSoonFilm);
        soonFilms.setFilmInfo(soonFilmList);

        //查询主页boxRanking信息
        List<Film> boxRankingList = indexMapper.queryFilms(1,"film_box_office");

        //查询主页expectRanking信息
        List<Film> expectRankingList = indexMapper.queryFilms(0,"expect_num");

        //查询主页top100信息
        List<Film> top100List = indexMapper.queryFilms(0,"film_score");

        //封装indexData
        indexData.setBanners(bannerList);
        indexData.setHotFilms(hotFilms);
        indexData.setSoonFilms(soonFilms);
        indexData.setBoxRanking(boxRankingList);
        indexData.setExpectRanking(expectRankingList);
        indexData.setTop100(top100List);

        //封装responseVo
        responseVo.setData(indexData);
        responseVo.setStatus(0);
        responseVo.setImgPre("http://img.meetingshop.cn/");
        return responseVo;
    }
}
