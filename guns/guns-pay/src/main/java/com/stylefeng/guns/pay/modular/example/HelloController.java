package com.stylefeng.guns.pay.modular.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author czy
 * @date 2019/6/4 14:41
 */
@RestController
public class HelloController {

    @RequestMapping("/test")
    public String test(){
        return "ok";
    }
}
