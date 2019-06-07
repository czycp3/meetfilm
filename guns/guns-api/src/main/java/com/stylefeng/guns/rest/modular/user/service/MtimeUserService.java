package com.stylefeng.guns.rest.modular.user.service;

import com.stylefeng.guns.rest.modular.user.been.MtimeUserT;

/**
 * @auther 芮狼Dan
 * @date 2019-06-05 17:18
 */
public interface MtimeUserService {

    /**
     * 注册
     * @param user
     * @return
     */
    int register(MtimeUserT user);


    /**
     * 检查用户名是否重复
     * @param user
     * @return
     */
    int check(MtimeUserT user);

    /**
     * 根据用户名查找密码
     * @param username
     * @return
     */
    MtimeUserT selectPswByUsername(String username);

    /**
     * 根据用户名查询信息
     * @param username
     * @return
     */
    MtimeUserT getUserInfoByUsername(String username);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int updateUserInfo(MtimeUserT user);


    /**
     * 根据uuid查询信息
     * @param uuid
     * @return
     */
    MtimeUserT getUserInfoByUuid(Integer uuid);
}
