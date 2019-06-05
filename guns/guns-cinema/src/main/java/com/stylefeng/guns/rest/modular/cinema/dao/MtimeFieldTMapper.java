package com.stylefeng.guns.rest.modular.cinema.dao;

import com.stylefeng.guns.rest.modular.cinema.bean.Data;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 放映场次表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-04
 */
public interface MtimeFieldTMapper  {

    Data GetFieldInfoByCinemaIdAndFieldId(@Param("cinemaId") String cinemaId,@Param("fieldId") String fieldId);
}
