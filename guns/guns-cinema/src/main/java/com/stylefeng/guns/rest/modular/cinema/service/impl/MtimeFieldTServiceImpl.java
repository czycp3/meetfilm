package com.stylefeng.guns.rest.modular.cinema.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.modular.cinema.bean.BaseResultVo;
import com.stylefeng.guns.rest.modular.cinema.bean.Data;
import com.stylefeng.guns.rest.modular.cinema.bean.MtimeHallDictT;
import com.stylefeng.guns.rest.modular.cinema.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.modular.cinema.service.IMtimeFieldTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 放映场次表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-04
 */
@Service
@Component
public class MtimeFieldTServiceImpl implements IMtimeFieldTService {
    @Autowired
    MtimeFieldTMapper mtimeFieldTMapper;
    @Override
    public BaseResultVo GetFieldInfo(String cinemaId,String fieldId) {
        BaseResultVo baseResultVo = new BaseResultVo();
        try {
            int i = Integer.parseInt(cinemaId);
            int i1 = Integer.parseInt(fieldId);
        } catch (NumberFormatException e) {
            baseResultVo.setStatus(0);
            return baseResultVo;
        }
        Data data;
        try {
            data = mtimeFieldTMapper.GetFieldInfoByCinemaIdAndFieldId(cinemaId,fieldId);
        } catch (Exception e) {
            baseResultVo.setStatus(1);
            baseResultVo.setMsg("信息查询失败");
            return baseResultVo;
        }
        MtimeHallDictT hallInfo = data.getHallInfo();
        hallInfo.setSoldSeats("1,2,3,5,12");
        baseResultVo.setData(data);
        baseResultVo.setStatus(0);
        baseResultVo.setImgPre("http://img.meetingshop.cn/");
        return baseResultVo;
    }
}
