package com.stylefeng.guns.rest.modular.order.bean;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/6/11 14:07
 * @Version 1.0
 */
public class Seat {
     Integer limit;
     String ids;
     List<List<Single>> single;
     List<List<Couple>> couple;

    public Seat() {
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public List<List<Single>> getSingle() {
        return single;
    }

    public void setSingle(List<List<Single>> single) {
        this.single = single;
    }

    public List<List<Couple>> getCouple() {
        return couple;
    }

    public void setCouple(List<List<Couple>> couple) {
        this.couple = couple;
    }
}
