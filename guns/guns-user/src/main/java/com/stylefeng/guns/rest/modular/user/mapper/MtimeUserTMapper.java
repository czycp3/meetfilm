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

    //查询用户名是否重复
    MtimeUserT selectByUsername(@Param("username") String username);

    //注册
    int register(@Param("user") MtimeUserT user);

}
