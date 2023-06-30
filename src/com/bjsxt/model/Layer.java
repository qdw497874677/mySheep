package com.bjsxt.model;


/*
    图层   游戏当中重要的数据结构
    1   某个图层的左上角位置  是有一定的偏移量的, 偏移的数值是随机的. 这样可以形成堆叠,并且露出部分下层图案的效果.
    2   吐过没有 一定的偏移, 那么就是完全盖住了下层的 组件.
    3


 */

import java.util.Random;

public class Layer {

    private  Integer  offset =10;   // 偏移量

    private  Integer  x;        // 通过偏移量计算后的  左上角x坐标
    private  Integer  y;        // 通过偏移量计算后的  左上角y坐标


    private  Integer  cellNumx;   //  本图层中横向有多少单元格        3
    private  Integer  cellNumy;     //  本图层中竖向有多少个单元格    2


    private  Cell [][]   cells =null;

    private  Integer  capacity ;    // 容量

    private  Integer  size=0;   //  当前图层有多少组件    如果为0  说明当前图片没有组件, 都被消除完毕啦. 可以从map当中删除掉.、

    private  Layer   parentLayer;   // 上层图层


    public Layer(Integer cellNumx, Integer cellNumy) {
        this.cellNumx = cellNumx;
        this.cellNumy = cellNumy;

        this.capacity = this.cellNumx*this.cellNumy;
        this.cells =new  Cell[cellNumx][cellNumy];

        // 偏移量设置
        this.offset= new Random().nextInt(100);

    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
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

    public Integer getCellNumx() {
        return cellNumx;
    }

    public void setCellNumx(Integer cellNumx) {
        this.cellNumx = cellNumx;
    }

    public Integer getCellNumy() {
        return cellNumy;
    }

    public void setCellNumy(Integer cellNumy) {
        this.cellNumy = cellNumy;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setParentLayer(Layer parentLayer) {
        this.parentLayer = parentLayer;
    }

    public void  show(){
        if(cells==null) return;

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j].getBrand().getName());
            }
            System.out.println();
        }
    }

    public Cell getIndex(int index){
        int  index_x= index/this.getCellNumy();
        int  index_y= index%this.getCellNumy();

        return this.cells[index_x][index_y];

    }


    public Layer getParentLayer() {
        return  this.parentLayer;
    }
}
