package com.stylefeng.guns.rest.modular.cinema.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.core.exception.ServiceException;
import com.stylefeng.guns.rest.modular.cinema.bean.BaseResultVo;

import com.stylefeng.guns.rest.modular.cinema.bean.BaseVo;
import com.stylefeng.guns.rest.modular.cinema.bean.RequestVo;
import com.stylefeng.guns.rest.modular.cinema.service.IMtimeCinemaTService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stylefeng.guns.rest.modular.cinema.service.IMtimeFieldTService;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: zero
 * @Date: 2019/6/4 21:54
 * @Version 1.0
 */

@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Reference(check = false)
    IMtimeCinemaTService iMtimeCinemaTService;
    @Reference(check = false)
    IMtimeFieldTService iMtimeFieldTService;

    @GetMapping("/getCinemas")
    public BaseVo getCinemas(RequestVo requestVo) throws ServiceException {

        BaseVo baseVo = iMtimeCinemaTService.selectCinemaListByCondition(requestVo);
        return baseVo;
    }

    @GetMapping("/getCondition")
    public BaseResultVo getCondition(RequestVo requestVo) throws ServiceException{
        BaseResultVo baseResultVo = iMtimeCinemaTService.selectCinemaMsgByCondition(requestVo);
        return baseResultVo;
    }

    @RequestMapping("/getFields")
    public BaseResultVo  GetFileds(String cinemaId){
        BaseResultVo baseResultVo = iMtimeCinemaTService.GetFileds(cinemaId);
        return baseResultVo;
    }
    @PostMapping("/getFieldInfo")
    public BaseResultVo GetFieldInfo(String cinemaId,String fieldId){
        BaseResultVo baseResultVo=iMtimeFieldTService.GetFieldInfo(cinemaId,fieldId);

        return baseResultVo;
    }
}
