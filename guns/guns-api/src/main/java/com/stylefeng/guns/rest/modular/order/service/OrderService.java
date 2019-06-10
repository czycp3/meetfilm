package com.stylefeng.guns.rest.modular.order.service;

import com.stylefeng.guns.rest.modular.cinema.bean.BaseResultVo;
import com.stylefeng.guns.rest.modular.order.bean.OrderBaseVo;
import com.stylefeng.guns.rest.modular.order.bean.OrderVo;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: zero
 * @Date: 2019/6/8 20:24
 * @Version 1.0
 */
public interface OrderService {
    /**
     *
     * @param orderVo 购票信息参数fieldId、soldSeats、seatsName
     * @return 订票电影的信息,用于生成用户下单购票支付的二维码
     */
    OrderBaseVo buyTickets(OrderVo orderVo);

    /**
     *
     * @param orderVo 查询页面参数 nowPage、pageSize
     * @return  当前页面的登录用户的购票电影信息
     */
    OrderBaseVo getOrderInfo(OrderVo orderVo, String username);

    /**
     * 查询已购的座位号
     */
    String getOrderSeatNumber(String cinemaId,String fieldId);
}


