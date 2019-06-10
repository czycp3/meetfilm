package com.stylefeng.guns.rest.modular.order.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.core.exception.ServiceException;
import com.stylefeng.guns.rest.modular.order.bean.*;
import com.stylefeng.guns.rest.modular.order.mapper.OrderMapper;
import com.stylefeng.guns.rest.modular.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @Author: zero
 * @Date: 2019/6/8 21:00
 * @Version 1.0
 */
@Service(interfaceClass = OrderService.class)
@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    @Transactional
    public OrderResultVo buyTickets(OrderVo orderVo, String username) throws ServiceException{
        OrderMsgData orderMsgData = orderMapper.getCinemaMsgByFieldId(orderVo.getFieldId());

        String[] seats = orderVo.getSoldSeats().split(",");
        BigDecimal ticketPrice = orderMsgData.getTicketPrice();
        //获得订单总价格
        BigDecimal ticketNum = new BigDecimal(String.valueOf(seats.length));
        orderMsgData.setOrderPrice(ticketPrice.multiply(ticketNum));
        //获得座位信息
        String[] seatMsg = orderVo.getSoldSeats().split(",");
        StringBuilder seatsName = new StringBuilder();
        for (String seatNum:seatMsg) {
            int seat = Integer.parseInt(seatNum);
            if(seat>0&&seat<=5) {
                seatsName.append("第一排" + seat + "座,");
            }else if(seat>5&&seat<=10) {
                seatsName.append("第二排" + (seat - 4) + "座,");
            }else if(seat>10&&seat<=16) {
                seatsName.append("第三排" + (seat - 4 * 2) + "座,");
            }else if (seat>17&&seat<=22) {
                seatsName.append("第四排" + (seat - 4 * 3) + "座,");
            }else{
                throw new ServiceException(2,"订单座位号产生错误，请重新选择座位");
            }
        }
        String substring = seatsName.substring(0, seatsName.length() - 1);
        orderMsgData.setSeatsName(substring);
        //获得订单座位号
        orderMsgData.setSeatsIds(orderVo.getSoldSeats());
        //获得订单时间戳
        int orderTimestamp = (int) (System.currentTimeMillis() / 1000);
        orderMsgData.setOrderTimestamp(String.valueOf(orderTimestamp));
        //生成订单id
        String orderId = UUID.randomUUID().toString().substring(0, 16);
        orderMsgData.setOrderId(orderId);

        //将orderMsgData封装到OrderBaseVo中
        OrderResultVo orderResultVo = new OrderResultVo();
        orderResultVo.setStatus(0);
        orderResultVo.setMsg("");
        orderResultVo.setData(orderMsgData);

        //获取订单参数，cinemaId,fieldId,filmId
        Field field =orderMapper.selectFieldMsgByOrderVo(orderVo);

        //将订单以未支付状态存入数据库中
        int userId = orderMapper.selectUserIdByUsername(username);
        int i = orderMapper.insertOrder(orderMsgData,field,userId);
        if(i==1){
            return orderResultVo;
        }else {
            throw new ServiceException(3,"订单发生错误，请重新购票");
        }
    }

    @Override
    public OrderBaseVo getOrderInfo(OrderVo orderVo) {
        return null;
    }
}
