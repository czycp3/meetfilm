package com.stylefeng.guns.rest.modular.cinema.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.cinema.bean.BaseResultVo;
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

@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Reference
    IMtimeCinemaTService iMtimeCinemaTService;

    @GetMapping("/getCinemas")
    public BaseResultVo getCinemas(RequestVo requestVo){
        BaseResultVo baseResultVo = iMtimeCinemaTService.selectCinemaListByCondition(requestVo);
        return baseResultVo;
    }

    @GetMapping("/getCondition")
    public BaseResultVo getCondition(RequestVo requestVo){
        BaseResultVo baseResultVo = iMtimeCinemaTService.selectCinemaMsgByCondition(requestVo);
        return baseResultVo;
    }
}
