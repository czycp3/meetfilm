package com.stylefeng.guns.rest.modular.user.mapper;

import com.stylefeng.guns.rest.modular.user.been.MtimeUserT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author dan
 * @since 2019-06-06
 */
public interface MtimeUserTMapper extends BaseMapper<MtimeUserT> {



    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    MtimeUserT selectByUsername(@Param("username") String username);

    /**
     * 注册
     * @param user
     * @return
     */
    int register(@Param("user") MtimeUserT user);

    /**
     * 根据用户名查找密码
     * @param username
     * @return
     */
    MtimeUserT selectPswByUsername(String username);




}
