package com.org.config;

import com.org.model.Layer;
import com.org.model.Level;
import com.org.model.Map;

/**
 * @author quandawei
 */
public class MapBuilder {

    /**
     * 配置地图信息
     * @return
     */
    public static Map buildMap() {
        // 第一关
        Level firstLevel = new Level();
        // 第一关
        firstLevel.setCount(1);
        // 简单难度
        firstLevel.setDifficulty(1);
        // 消除栏长度
        firstLevel.setEliminateboxSize(7);
        // 构建Map
        Map map =new Map();
        // 层高为 两层
        map.setFloorHeight(3);
        // 100，200 作为 map 绘制的左上角坐标。
        map.setX(100);
        map.setY(200);
        firstLevel.setMap(map);
        // 构建图层
        Layer layer1= LayerBuilder.buildLayer(6, 6);
        Layer layer2= LayerBuilder.buildLayer(5, 6);
        Layer layer3= LayerBuilder.buildLayer(3, 7);
        // Layer  layer4= TestLayer.buildLayer(9,5);

        layer3.setParentLayer(layer2);
        layer2.setParentLayer(layer1);
        layer1.setParentLayer(null);

        map.getLayers().add(layer1);
        map.getLayers().add(layer2);
        map.getLayers().add(layer3);

        return  map;
    }


}
