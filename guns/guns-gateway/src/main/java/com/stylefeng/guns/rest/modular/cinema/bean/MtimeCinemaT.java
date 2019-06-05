package com.stylefeng.guns.rest.modular.cinema.bean;

<<<<<<< HEAD
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
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
 * 影院信息表
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-04
 */
@TableName("mtime_cinema_t")
<<<<<<< HEAD
@JsonInclude(JsonInclude.Include.NON_NULL)
=======
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
public class MtimeCinemaT extends Model<MtimeCinemaT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
<<<<<<< HEAD
    private Integer uuid;
=======
    private Integer cinemaId;
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
    /**
     * 影院名称
     */
    @TableField("cinema_name")
    private String cinemaName;
    /**
     * 影院电话
     */
    @TableField("cinema_phone")
    private String cinemaPhone;
    /**
     * 品牌编号
     */
    @TableField("brand_id")
    private Integer brandId;
    /**
     * 地域编号
     */
    @TableField("area_id")
    private Integer areaId;
    /**
     * 包含的影厅类型,以#作为分割
     */
    @TableField("hall_ids")
    private String hallIds;
    /**
     * 影院图片地址
     */
    @TableField("img_address")
<<<<<<< HEAD
    private String imgAddress;
=======
    private String imgUrl;
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
    /**
     * 影院地址
     */
    @TableField("cinema_address")
<<<<<<< HEAD
    private String address;
=======
    private String cinemaAddress;
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
    /**
     * 最低票价
     */
    @TableField("minimum_price")
    private Integer minimumPrice;


<<<<<<< HEAD
    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
=======
    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaPhone() {
        return cinemaPhone;
    }

    public void setCinemaPhone(String cinemaPhone) {
        this.cinemaPhone = cinemaPhone;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getHallIds() {
        return hallIds;
    }

    public void setHallIds(String hallIds) {
        this.hallIds = hallIds;
    }

<<<<<<< HEAD
    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
=======

    public String getCinemaAddress() {
        return cinemaAddress;
    }

    public void setCinemaAddress(String cinemaAddress) {
        this.cinemaAddress = cinemaAddress;
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
    }

    public Integer getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Integer minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    @Override
    protected Serializable pkVal() {
<<<<<<< HEAD
        return this.uuid;
=======
        return this.cinemaId;
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
    }

    @Override
    public String toString() {
        return "MtimeCinemaT{" +
<<<<<<< HEAD
        "uuid=" + uuid +
        ", cinemaName=" + cinemaName +
        ", cinemaPhone=" + cinemaPhone +
        ", brandId=" + brandId +
        ", areaId=" + areaId +
        ", hallIds=" + hallIds +
        ", imgAddress=" + imgAddress +
        ", address=" + address +
        ", minimumPrice=" + minimumPrice +
        "}";
=======
                "cinemaId=" + cinemaId +
                ", cinemaName='" + cinemaName + '\'' +
                ", cinemaPhone='" + cinemaPhone + '\'' +
                ", brandId=" + brandId +
                ", areaId=" + areaId +
                ", hallIds='" + hallIds + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", cinemaAddress='" + cinemaAddress + '\'' +
                ", minimumPrice=" + minimumPrice +
                '}';
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
    }
}
