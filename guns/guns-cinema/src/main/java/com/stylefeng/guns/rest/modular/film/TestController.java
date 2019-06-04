package com.stylefeng.guns.rest.modular.film;

import com.stylefeng.guns.rest.modular.film.bean.MtimeFilmT;
import com.stylefeng.guns.rest.modular.film.service.IMtimeFilmTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author czy
 * @date 2019/6/4 16:41
 */
@RestController
public class TestController {

    @Autowired
    IMtimeFilmTService iMtimeFilmTService;

    @RequestMapping("/getFilm")
    public MtimeFilmT getFilm(int id){
        return iMtimeFilmTService.selectById(id);
    }
}
