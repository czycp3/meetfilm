package com.stylefeng.guns.rest.modular.user.service;

import com.stylefeng.guns.rest.modular.user.been.MtimeUserT;

/**
 * @auther 芮狼Dan
 * @date 2019-06-05 17:18
 */
public interface MtimeUserService {

    //注册
    int register(MtimeUserT user);

    //检查用户名是否重复
    int check(MtimeUserT user);
}
