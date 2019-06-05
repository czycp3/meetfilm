package com.stylefeng.guns.rest.modular.cinema.service;

import com.stylefeng.guns.rest.modular.cinema.bean.BaseResultVo;

/**
 * <p>
 * 放映场次表 服务类
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-04
 */
public interface IMtimeFieldTService  {

    BaseResultVo GetFieldInfo(String cinemaId, String fieldId);
}
