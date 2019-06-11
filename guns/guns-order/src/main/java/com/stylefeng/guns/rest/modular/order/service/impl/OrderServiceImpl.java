package com.stylefeng.guns.rest.modular.order.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.gson.Gson;
import com.stylefeng.guns.core.exception.ServiceException;
import com.stylefeng.guns.rest.modular.order.bean.*;
import com.stylefeng.guns.rest.modular.order.bean.OrderBaseVo;
import com.stylefeng.guns.rest.modular.order.bean.OrderMsgData;
import com.stylefeng.guns.rest.modular.order.bean.OrderVo;
import com.stylefeng.guns.rest.modular.order.mapper.OrderMapper;
import com.stylefeng.guns.rest.modular.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
    public OrderResultVo buyTickets(OrderVo orderVo, String username) throws ServiceException {
        OrderMsgData orderMsgData = orderMapper.getCinemaMsgByFieldId(orderVo.getFieldId());

        String[] seats = orderVo.getSoldSeats().split(",");
        BigDecimal ticketPrice = orderMsgData.getTicketPrice();
        //获得订单总价格
        BigDecimal ticketNum = new BigDecimal(String.valueOf(seats.length));
        orderMsgData.setOrderPrice(ticketPrice.multiply(ticketNum));
        //获得座位信息
        String[] seatMsg = orderVo.getSoldSeats().split(",");
        StringBuilder seatsName = new StringBuilder();

        String jsonAddress = orderMapper.getJsonAddressByFieldId(orderVo.getFieldId());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            FileInputStream stream = new FileInputStream("C:\\Dev\\Java13\\ppt\\project4\\前端代码\\film-front\\static" + jsonAddress);
            byte[] bytes = new byte[1024];
            int length = -1;
            while ((length = stream.read(bytes))!= -1) {
                outputStream.write(bytes, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json = outputStream.toString();
        Gson gson = new Gson();
        //座位表类
        Seat seatTable = gson.fromJson(json, Seat.class);
        for (String seat:seatMsg) {
            int seatId = Integer.parseInt(seat);
            List<List<Single>> singleSeatList = seatTable.getSingle();
            List<List<Couple>> coupleSeatList = seatTable.getCouple();
            //判断并添加单排座的座位
            for (List<Single> singleSeat:singleSeatList){
                for (Single singleItem :singleSeat) {
                    if(singleItem.getSeatId()==seatId){
                        seatsName.append(singleItem.getRow()+"排"+singleItem.getColumn()+"座 ");
                    }
                }
            }
            //判断并添加双排座的座位
            for (List<Couple> coupleSeat:coupleSeatList){
                for (Couple coupleItem :coupleSeat) {
                    if(coupleItem.getSeatId()==seatId){
                        seatsName.append(coupleItem.getRow()+"排"+coupleItem.getColumn()+"座 ");
                    }
                }
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
        String orderId = UUID.randomUUID().toString().replace("-", "");
        orderMsgData.setOrderId(orderId);

        //将orderMsgData封装到OrderBaseVo中
        OrderResultVo orderResultVo = new OrderResultVo();
        orderResultVo.setStatus(0);
        orderResultVo.setMsg("");
        orderResultVo.setData(orderMsgData);

        //获取订单参数，cinemaId,fieldId,filmId
        Field field = orderMapper.selectFieldMsgByOrderVo(orderVo);

        //将订单以未支付状态存入数据库中
        int userId = orderMapper.selectUserIdByUsername(username);
        int i = orderMapper.insertOrder(orderMsgData, field, userId);
        if (i == 1) {
            return orderResultVo;
        } else {
            throw new ServiceException(3, "订单发生错误，请重新购票");
        }
    }


    @Override
    public OrderBaseVo getOrderInfo(OrderVo orderVo, String username) {
        OrderBaseVo orderBaseVo = new OrderBaseVo();
        OrderMsgData[] data = null;
        try {
            data = orderMapper.getOrderInfo(username, (orderVo.getNowPage() - 1) * orderVo.getPageSize(), orderVo.getPageSize());
        } catch (Exception e) {
            throw new ServiceException(999, "系统出现异常，请联系管理员");
        }
        if (data == null || data.length < 1) {
            throw new ServiceException(1, "订单列表为空哦！~");
        }
        int length = data.length;
        while (length > 0) {
            length--;
            String fieldTime = data[length].getFieldTime();
            String[] s = fieldTime.split(" ");
            SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            data[length].setOrderTimestamp(s[0] + s[1]);
            data[length].setFieldTime(s[0] + " " + s[2]);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("MM月dd日 HH:mm");
            try {
                long time = simpleDateFormat3.parse(s[0] + " " + s[1]).getTime();
                String t = (int) (time / 1000) + "";
                data[length].setOrderTimestamp(t);
                Date parse = simpleDateFormat.parse(data[length].getFieldTime());
                String format = simpleDateFormat1.format(parse);
                data[length].setFieldTime(format);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        orderBaseVo.setStatus(0);
        orderBaseVo.setData(data);
        return orderBaseVo;
    }

    @Override
    public String getOrderSeatNumber(String cinemaId, String fieldId) {
        String seatNumber = orderMapper.getOrderSeatNumber(cinemaId, fieldId);
        return seatNumber;
    }
}
