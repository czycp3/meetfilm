package com.stylefeng.guns.rest.modular.cinema.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.core.exception.ServiceException;
import com.stylefeng.guns.rest.modular.cinema.bean.BaseResultVo;
import com.stylefeng.guns.rest.modular.cinema.bean.Data;
import com.stylefeng.guns.rest.modular.cinema.bean.MtimeHallDictT;
import com.stylefeng.guns.rest.modular.cinema.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.modular.cinema.service.IMtimeFieldTService;
import com.stylefeng.guns.rest.modular.order.service.OrderService;
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
    @Reference(check = false)
    OrderService orderService;
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
        data = mtimeFieldTMapper.GetFieldInfoByCinemaIdAndFieldId(cinemaId,fieldId);
        if (data==null){
        throw new ServiceException( 1,"影院信息查询失败");
        }
        MtimeHallDictT hallInfo = data.getHallInfo();
        String orderSeatNumber = orderService.getOrderSeatNumber(cinemaId, fieldId);
        hallInfo.setSoldSeats(orderSeatNumber);
        baseResultVo.setData(data);
        baseResultVo.setStatus(0);
        baseResultVo.setImgPre("http://czycp3.oss-cn-shanghai.aliyuncs.com/");
        return baseResultVo;
    }
}
