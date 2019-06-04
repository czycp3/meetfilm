package com.stylefeng.guns.rest.common.exception.exceptionhandle;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理器
 * @author CZY-Y7000P
 */
@Component
public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        Logger logger = Logger.getLogger(this.getClass());
        logger.info("exception handler");
        if(e instanceof Exception){
            FastJsonJsonView view = new FastJsonJsonView();
            Map<String, Object> attributes = new HashMap<>(16);
            attributes.put("status", 999);
            attributes.put("msg", "系统出现异常，请联系管理员");
            view.setAttributesMap(attributes);
            modelAndView.setView(view);
        }
        return modelAndView;
    }
}
