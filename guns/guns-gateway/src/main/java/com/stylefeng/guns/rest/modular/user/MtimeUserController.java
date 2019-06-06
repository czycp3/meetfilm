package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;

import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.modular.user.been.MtimeUserT;
import com.stylefeng.guns.rest.modular.user.been.ResponseUtil;
import com.stylefeng.guns.rest.modular.user.service.MtimeUserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @auther 芮狼Dan
 * @date 2019-06-05 17:31
 */

@RestController
public class MtimeUserController {
    @Reference
    MtimeUserService mtimeUserService;

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("/user/register")
    public Object register(MtimeUserT user){
        String psw = user.getPassword();
        psw = MD5Util.encrypt(psw);
        user.setPassword(psw);

        int i = mtimeUserService.register(user);

        if (i == 1){
            return ResponseUtil.responseVo(0,"注册成功");
        }else if (i == 0){
            return ResponseUtil.responseVo(1,"用户已存在");
        }else {
            return ResponseUtil.responseVo(999,"系统出现异常，请联系管理员");
        }


    }


    /**
     * 检查用户名是否重复
     * @param user
     * @return
     */
    @RequestMapping("/user/check")
    public Object check(MtimeUserT user){
        int i = mtimeUserService.check(user);

        if (i == 0){
            return ResponseUtil.responseVo(0,"验证成功");
        }else if (i == 1){
            return ResponseUtil.responseVo(1,"用户已存在");
        }else{
            return ResponseUtil.responseVo(999,"系统出现异常，请联系管理员");
        }
    }




}
