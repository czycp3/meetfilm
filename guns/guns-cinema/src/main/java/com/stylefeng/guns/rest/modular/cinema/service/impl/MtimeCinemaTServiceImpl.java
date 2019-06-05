package com.stylefeng.guns.rest.modular.cinema.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.modular.cinema.bean.*;
import com.stylefeng.guns.rest.modular.cinema.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.modular.cinema.service.IMtimeCinemaTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 影院信息表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-04
 */
@Service
@Component
public class MtimeCinemaTServiceImpl  implements IMtimeCinemaTService  {
    @Autowired
    MtimeCinemaTMapper mtimeCinemaTMapper;
    @Override
    public BaseResultVo GetFileds(String cinemaId) {
        BaseResultVo baseResultVo = new BaseResultVo();
        MtimeCinemaT mtimeCinemaT ;
        List<MtimeHallFilmInfoT> mtimeCinemaTS;
        Boolean flag=false;
        Integer i=null;
        try {
            i = Integer.parseInt(cinemaId);
        } catch (NumberFormatException e) {
            flag =true;
        }
        if (flag){
            baseResultVo.setStatus(0);
            return baseResultVo;
        }
        Data data = new Data();
        try {
            mtimeCinemaTS = mtimeCinemaTMapper.selectDataFilmListByCinemaId(i);
            mtimeCinemaT =mtimeCinemaTMapper.selectDataCinemaInfoByCinemaId(i);
        } catch (Exception e) {
            baseResultVo.setStatus(1);
            baseResultVo.setMsg("影院信息查询失败");
            return baseResultVo;
        }
        data.setFilmList(mtimeCinemaTS);
        data.setCinemaInfo(mtimeCinemaT);
        baseResultVo.setData(data);
        baseResultVo.setImgPre("http://img.meetingshop.cn/");
        return baseResultVo;
    }
}
