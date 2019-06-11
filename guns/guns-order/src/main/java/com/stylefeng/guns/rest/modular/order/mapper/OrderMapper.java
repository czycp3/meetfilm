package com.stylefeng.guns.rest.modular.order.mapper;

import com.stylefeng.guns.rest.modular.order.bean.Field;
import com.stylefeng.guns.rest.modular.order.bean.OrderMsgData;
import com.stylefeng.guns.rest.modular.order.bean.OrderVo;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zero
 * @Date: 2019/6/8 21:02
 * @Version 1.0
 */
public interface OrderMapper {
    OrderMsgData getCinemaMsgByFieldId(Integer fieldId);

    int insertOrder(@Param("orderMsgData") OrderMsgData orderMsgData, @Param("field") Field field, @Param("userId") int username);

    Field selectFieldMsgByOrderVo(@Param("orderVo") OrderVo orderVo);

    int selectUserIdByUsername(@Param("username") String username);

    OrderMsgData[] getOrderInfo(@Param("username") String username,@Param("offset") int i,@Param("pagesize") Integer pageSize);

    String getOrderSeatNumber(@Param("cinemaId") String cinemaId,@Param("fieldId") String fieldId);

    String getJsonAddressByFieldId(@Param("fieldId") Integer fieldId);
}
