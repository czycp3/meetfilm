package com.stylefeng.guns.rest.modular.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.modular.user.been.MtimeUserT;
import com.stylefeng.guns.rest.modular.user.mapper.MtimeUserTMapper;
import com.stylefeng.guns.rest.modular.user.service.MtimeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @auther 芮狼Dan
 * @date 2019-06-05 20:31
 */
@Service(interfaceClass = MtimeUserService.class)
@Component
public class UserServiceImpl implements MtimeUserService {
    @Autowired
    MtimeUserTMapper mtimeUserTMapper;


    @Override
    public int register(MtimeUserT user) {
        MtimeUserT userT = mtimeUserTMapper.selectOne(user);

        try {
            if (userT != null){
                return 0;
            }else {
                return mtimeUserTMapper.insertAllColumn(user);
            }
        }catch (RuntimeException e){
            return -1;
        }

    }



}
