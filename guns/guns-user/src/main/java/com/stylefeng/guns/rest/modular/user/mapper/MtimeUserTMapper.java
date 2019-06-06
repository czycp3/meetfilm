package com.stylefeng.guns.rest.modular.user.mapper;

import com.stylefeng.guns.rest.modular.user.been.MtimeUserT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author dan
 * @since 2019-06-06
 */
public interface MtimeUserTMapper extends BaseMapper<MtimeUserT> {

    //注册
    void register(MtimeUserT user);
}
