package com.stylefeng.guns.rest.modular.film.mapper;

import com.stylefeng.guns.rest.modular.film.bean.MtimeFilmT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.Category;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.FilmYear;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.Source;
import com.stylefeng.guns.rest.modular.film.bean.film.Actor;
import com.stylefeng.guns.rest.modular.film.bean.film.Film;
import com.stylefeng.guns.rest.modular.film.bean.resultvo.FilmInfoResponseVo;
import com.stylefeng.guns.rest.modular.film.bean.resultvo.FilmInfoResultVo;
import com.stylefeng.guns.rest.modular.film.bean.resultvo.FilmInfoResultVoInfo4;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author CZY
 * @since 2019-06-04
 */
public interface MtimeFilmTMapper extends BaseMapper<MtimeFilmT> {

    /**
     * 按分类ID查询
     * @param catId 分类ID
     * @return List<Category>
     */
    List<Category> queryFilmByCat(String catId);

    /**
     * 按片源ID查询
     * @param sourceId 片源ID
     * @return List<Source>
     */
    List<Source> queryFilmBySource(String sourceId);

    /**
     * 按年代ID查询
     * @param yearId 年代ID
     * @return List<FilmYear>
     */
    List<FilmYear> queryFilmByYear(String yearId);

    /**
     * 查询正在热映的影片
     * @param catId
     * @param sortId
     * @param sourceId
     * @param yearId
     * @param pageSize
     * @param offset
     * @return
     */
    List<Film> getHotFilms(@Param("catId") String catId, @Param("sortId")int sortId,@Param("sourceId") int sourceId, @Param("yearId")int yearId, @Param("pageSize")int pageSize, @Param("offset")int offset);
    int countHotFilms(@Param("catId") String catId, @Param("sortId")int sortId,@Param("sourceId") int sourceId, @Param("yearId")int yearId, @Param("pageSize")int pageSize, @Param("offset")int offset);

    /**
     * 查询即将上映的影片
     * @param catId
     * @param sortId
     * @param sourceId
     * @param yearId
     * @param pageSize
     * @param offset
     * @return
     */
    List<Film> getSoonFilms(@Param("catId") String catId, @Param("sortId")int sortId, @Param("sourceId") int sourceId, @Param("yearId")int yearId, @Param("pageSize")int pageSize, @Param("offset")int offset);
    int countSoonFilms(@Param("catId") String catId, @Param("sortId")int sortId,@Param("sourceId") int sourceId, @Param("yearId")int yearId, @Param("pageSize")int pageSize, @Param("offset")int offset);

    /**
     * 查询经典的影片
     * @param catId
     * @param sortId
     * @param sourceId
     * @param yearId
     * @param pageSize
     * @param offset
     * @return
     */
    List<Film> getClassicFilms(@Param("catId") String catId, @Param("sortId")int sortId,@Param("sourceId") int sourceId, @Param("yearId")int yearId, @Param("pageSize")int pageSize, @Param("offset")int offset);
    int countClassicFilms(@Param("catId") String catId, @Param("sortId")int sortId,@Param("sourceId") int sourceId, @Param("yearId")int yearId, @Param("pageSize")int pageSize, @Param("offset")int offset);

    /**
     * 获取第一部分 film Data
     * @param name
     * @param searchType
     * @return
     */
    FilmInfoResultVo getFilmInfo(@Param("name") String name, @Param("searchType") String searchType);

    /**
     * 获取第二部分 info1
     * @param name
     * @param searchType
     * @return
     */
    String getInfo1(@Param("name") String name,@Param("searchType") String searchType);

    /**
     * 根据Id查询分类名称
     * @param catId
     * @return
     */
    String getCatById(@Param("catId") Integer catId);

    /**
     * 获取当前影片的5张详细图片
     * @param name
     * @param searchType
     * @return
     */
    String getfilmImgs(@Param("name") String name,@Param("searchType") String searchType);

    /**
     * 获取影片来源
     * @param name
     * @param searchType
     * @return
     */
    String getSource(@Param("name") String name,@Param("searchType") String searchType);

    /**
     * 获取影片时长
     * @param name
     * @param searchType
     * @return
     */
    int getTime(@Param("name") String name,@Param("searchType") String searchType);

    /**
     * 获取影片上映时间
     * @param name
     * @param searchType
     * @return
     */
    String getFilmTime(@Param("name") String name,@Param("searchType") String searchType);

    /**
     * 获取影片的biography
     * @param name
     * @param searchType
     * @return
     */
    String getBiography(@Param("name") String name,@Param("searchType") String searchType);

    /**
     * 获取演员列表
     * @param name
     * @param searchType
     * @return
     */
    List<Actor> getActors(@Param("name") String name,@Param("searchType") String searchType);
}
