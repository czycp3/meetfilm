package com.stylefeng.guns.rest.modular.order.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.core.exception.ServiceException;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.cinema.bean.BaseResultVo;
import com.stylefeng.guns.rest.modular.order.bean.OrderBaseVo;
import com.stylefeng.guns.rest.modular.order.bean.OrderMsgData;
import com.stylefeng.guns.rest.modular.order.bean.OrderVo;
import com.stylefeng.guns.rest.modular.order.mapper.OrderMapper;
import com.stylefeng.guns.rest.modular.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zero
 * @Date: 2019/6/8 21:00
 * @Version 1.0
 */
@Service
@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Override
    public OrderBaseVo buyTickets(OrderVo orderVo) {
        return null;
    }

    @Override
    public OrderBaseVo getOrderInfo(OrderVo orderVo, String username) {
        OrderBaseVo orderBaseVo = new OrderBaseVo();
        OrderMsgData[] data=null;
        try {
            data = orderMapper.getOrderInfo(username,(orderVo.getNowPage()-1)*orderVo.getPageSize(),orderVo.getPageSize());
        } catch (Exception e) {
            throw new ServiceException(999,"系统出现异常，请联系管理员");
        }
        if (data==null||data.length<1){
            throw new ServiceException(1,"订单列表为空哦！~");
        }
        int length = data.length;
        while (length>0){
            length --;
            String fieldTime = data[length].getFieldTime();
            String[] s = fieldTime.split(" ");
            data[length].setFieldTime(s[0]+" "+s[2]);
        }
        orderBaseVo.setStatus(0);
        orderBaseVo.setData(data);
        return orderBaseVo;
    }

    @Override
    public String getOrderSeatNumber(String cinemaId, String fieldId) {
        String seatNumber = orderMapper.getOrderSeatNumber(cinemaId,fieldId);
        return seatNumber;
    }
}
