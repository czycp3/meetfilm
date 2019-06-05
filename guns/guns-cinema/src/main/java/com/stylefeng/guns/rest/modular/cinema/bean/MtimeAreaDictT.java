package com.stylefeng.guns.rest.modular.cinema.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 地域信息表
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-04
 */
@TableName("mtime_area_dict_t")
public class MtimeAreaDictT extends Model<MtimeAreaDictT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer areaId;
    /**
     * 显示名称
     */
    @TableField("show_name")
    private String areaName;

    @Override
    public String toString() {
        return "MtimeAreaDictT{" +
                "areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                '}';
    }

    public MtimeAreaDictT() {
    }

    @Override
    protected Serializable pkVal() {
        return this.areaId;
    }


    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
}
