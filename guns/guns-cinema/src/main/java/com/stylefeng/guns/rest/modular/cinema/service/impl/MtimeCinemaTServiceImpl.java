package com.stylefeng.guns.rest.modular.cinema.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.modular.cinema.bean.*;
import com.stylefeng.guns.rest.modular.cinema.dao.MtimeCinemaTMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
public class MtimeCinemaTServiceImpl extends ServiceImpl<MtimeCinemaTMapper, MtimeCinemaT> implements IMtimeCinemaTService {
    @Autowired
    MtimeCinemaTMapper mtimeCinemaTMapper;

    @Override
    public BaseResultVo selectCinemaListByCondition(RequestVo requestVo) {
        /*if(requestVo.getPageSize()<1||requestVo.getNowPage()<1){
            undo 抛异常，搜索的每页条数和当前页数不能小于1
        }*/
//        requestVo.setHallType("#"+requestVo.getHallType()+"#");
        List<MtimeCinemaT> mtimeCinemaTList = mtimeCinemaTMapper.selectCinemaListByCondition(requestVo);
        BaseResultVo baseResultVo = new BaseResultVo();
        Data data = new Data();
        data.setCinemas(mtimeCinemaTList);
        int pageSize = Integer.parseInt(requestVo.getPageSize()==null?"12":requestVo.getPageSize());
        int totalPage = mtimeCinemaTList.size()/pageSize;

        baseResultVo.setTotalPage(totalPage);

        baseResultVo.setData(data);
        baseResultVo.setNowPage(requestVo.getNowPage()==null?1:requestVo.getNowPage());

        return baseResultVo;
    }

    @Override
    public BaseResultVo selectCinemaMsgByCondition(RequestVo requestVo) {
        List<MtimeCinemaT> cinemaTList = mtimeCinemaTMapper.selectCinemaMsgByCondition(requestVo);
       /* if (data==null){
            undo 抛出异常
        }*/
        ArrayList<MtimeBrandDictT> brandList = new ArrayList<>();
        ArrayList<MtimeAreaDictT> areaList = new ArrayList<>();
        ArrayList<MtimeHallDictT> hallTypeList = new ArrayList<>();
        for (MtimeCinemaT cinema:cinemaTList) {
            MtimeBrandDictT brand = mtimeCinemaTMapper.selectBrandListById(cinema.getBrandId());
            MtimeAreaDictT area = mtimeCinemaTMapper.selectAreaListById(cinema.getAreaId());
            brandList.add(brand);
            areaList.add(area);

            String substring = cinema.getHallIds().substring(1);
            String[] ids = substring.split("#");
            /*if(ids==null||ids.length==0){
                undo  抛出异常
            }*/
            for (int i = 0; i < ids.length; i++) {
                MtimeHallDictT hallType = mtimeCinemaTMapper.selectHallTypeListById(ids[i]);
                hallTypeList.add(hallType);
            }
        }
        Data data = new Data();
        data.setMtimeBrandDictTList(brandList);
        data.setMtimeAreaDictTList(areaList);
        data.setMtimeHallDictTList(hallTypeList);

        BaseResultVo baseResultVo = new BaseResultVo();
        baseResultVo.setData(data);
        baseResultVo.setStatus(0);
        return baseResultVo;
    }
}
