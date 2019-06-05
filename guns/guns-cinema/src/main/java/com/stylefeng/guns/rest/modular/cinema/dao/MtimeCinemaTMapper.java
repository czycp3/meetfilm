package com.stylefeng.guns.rest.modular.cinema.dao;

import com.stylefeng.guns.rest.modular.cinema.bean.MtimeCinemaT;
import com.stylefeng.guns.rest.modular.cinema.bean.MtimeHallFilmInfoT;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * <p>
 * 影院信息表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-04
 */
public interface MtimeCinemaTMapper  {

    ArrayList<MtimeHallFilmInfoT> selectDataFilmListByCinemaId(@Param("cinemaId") Integer i);
    MtimeCinemaT selectDataCinemaInfoByCinemaId(@Param("cinemaId") Integer i);
}
