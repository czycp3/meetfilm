package com.stylefeng.guns.rest.modular.cinema.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.core.exception.ServiceException;
import com.stylefeng.guns.rest.modular.cinema.bean.*;
import com.stylefeng.guns.rest.modular.cinema.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.modular.cinema.service.IMtimeCinemaTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
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

public class MtimeCinemaTServiceImpl implements IMtimeCinemaTService {
    @Autowired
    MtimeCinemaTMapper mtimeCinemaTMapper;

    @Override
    public BaseVo selectCinemaListByCondition(RequestVo requestVo) {
        if(requestVo.getPageSize()<1||requestVo.getNowPage()<1){
            throw new ServiceException( 1,"影院信息查询失败");
        }
        List<MtimeCinemaT> data = mtimeCinemaTMapper.selectCinemaListByCondition(requestVo);
        BaseVo baseVo = new BaseVo();

        int totalPage = data.size()/requestVo.getPageSize()==0?1:data.size()/requestVo.getPageSize();

        baseVo.setTotalPage(totalPage);


        baseVo.setData(data);
        baseVo.setNowPage(requestVo.getNowPage());

        return baseVo;
    }

    @Override
    public BaseResultVo selectCinemaMsgByCondition(RequestVo requestVo) throws ServiceException{
        Data data = new Data();
        List<MtimeBrandDictT> brandList = mtimeCinemaTMapper.selectBrandListById(requestVo.getBrandId());
        List<MtimeAreaDictT> areaList = mtimeCinemaTMapper.selectAreaListById(requestVo.getAreaId());
        List<MtimeHallDictT> halltypeList = mtimeCinemaTMapper.selectHalltypeListById(requestVo.getHallType());

        data.setBrandList(brandList);
        data.setAreaList(areaList);
        data.setHalltypeList(halltypeList);

        BaseResultVo baseResultVo = new BaseResultVo();
        baseResultVo.setData(data);
        baseResultVo.setStatus(0);
        return baseResultVo;
    }

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
        mtimeCinemaTS = mtimeCinemaTMapper.selectDataFilmListByCinemaId(i);
        mtimeCinemaT =mtimeCinemaTMapper.selectDataCinemaInfoByCinemaId(i);
        if (mtimeCinemaT==null||mtimeCinemaTS==null){
            throw new ServiceException( 1,"影院信息查询失败");
        }
        mtimeCinemaT.setImgUrl(mtimeCinemaT.getImgUrl().substring(1));
        data.setFilmList(mtimeCinemaTS);
        data.setCinemaInfo(mtimeCinemaT);
        baseResultVo.setData(data);
        baseResultVo.setImgPre("http://czycp3.oss-cn-shanghai.aliyuncs.com/");
        //baseResultVo.setImgPre("");
        return baseResultVo;
    }


}
