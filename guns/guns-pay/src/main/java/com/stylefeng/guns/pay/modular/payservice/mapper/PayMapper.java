package com.stylefeng.guns.pay.modular.payservice.mapper;

import com.stylefeng.guns.rest.modular.order.bean.OrderMsgData;
import org.apache.ibatis.annotations.Param;

/**
 * @author czy
 * @date 2019/6/10 19:38
 */
public interface PayMapper {
    /**
     * 根据orderId查询订单信息
     * @param orderId 订单号
     * @return OrderMsgData
     */
    OrderMsgData queryOrderById(@Param("orderId") String orderId);

    /**
     * 更新订单状态
     * @param orderId
     */
    void updateOrder(@Param("orderId")String orderId);
}
