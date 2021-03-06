package com.stylefeng.guns.rest.modular.cinema.dao;


import com.stylefeng.guns.rest.modular.cinema.bean.*;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;




/**
 * <p>
 * 影院信息表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-04
 */

public interface MtimeCinemaTMapper extends BaseMapper<MtimeCinemaT> {

    List<MtimeCinemaT> selectCinemaListByCondition(@Param("requestVo") RequestVo requestVo);

    List<MtimeBrandDictT> selectBrandListById(@Param("brandId") Integer brandId);

    List<MtimeAreaDictT> selectAreaListById(@Param("areaId") Integer areaId);

    List<MtimeHallDictT> selectHalltypeListById(@Param("halltypeId") Integer hallTypeId);

    List<MtimeHallFilmInfoT> selectDataFilmListByCinemaId(@Param("cinemaId") Integer i);

    MtimeCinemaT selectDataCinemaInfoByCinemaId(@Param("cinemaId") Integer i);

}
