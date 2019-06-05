package com.stylefeng.guns.rest.modular.film.mapper;

import com.stylefeng.guns.rest.modular.film.bean.MtimeFilmT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.Category;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.FilmYear;
import com.stylefeng.guns.rest.modular.film.bean.dictionary.Source;

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

}
