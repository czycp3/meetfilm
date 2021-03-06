package com.stylefeng.guns.rest.modular.cinema.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 放映场次表
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-04
 */
@TableName("mtime_field_t")
public class MtimeFieldT extends Model<MtimeFieldT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer fieldId;
    /**
     * 影院编号
     */
    @TableField("cinema_id")
    private Integer cinemaId;
    /**
     * 电影编号
     */
    @TableField("film_id")
    private Integer filmId;
    /**
     * 开始时间
     */
    @TableField("begin_time")
    private String beginTime;
    /**
     * 结束时间
     */
    @TableField("end_time")
    private String endTime;
    /**
     * 放映厅类型编号
     */
    @TableField("hall_id")
    private Integer hallId;
    /**
     * 放映厅名称
     */
    @TableField("hall_name")
    private String hallName;
    /**
     * 票价
     */
    private Integer price;

    /*添加的language*/
    private String language;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getFieldId() {
        return fieldId;
    }

    public void setFieldId(Integer fieldId) {
        this.fieldId = fieldId;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    protected Serializable pkVal() {
        return this.fieldId;
    }

    @Override
    public String toString() {
        return "MtimeFieldT{" +
                "uuid=" + fieldId +
                ", cinemaId=" + cinemaId +
                ", filmId=" + filmId +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", hallId=" + hallId +
                ", hallName='" + hallName + '\'' +
                ", price=" + price +
                ", language='" + language + '\'' +
                '}';
    }
}
