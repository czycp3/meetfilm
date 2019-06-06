package com.stylefeng.guns.rest.modular.film.mapper;

import com.stylefeng.guns.rest.modular.film.bean.MtimeFilmT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.Category;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.FilmYear;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.Source;
import com.stylefeng.guns.rest.modular.film.bean.film.Film;
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

}
