package com.stylefeng.guns.rest.modular.user.been;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther 芮狼Dan
 * @date 2019-06-05 17:55
 */
public class ResponseUtil {

    //返回的封装信息（无data）
    public static Object responseVo(int status,String msg) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("status", status);
        obj.put("msg", msg);
        return obj;
    }

    //返回的封装信息
    public static Object responseVo(int status,Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("status", status);
        obj.put("data", data);
        return obj;
    }


}
