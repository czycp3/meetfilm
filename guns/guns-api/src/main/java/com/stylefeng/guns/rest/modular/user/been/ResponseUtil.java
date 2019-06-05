package com.stylefeng.guns.rest.modular.user.been;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther 芮狼Dan
 * @date 2019-06-05 17:55
 */
public class ResponseUtil {

    //注册的封装信息
    public static Object register(int status,String msg) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("status", status);
        obj.put("msg", msg);
        return obj;
    }


}
