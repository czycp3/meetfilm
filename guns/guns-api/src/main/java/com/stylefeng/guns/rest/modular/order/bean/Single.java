package com.stylefeng.guns.rest.modular.order.bean;

/**
 * @Author: zero
 * @Date: 2019/6/11 14:09
 * @Version 1.0
 */
public class Single {
    Integer seatId;
    Integer row;
    Integer column;

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Single() {
    }
}
