package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;

import com.stylefeng.guns.core.exception.GunsException;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.common.exception.BizExceptionEnum;
import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthRequest;
import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthResponse;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.auth.validator.IReqValidator;
import com.stylefeng.guns.rest.modular.user.been.MtimeUserT;
import com.stylefeng.guns.rest.modular.user.been.ResponseUtil;
import com.stylefeng.guns.rest.modular.user.service.MtimeUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


/**
 * @auther 芮狼Dan
 * @date 2019-06-05 17:31
 */

@RestController
public class MtimeUserController {
    @Reference(check = false)
    MtimeUserService mtimeUserService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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


    /**
     * 登陆
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/auth")
    public Object createAuthenticationToken(String username,String password) {
        Jedis jedis = new Jedis();

        try {
            MtimeUserT userT = mtimeUserService.selectPswByUsername(username);
            String psw = userT.getPassword();
            password = MD5Util.encrypt(password);


            if (psw.equals(password)) {
                final String randomKey = jwtTokenUtil.getRandomKey();
                final String token = jwtTokenUtil.generateToken(username, randomKey);
                Map<String,String> data = new HashMap<>();
                data.put("randomKey",randomKey);
                data.put("token",token);
                jedis.set(username,token);

                return ResponseUtil.responseVo(0,data);
            } else {
                return ResponseUtil.responseVo(1,"用户名或密码错误");
            }
        } catch (Exception e){
            return ResponseUtil.responseVo(999,"系统出现异常，请联系管理员");
        }

    }



    @RequestMapping("/user/test")
    public Object test(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String username = jwtTokenUtil.getUsernameFromToken(token);

        Jedis jedis = new Jedis();
        return ResponseUtil.responseVo(0,jedis.get(username));
    }






}
