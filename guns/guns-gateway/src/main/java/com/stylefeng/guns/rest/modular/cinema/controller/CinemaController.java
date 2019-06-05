package com.stylefeng.guns.rest.modular.cinema.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.cinema.bean.BaseResultVo;
import com.stylefeng.guns.rest.modular.cinema.service.IMtimeCinemaTService;
import com.stylefeng.guns.rest.modular.cinema.service.IMtimeFieldTService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Reference
    IMtimeCinemaTService iMtimeCinemaTService;
    @Reference
    IMtimeFieldTService iMtimeFieldTService;
    @RequestMapping("/getFileds")
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
