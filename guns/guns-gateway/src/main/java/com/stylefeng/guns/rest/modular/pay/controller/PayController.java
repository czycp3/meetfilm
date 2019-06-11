package com.stylefeng.guns.rest.modular.pay.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.modular.pay.bean.PayResultVo;
import com.stylefeng.guns.rest.modular.pay.bean.PayStatusVo;
import com.stylefeng.guns.rest.modular.pay.service.PayService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author czy
 * @date 2019/6/8 18:18
 */
@RestController
public class PayController {

    @Reference(check = false)
    PayService payService;

    @RequestMapping("/order/getPayInfo")
    public PayResultVo getPayInfo(String orderId){
        PayResultVo payInfo = payService.getPayInfo(orderId);
        return payInfo;
    }

    @RequestMapping("/order/getPayResult")
    public PayStatusVo getPayResult(String orderId, int tryNums){
        PayStatusVo payResult = payService.getPayResult(orderId, tryNums);
        return payResult;
    }
}
