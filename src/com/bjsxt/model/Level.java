package com.bjsxt.model;

/*
    羊了个羊  关键数据结构   关卡 level
    1   关卡是 游戏最顶层的数据结构。    一个关卡包含 地图数据Map， ， map包含 图层数据layer，  layer包含 cell单元格。
        单元格里面  包含消除的 基本组件 component 。

    2   属性1  游戏难易度   Difficulty   1 简单  2 一般   3 困难
        根据 关卡的难度
    3   属性2  消除框的长度  eliminateboxSize   默认是7

    4   属性3  地图对象     map

    5   属性4  道具1  重排        二期开发的时候再添加
    5   属性5  道具2  撤回        二期开发的时候再添加
    5   属性6  道具3  挪出3个牌     二期开发的时候再添加


 */
public class Level {

    private  Integer  count;    // 第几关


    private  Integer  difficulty;   //游戏难易度   Difficulty   1 简单  2 一般   3 困难


    private  Integer   eliminateboxSize;   //消除框的长度  eliminateboxSize   默认是7


    private  Map   map;

    public Level(Integer count, Integer difficulty, Integer eliminateboxSize, Map map) {
        this.count = count;
        this.difficulty = difficulty;
        this.eliminateboxSize = eliminateboxSize;
        this.map = map;
    }

    public Level() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getEliminateboxSize() {
        eliminateboxSize = 7;
        return eliminateboxSize;
    }

    public void setEliminateboxSize(Integer eliminateboxSize) {
        this.eliminateboxSize = eliminateboxSize;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
