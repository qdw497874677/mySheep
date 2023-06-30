package com.org.model;

import java.util.ArrayList;
import java.util.List;

/**
 *  游戏的地图数据结构    三维的数据
 *  1   因为有多层的图层
 *
 *  属性1：  层高 floorHeight    比如  简单的第一关  层高是2  也就是2层 。
 * @author qdw
 */
public class Map {

    /**
     * 绘制地图的左上角  x坐标
     */
    private Integer x;
    /**
     * 绘制地图的左上角  y坐标
     */
    private Integer y;
    /**
     * 层高
     */
    private Integer floorHeight;
    /**
     * layers 的数组长度  和 层高是一致的。
     */
    private List<Layer> layers = new ArrayList<>();

    public Map() {
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight(Integer floorHeight) {
        this.floorHeight = floorHeight;
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }


    /**
     * 判定map中的所有图案是否置灰，并做置灰操作
     * 这个方法的调用时机    1  第一次 map 构建的时候     2   某一张牌移动的时候
     */
    public void grayDecide() {
        List<Layer> list = this.getLayers();
        // 最上层不会被覆盖，从第二层开始判定
        for (int i = 1; i < list.size(); i++) {
            Layer layer = list.get(i);
            // 遍历这层的所有cell
            for (int j = 0; j < layer.getCapacity(); j++) {
                Cell cell = layer.getIndex(j);
                if(cell.getState() == 2) {
                    // 单元格当中有牌 才进行置灰判定
                    Brand brand = cell.getBrand();
                    // 和上层的所有牌进行 交集判定
                    boolean cover = brand.brand2layer(layer.getParentLayer());
                    brand.setGray(cover);
                }
            }
        }
    }



}
