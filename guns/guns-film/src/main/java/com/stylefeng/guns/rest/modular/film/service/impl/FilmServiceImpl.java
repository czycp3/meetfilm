package com.stylefeng.guns.rest.modular.film.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.core.exception.ServiceException;
import com.stylefeng.guns.rest.modular.film.bean.MtimeFilmT;
import com.stylefeng.guns.rest.modular.film.bean.RequestVo.FilmRequestVo;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.Category;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.FilmYear;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.Source;
import com.stylefeng.guns.rest.modular.film.bean.film.Actor;
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
    public FilmConditionVo getConditionList(ConditionParam conditionParam){
        FilmConditionVo filmConditionVo = new FilmConditionVo();
        ConditionData conditionData = new ConditionData();
        try {
            String catId = conditionParam.getCatId() == null ? "99" : conditionParam.getCatId();
            String sourceId = conditionParam.getSourceId() == null ? "99" : conditionParam.getSourceId();
            String yearId = conditionParam.getYearId() == null ? "99" : conditionParam.getYearId();
            List<Category> catList = mtimeFilmTMapper.queryFilmByCat(catId);
            if(catList.size() == 1){
                catList.get(0).setIsActive(true);
            }else {
                for (Category category : catList) {
                    if(category.getCatId() == 99) {
                        category.setIsActive(true);
                        break;
                    }
                }
            }
            List<Source> sourceList = mtimeFilmTMapper.queryFilmBySource(sourceId);
            if(sourceList.size() == 1){
                sourceList.get(0).setIsActive(true);
            }else {
                for (Source source : sourceList) {
                    if(source.getSourceId() == 99) {
                        source.setIsActive(true);
                        break;
                    }
                }
            }
            List<FilmYear> yearList = mtimeFilmTMapper.queryFilmByYear(yearId);
            if(yearList.size() == 1){
                yearList.get(0).setIsActive(true);
            }else {
                for (FilmYear filmYear : yearList) {
                    if(filmYear.getYearId() == 99) {
                        filmYear.setIsActive(true);
                        break;
                    }
                }
            }

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

        catId = oldCatId + "";
        try {
            //查询正在热映的影片
            if (showType == 1) {
                films = mtimeFilmTMapper.getHotFilms(catId, sortId, sourceId, yearId, pageSize, offset);
                totalPage = mtimeFilmTMapper.countHotFilms(catId, sortId, sourceId, yearId, pageSize, offset);
            }
            //查询即将上映的影片
            else if (showType == 2) {
                films = mtimeFilmTMapper.getSoonFilms(catId, sortId, sourceId, yearId, pageSize, offset);
                totalPage = mtimeFilmTMapper.countSoonFilms(catId, sortId, sourceId, yearId, pageSize, offset);
            }
            //查询经典影片
            else if (showType == 3) {
                films = mtimeFilmTMapper.getClassicFilms(catId, sortId, sourceId, yearId, pageSize, offset);
                totalPage = mtimeFilmTMapper.countClassicFilms(catId, sortId, sourceId, yearId, pageSize, offset);
            }
        }catch (Exception e){
            throw new ServiceException(1,"查询失败，无banner可加载");
        }
        filmResponseVo.setData(films);
        filmResponseVo.setTotalPage(totalPage);
        filmResponseVo.setStatus(0);
        filmResponseVo.setImgPre("http://img.meetingshop.cn/");
        filmResponseVo.setNowPage(nowPage);
        return filmResponseVo;
    }

    @Override
    public FilmInfoResponseVo getFilmInfo(String name,String searchType) {
        FilmInfoResponseVo filmInfoResponseVo = new FilmInfoResponseVo();
        FilmInfoResultVo filmInfoResultVo;
        FilmInfoResultVoInfo4 filmInfoResultVoInfo4 = new FilmInfoResultVoInfo4();
        FilmInfoResultVoInfo4Actors filmInfoResultVoInfo4Actors = new FilmInfoResultVoInfo4Actors();
        FilmInfoResultVoImgVo filmInfoResultVoImgVo = new FilmInfoResultVoImgVo();

        try {
            //第一部分
            filmInfoResultVo = mtimeFilmTMapper.getFilmInfo(name, searchType);
            filmInfoResultVo.setScoreNum(filmInfoResultVo.getScoreNum() + "万人评分");
            String totalBox = filmInfoResultVo.getTotalBox();
            double newtotalBox = Double.parseDouble(totalBox) / 10000;
            filmInfoResultVo.setTotalBox(newtotalBox + "万");

            //第二部分
            StringBuffer sb = new StringBuffer("");
            String cats = mtimeFilmTMapper.getInfo1(name, searchType);
            String[] catsArr = cats.split("#");
            for (int i = 1; i < catsArr.length; i++) {
                Integer catId = Integer.valueOf(catsArr[i]);
                String cat = mtimeFilmTMapper.getCatById(catId);
                sb.append(cat);
                while (i != catsArr.length - 1) {
                    sb.append(",");
                    break;
                }
            }
            filmInfoResultVo.setInfo01(String.valueOf(sb));

            StringBuffer sb2 = new StringBuffer("");
            String s2 = mtimeFilmTMapper.getSource(name, searchType);
            sb2.append(s2 + ",");
            int timeLength = mtimeFilmTMapper.getTime(name, searchType);
            sb2.append(timeLength + "分钟");
            filmInfoResultVo.setInfo02(String.valueOf(sb2));

            StringBuffer sb3 = new StringBuffer("");
            String s3 = mtimeFilmTMapper.getFilmTime(name, searchType);
            s3.substring(0, 11);
            sb3.append(s3);
            sb3.append(" " + s2 + "上映");
            filmInfoResultVo.setInfo03(String.valueOf(sb3));

            String imgStr = mtimeFilmTMapper.getfilmImgs(name, searchType);
            String[] imgsplit = imgStr.split(",");
            filmInfoResultVoImgVo.setMainImg(imgsplit[0]);
            filmInfoResultVoImgVo.setImg01(imgsplit[1]);
            filmInfoResultVoImgVo.setImg02(imgsplit[2]);
            filmInfoResultVoImgVo.setImg03(imgsplit[3]);
            filmInfoResultVoImgVo.setImg04(imgsplit[4]);
            filmInfoResultVo.setImgVO(filmInfoResultVoImgVo);

            String s4 = mtimeFilmTMapper.getBiography(name, searchType);
            filmInfoResultVoInfo4.setBiography(s4);
            List<Actor> actors = mtimeFilmTMapper.getActors(name, searchType);
            filmInfoResultVoInfo4Actors.setActors(actors);
            filmInfoResultVoInfo4.setActors(filmInfoResultVoInfo4Actors);
            filmInfoResultVoInfo4.setImgVO(filmInfoResultVoImgVo);
            filmInfoResultVo.setInfo04(filmInfoResultVoInfo4);
        }catch (Exception e){
            throw new ServiceException(1,"查询失败，无影片可加载");
        }

        filmInfoResponseVo.setStatus(0);
        filmInfoResponseVo.setImgPre("http://img.meetingshop.cn/");
        filmInfoResponseVo.setData(filmInfoResultVo);
        return filmInfoResponseVo;
    }

}
