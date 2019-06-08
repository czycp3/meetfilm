package com.stylefeng.guns.rest.modular.pay.service;

import com.stylefeng.guns.rest.modular.pay.bean.PayResultVo;
import com.stylefeng.guns.rest.modular.pay.bean.PayStatusVo;

/**
 * @author czy
 * @date 2019/6/8 18:20
 */
public interface PayService {

    /**
     * 获取支付二维码
     * @param orderId 订单号
     * @return PayResultVo
     */
    PayResultVo getPayInfo(String orderId);

    /**
     * 查询支付状态
     * @param orderId 订单号
     * @param tryNums 尝试次数 3次以上超时
     * @return PayStatusVo
     */
    PayStatusVo getPayResult(String orderId,int tryNums);
}
