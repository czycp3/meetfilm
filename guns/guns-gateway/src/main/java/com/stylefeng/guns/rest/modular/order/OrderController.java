package com.stylefeng.guns.rest.modular.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.cinema.bean.BaseResultVo;
import com.stylefeng.guns.rest.modular.order.bean.OrderBaseVo;
import com.stylefeng.guns.rest.modular.order.bean.OrderVo;
import com.stylefeng.guns.rest.modular.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @RequestMapping("/buyTickets")
    public OrderBaseVo buyTickets(OrderVo orderVo){
        return orderService.buyTickets(orderVo);
    }
    @RequestMapping("/getOrderInfo")
    public OrderBaseVo getOrderInfo(OrderVo orderVo, HttpServletRequest httpServletRequest){
        String authToken = httpServletRequest.getHeader("Authorization");
        authToken = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(authToken);
        return orderService.getOrderInfo(orderVo,username);
    }
}
