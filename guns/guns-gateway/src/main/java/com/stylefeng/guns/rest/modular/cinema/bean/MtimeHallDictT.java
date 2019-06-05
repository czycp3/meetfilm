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
@TableName("mtime_hall_dict_t")
public class MtimeHallDictT extends Model<MtimeHallDictT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
<<<<<<< HEAD
    private Integer hallTypeId;
=======
    private Integer hallFieldId;
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
    /**
     * 显示名称
     */
    @TableField("show_name")
<<<<<<< HEAD
    private String hallTypeName;
=======
    private String showName;
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
    /**
     * 座位文件存放地址
     */
    @TableField("seat_address")
<<<<<<< HEAD
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
=======
    private String seatFile;

    private String hallName;
    private Integer price;
    private String soldSeats;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getHallFieldId() {
        return hallFieldId;
    }

    public void setHallFieldId(Integer hallFieldId) {
        this.hallFieldId = hallFieldId;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getSeatFile() {
        return seatFile;
    }

    public void setSeatFile(String seatFile) {
        this.seatFile = seatFile;
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

    public String getSoldSeats() {
        return soldSeats;
    }

    public void setSoldSeats(String soldSeats) {
        this.soldSeats = soldSeats;
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
    }

    @Override
    protected Serializable pkVal() {
<<<<<<< HEAD
        return this.hallTypeId;
    }


=======
        return this.hallFieldId;
    }

    @Override
    public String toString() {
        return "MtimeHallDictT{" +
                "hallFieldId=" + hallFieldId +
                ", showName='" + showName + '\'' +
                ", seatFile='" + seatFile + '\'' +
                ", hallName='" + hallName + '\'' +
                ", price=" + price +
                ", soldSeats='" + soldSeats + '\'' +
                '}';
    }
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
}
