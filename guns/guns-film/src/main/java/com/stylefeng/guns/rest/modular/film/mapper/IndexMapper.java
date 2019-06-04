package com.stylefeng.guns.rest.modular.film.mapper;


import com.stylefeng.guns.rest.modular.film.bean.banner.Banner;
import com.stylefeng.guns.rest.modular.film.bean.film.Film;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author czy
 * @date 2019/6/3 20:41
 */
public interface IndexMapper {
    /**
     * 查询主页的banner列表
     * @return List<Banner>
     */
    List<Banner> queryBanners();

    /**
     * 查询主页状态为status的电影
     * @param status 1为热映，2为即将上映，3为经典影片
     * @param order 排序方式
     * @return List<Film>
     */
    List<Film> queryFilms(@Param("status") int status,@Param("order") String order);

    /**
     * 查询不同status电影总数
     * @param status
     * @return int
     */
    int queryCountFilm(@Param("status") int status);
}
