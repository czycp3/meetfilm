package com.stylefeng.guns.rest.modular.film.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.stylefeng.guns.rest.modular.film.bean.resultvo.ResponseVo;
import com.stylefeng.guns.rest.modular.film.service.IndexService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author czy
 * @date 2019/6/3 20:37
 */
@RestController
public class IndexController {

    @Reference
    private IndexService indexService;

    @RequestMapping("/film/getIndex")
    public ResponseVo getIndex() {
        return indexService.getIndex();
    }
}
