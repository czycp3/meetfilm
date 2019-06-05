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
 * 品牌信息表
 * </p>
 *
 * @author stylefeng
 * @since 2019-06-04
 */
@TableName("mtime_brand_dict_t")
public class MtimeBrandDictT extends Model<MtimeBrandDictT> {

<<<<<<< HEAD
    public MtimeBrandDictT() {
    }

=======
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
<<<<<<< HEAD
    private Integer brandId;
=======
    private Integer uuid;
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
    /**
     * 显示名称
     */
    @TableField("show_name")
<<<<<<< HEAD
    private String brandName;

    @Override
    public String toString() {
        return "MtimeBrandDictT{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                '}';
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
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
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
    }

    @Override
    protected Serializable pkVal() {
<<<<<<< HEAD
        return this.brandId;
    }


=======
        return this.uuid;
    }

    @Override
    public String toString() {
        return "MtimeBrandDictT{" +
        "uuid=" + uuid +
        ", showName=" + showName +
        "}";
    }
>>>>>>> f2e93abc6342909d36680097ffe9aafce752e28e
}
