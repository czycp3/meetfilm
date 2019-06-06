package com.stylefeng.guns.rest.modular.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.modular.user.been.MtimeUserT;
import com.stylefeng.guns.rest.modular.user.mapper.MtimeUserTMapper;
import com.stylefeng.guns.rest.modular.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auther 芮狼Dan
 * @date 2019-06-05 20:31
 */
@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService{
    @Autowired
    MtimeUserTMapper mtimeUserTMapper;

    @Override
    public int register(MtimeUserT user) {
        int i = 0;

        try {
            mtimeUserTMapper.register(user);
            i = 1;
        }catch (Exception e){
            i = 2;
        }

        return i;
    }




}
