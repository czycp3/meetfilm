package com.stylefeng.guns.rest.modular.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.core.exception.ServiceException;
import com.stylefeng.guns.rest.modular.film.bean.MtimeFilmT;
import com.stylefeng.guns.rest.modular.film.bean.RequestVo.FilmRequestVo;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.Category;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.FilmYear;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.Source;
import com.stylefeng.guns.rest.modular.film.bean.film.ConditionParam;
import com.stylefeng.guns.rest.modular.film.bean.film.Film;
import com.stylefeng.guns.rest.modular.film.bean.resultvo.*;
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
    public FilmConditionVo getConditionList(ConditionParam conditionParam) throws ServiceException{
        FilmConditionVo filmConditionVo = new FilmConditionVo();
        ConditionData conditionData = new ConditionData();
        try {
            String catId = conditionParam.getCatId() == null ? "99" : conditionParam.getCatId();
            String sourceId = conditionParam.getSourceId() == null ? "99" : conditionParam.getSourceId();
            String yearId = conditionParam.getYearId() == null ? "99" : conditionParam.getYearId();
            List<Category> catList = mtimeFilmTMapper.queryFilmByCat(catId);
            List<Source> sourceList = mtimeFilmTMapper.queryFilmBySource(sourceId);
            List<FilmYear> yearList = mtimeFilmTMapper.queryFilmByYear(yearId);

            conditionData.setCatInfo(catList);
            conditionData.setSourceInfo(sourceList);
            conditionData.setYearInfo(yearList);

            filmConditionVo.setStatus(0);
            filmConditionVo.setData(conditionData);

        }catch (Exception e){
            throw new ServiceException(1,"查询失败，无条件可加载");
        }
        return filmConditionVo;
    }

    @Override
    public FilmResponseVo getFilms(FilmRequestVo filmRequestVo) {
        FilmResponseVo filmResponseVo = new FilmResponseVo();
        List<Film> films = null;
        int totalPage = 0;
        String catId;
        //获取请求参数
        int showType = filmRequestVo.getShowType();
        int oldCatId = filmRequestVo.getCatId();
        int nowPage = filmRequestVo.getNowPage();
        int pageSize = filmRequestVo.getPageSize();
        int offset = filmRequestVo.getOffset();
        int sortId = filmRequestVo.getSortId();
        int sourceId = filmRequestVo.getSourceId();
        int yearId = filmRequestVo.getYearId();
        if (oldCatId != 99){
            catId = "%#" + oldCatId +"#%";
        }
        catId = oldCatId + "";

        //查询正在热映的影片
        if (showType== 1){
            films = mtimeFilmTMapper.getHotFilms(catId,sortId,sourceId,yearId,pageSize,offset);
            totalPage = mtimeFilmTMapper.countHotFilms(catId,sortId,sourceId,yearId,pageSize,offset);
        }
        //查询即将上映的影片
        else if (showType== 2){
            films = mtimeFilmTMapper.getSoonFilms(catId,sortId,sourceId,yearId,pageSize,offset);
            totalPage = mtimeFilmTMapper.countSoonFilms(catId,sortId,sourceId,yearId,pageSize,offset);
        }
        //查询经典影片
        else if (showType == 3){
            films = mtimeFilmTMapper.getClassicFilms(catId,sortId,sourceId,yearId,pageSize,offset);
            totalPage = mtimeFilmTMapper.countClassicFilms(catId,sortId,sourceId,yearId,pageSize,offset);
        }
        filmResponseVo.setData(films);
        filmResponseVo.setTotalPage(totalPage);
        filmResponseVo.setStatus(0);
        filmResponseVo.setImgPre("http://img.meetingshop.cn/");
        filmResponseVo.setNowPage(nowPage);
        return filmResponseVo;
    }

    @Override
    public FilmInfoResponseVo getFilmInfo(int searchType) {
        FilmInfoResponseVo filmInfoResponseVo = new FilmInfoResponseVo();
        FilmInfoResultVo filmInfoResultVo = new FilmInfoResultVo();
        FilmInfoResultVoInfo4 filmInfoResultVoInfo4 = new FilmInfoResultVoInfo4();
        FilmInfoResultVoInfo4Actors filmInfoResultVoInfo4Actors = new FilmInfoResultVoInfo4Actors();
        FilmInfoResultVoImgVo filmInfoResultVoImgVo = new FilmInfoResultVoImgVo();

        filmInfoResultVoInfo4Actors.setActors(null);
        filmInfoResultVoInfo4Actors.setDirector(null);

        filmInfoResultVoInfo4.setActors(filmInfoResultVoInfo4Actors);
        filmInfoResultVoInfo4.setBiography(null);

        filmInfoResultVo.setFilmName(null);
        filmInfoResultVo.setFilmEnName(null);
        filmInfoResultVo.setImgAddress(null);
        filmInfoResultVo.setScore(null);
        filmInfoResultVo.setScoreNum(null);
        filmInfoResultVo.setTotalBox(null);
        filmInfoResultVo.setInfo01(null);
        filmInfoResultVo.setInfo02(null);
        filmInfoResultVo.setInfo03(null);
        filmInfoResultVo.setInfo04(filmInfoResultVoInfo4);
        filmInfoResultVo.setFilmId(0);
        filmInfoResultVo.setImgVo(filmInfoResultVoImgVo);

        filmInfoResponseVo.setStatus(0);
        filmInfoResponseVo.setImgPre("http://img.meetingshop.cn/");
        filmInfoResponseVo.setData(filmInfoResultVo);
        return filmInfoResponseVo;
    }

}
