package com.stylefeng.guns.rest.modular.user;

import com.stylefeng.guns.rest.modular.user.been.MtimeUserT;
import com.stylefeng.guns.rest.modular.user.service.UserService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stylefeng.guns.rest.modular.user.been.ResponseUtil;

/**
 * @auther 芮狼Dan
 * @date 2019-06-05 17:31
 */;
@RestController
public class UserController {
    @Reference
    UserService userService;
    @Reference
    ResponseUtil responseUtil;

    @RequestMapping("/user/register")
    public Object register(MtimeUserT user){

        int i = userService.register(user);

        if (i == 1){
            return responseUtil.register(0,"注册成功");
        }else if (i == 2){
            return responseUtil.register(1,"用户已存在");
        }else {
            return responseUtil.register(999,"用户已存在");
        }


    }
}

