package com.stylefeng.guns.rest.modular.cinema.bean;

<<<<<<< HEAD
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
=======
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
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
<<<<<<< HEAD
    private Integer areaId;
=======
    private Integer uuid;
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
    /**
     * 显示名称
     */
    @TableField("show_name")
<<<<<<< HEAD
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
=======
    private String showName;


    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "MtimeAreaDictT{" +
        "uuid=" + uuid +
        ", showName=" + showName +
        "}";
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
    }
}
