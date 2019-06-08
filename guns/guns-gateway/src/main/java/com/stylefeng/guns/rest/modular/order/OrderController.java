package com.stylefeng.guns.rest.modular.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.cinema.bean.BaseResultVo;
import com.stylefeng.guns.rest.modular.order.bean.OrderVo;
import com.stylefeng.guns.rest.modular.order.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zero
 * @Date: 2019/6/8 20:22
 * @Version 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Reference(check = false)
    OrderService orderService;

    @RequestMapping("/buyTickets")
    public BaseResultVo buyTickets(OrderVo orderVo){
        return orderService.buyTickets(orderVo);
    }
    @RequestMapping("/getOrderInfo")
    public BaseResultVo getOrderInfo(OrderVo orderVo){
        return orderService.getOrderInfo(orderVo);
    }
}
