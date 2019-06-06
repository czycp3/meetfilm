package com.stylefeng.guns.rest.modular.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.user.been.MtimeUserT;
import com.stylefeng.guns.rest.modular.user.been.ResponseUtil;
import com.stylefeng.guns.rest.modular.user.service.MtimeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther 芮狼Dan
 * @date 2019-06-06 18:21
 */
@RestController
public class MtimeUserController {



        @Autowired
        MtimeUserService mtimeUserService;

        @RequestMapping("/user/register")
        public Object register(MtimeUserT user){

            int i = mtimeUserService.register(user);

            if (i == 1){
                return ResponseUtil.responseVo(0,"注册成功");
            }else if (i == 0){
                return ResponseUtil.responseVo(1,"用户已存在");
            }else {
                return ResponseUtil.responseVo(999,"系统出现异常，请联系管理员");
            }


        }




}
