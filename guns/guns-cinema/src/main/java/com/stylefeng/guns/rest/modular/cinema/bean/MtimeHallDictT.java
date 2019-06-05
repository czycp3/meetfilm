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
@TableName("mtime_hall_dict_t")
public class MtimeHallDictT extends Model<MtimeHallDictT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer hallTypeId;
    /**
     * 显示名称
     */
    @TableField("show_name")
    private String hallTypeName;
    /**
     * 座位文件存放地址
     */
    @TableField("seat_address")
    private String seatAddress;



    public MtimeHallDictT() {
    }

    @Override
    public String toString() {
        return "MtimeHallDictT{" +
                "hallTypeId=" + hallTypeId +
                ", hallTypeName='" + hallTypeName + '\'' +
                ", seatAddress='" + seatAddress + '\'' +
                '}';
    }

    public Integer getHallTypeId() {
        return hallTypeId;
    }

    public void setHallTypeId(Integer hallTypeId) {
        this.hallTypeId = hallTypeId;
    }

    public String getHallTypeName() {
        return hallTypeName;
    }

    public void setHallTypeName(String hallTypeName) {
        this.hallTypeName = hallTypeName;
    }

    public String getSeatAddress() {
        return seatAddress;
    }

    public void setSeatAddress(String seatAddress) {
        this.seatAddress = seatAddress;
    }

    @Override
    protected Serializable pkVal() {
        return this.hallTypeId;
    }


}
