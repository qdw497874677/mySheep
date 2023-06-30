package com.org.model;


/**
 * cell  单元格  是图层的基本单元.
 *     一个单元格 有两个基本的状态     1   空   没有牌     2  有牌
 *     当前单元格 有牌的状态下  如果被上层盖住啦,就显示  灰色的 图片, 否则 显示正常的图片.
 *
 *     单元格 可以是最基本的单元。
 *     宽度， 高度，
 *     左上角 坐标x，y
 * @author qdw
 */

public class Cell {

    //     1   空   没有牌     2  有牌
    private Integer state = 1;

    // 牌
    private Brand brand = null;

    public Cell(Brand brand) {
        this.brand = brand;
        this.state =2 ;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}