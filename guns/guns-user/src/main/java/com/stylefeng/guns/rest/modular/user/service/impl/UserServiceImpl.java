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

    /**
     * 注册
     * @param user
     * @return
     */
    @Override
    public int register(MtimeUserT user) {


        //MtimeUserT userT = mtimeUserTMapper.selectOne(user);
        MtimeUserT userT = mtimeUserTMapper.selectByUsername(user.getUsername());

        try {
            if (userT != null){
                return 0;
            }else {
                //return mtimeUserTMapper.insertAllColumn(user);
                return mtimeUserTMapper.register(user);
            }
        }catch (RuntimeException e){
            return -1;
        }

    }

    /**
     * 验证用户名是否重复
     * @param user
     * @return
     */
    @Override
    public int check(MtimeUserT user) {

        try {
            //MtimeUserT userT = mtimeUserTMapper.selectOne(user);
            MtimeUserT userT = mtimeUserTMapper.selectByUsername(user.getUsername());
            if (userT == null){
                return 0;
            }else{
                return 1;
            }
        } catch (RuntimeException e){
            return -1;
        }

    }

    /**
     * 根据用户名查找密码
     * @param username
     * @return
     */
    @Override
    public MtimeUserT selectPswByUsername(String username) {
        return mtimeUserTMapper.selectPswByUsername(username);
    }


}
