package com.stylefeng.guns.pay.modular.payservice.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.core.exception.ServiceException;
import com.stylefeng.guns.pay.modular.alipay.OrderPayUtil;
import com.stylefeng.guns.pay.modular.alipay.model.TradeStatus;
import com.stylefeng.guns.rest.modular.pay.bean.PayInfo;
import com.stylefeng.guns.rest.modular.pay.bean.PayResultVo;
import com.stylefeng.guns.rest.modular.pay.bean.PayStatusInfo;
import com.stylefeng.guns.rest.modular.pay.bean.PayStatusVo;
import com.stylefeng.guns.rest.modular.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author czy
 * @date 2019/6/8 18:36
 */
@Service(interfaceClass = PayService.class)
@Component
public class PayServiceImpl implements PayService {
    @Autowired
    OrderPayUtil orderPayUtil;

    @Override
    public PayResultVo getPayInfo(String orderId) {
        PayResultVo payResultVo = new PayResultVo();
        PayInfo payInfo = new PayInfo();

        //生成订单二维码
        TradeStatus tradeStatus = orderPayUtil.tradePrecreate(orderId);
        switch (tradeStatus) {
            case SUCCESS:
                payInfo.setQRCodeAddress("QRCodes/" + orderId + ".png");
                break;
            case FAILED:
                throw new ServiceException(1, "订单支付失败，请稍后重试");
            case UNKNOWN:
                throw new ServiceException(1, "系统异常，预下单状态未知!!!");
            default:
                throw new ServiceException(1, "系统异常");
        }
        //封装数据
        payInfo.setOrderId(orderId);
        payResultVo.setStatus(0);
        payResultVo.setImgPre("http://img.meetingshop.cn/");
        payResultVo.setData(payInfo);
        return payResultVo;
    }

    @Override
    public PayStatusVo getPayResult(String orderId, int tryNums) {
        PayStatusVo payStatusVo = new PayStatusVo();
        PayStatusInfo payStatusInfo = new PayStatusInfo();
        //尝试次数超过3次抛异常
        if(tryNums > 3){
            throw new ServiceException(1,"订单支付失败，请稍后重试");
        }

        //查询订单状态
        TradeStatus tradeStatus = orderPayUtil.tradeQuery(orderId);

        switch (tradeStatus){
            case SUCCESS:
                payStatusInfo.setOrderMsg("支付成功");
                payStatusInfo.setOrderId(orderId);
                payStatusInfo.setOrderStatus(1);
                payStatusVo.setData(payStatusInfo);
                payStatusVo.setStatus(0);
                break;
            case FAILED:
                throw new ServiceException(1,"订单支付失败，请稍后重试");
            case UNKNOWN:
                throw new ServiceException(1,"系统异常，订单支付状态未知!!!");
            default:
                throw new ServiceException(1,"不支持的交易状态，交易返回异常!!!");
        }

        return payStatusVo;
    }
}