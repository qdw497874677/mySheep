package test;

import com.bjsxt.model.Layer;
import com.bjsxt.model.Level;
import com.bjsxt.model.Map;

public class TestMap {

    public static Map buildMap() {

        //  第一关
        Level firstLevel =new Level();
            firstLevel.setCount(1);  // 第一关
            firstLevel.setDifficulty(1);  //简单难度
            firstLevel.setEliminateboxSize(7);  // 消除栏长度

        //  构建Map

        Map map =new Map();
            map.setFloorHeight(3);   // 层高为 两层
            map.setX(100);
            map.setY(200);           // 100，200 作为 map 绘制的左上角坐标。

        firstLevel.setMap(map);

        //  构建图层
        Layer layer1= TestLayer.buildLayer(6,6);
        Layer layer2= TestLayer.buildLayer(5,6);
        Layer layer3= TestLayer.buildLayer(3,7);
//        Layer  layer4= TestLayer.buildLayer(9,5);

        layer3.setParentLayer(layer2);
        layer2.setParentLayer(layer1);
        layer1.setParentLayer(null);

        map.getLayers().add(layer1);
        map.getLayers().add(layer2);
        map.getLayers().add(layer3);


        return  map;

    }


}
