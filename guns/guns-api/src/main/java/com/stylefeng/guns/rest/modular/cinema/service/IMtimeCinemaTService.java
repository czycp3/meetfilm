package com.stylefeng.guns.rest.modular.cinema.service;

import com.stylefeng.guns.rest.modular.cinema.bean.BaseResultVo;
import com.stylefeng.guns.rest.modular.cinema.bean.RequestVo;


/**
 * <p>
 * 影院信息表 服务类
 * </p>
 *
<<<<<<< HEAD
 * @author CR
 * @since 2019-06-04
 */
public interface IMtimeCinemaTService{
    /**
     *
     * @param requestVo 查询参数: brandId、hallType、districtId、pageSize、nowPage
     * @return  返回按上述参数条件查询的所有影院信息
     */
    BaseResultVo selectCinemaListByCondition(RequestVo requestVo);

    /**
     *
     * @param requestVo 查询参数: brandId、hallType、areaId
     * @return 返回按上述参数条件查询的具体影院信息
     */
    BaseResultVo selectCinemaMsgByCondition(RequestVo requestVo);

    /**
     *
     * @param cinemaId
     * @return
     */
    BaseResultVo GetFileds(String cinemaId);


}
