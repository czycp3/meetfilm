package com.stylefeng.guns.rest.modular.cinema.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.cinema.bean.BaseResultVo;
<<<<<<< HEAD
import com.stylefeng.guns.rest.modular.cinema.bean.RequestVo;
import com.stylefeng.guns.rest.modular.cinema.service.IMtimeCinemaTService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zero
 * @Date: 2019/6/4 21:54
 * @Version 1.0
 */

=======
import com.stylefeng.guns.rest.modular.cinema.service.IMtimeCinemaTService;
import com.stylefeng.guns.rest.modular.cinema.service.IMtimeFieldTService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Reference
    IMtimeCinemaTService iMtimeCinemaTService;
<<<<<<< HEAD

    @GetMapping("/getCinemas")
    public BaseResultVo getCinemas(RequestVo requestVo){
        BaseResultVo baseResultVo = iMtimeCinemaTService.selectCinemaListByCondition(requestVo);
        return baseResultVo;
    }

    @GetMapping("/getCondition")
    public BaseResultVo getCondition(RequestVo requestVo){
        BaseResultVo baseResultVo = iMtimeCinemaTService.selectCinemaMsgByCondition(requestVo);
=======
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
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
        return baseResultVo;
    }
}
