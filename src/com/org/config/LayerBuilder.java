package com.org.config;




import com.org.model.Brand;
import com.org.model.Cell;
import com.org.model.Layer;

import java.util.Random;

/**
 * @author quandawei
 */
public class LayerBuilder {

    public static String[] brandNames={
            "刷子","剪刀","叉子",
            "手套","水桶","火",
            "玉米","球","瓶子",
            "白菜","稻草","肉腿",
            "胡萝卜","苹果","苹果",
            "铃铛","青草"
    };


    /**
     * 参数cellNumx,cellnumy  表示 构建的图层 每行多少单元格，每列多少单元格。
     * 注意：  两个参数的乘积 结果需要被3整除， 不然会出现异常。
     * @param cellNumx
     * @param cellnumy
     * @return
     */
    public static Layer buildLayer(int cellNumx, int cellnumy){
        Layer layer = new Layer(cellNumx, cellnumy);
        //
        Cell[][] cells = layer.getCells();
        //  下一步  要把 9个 brand 牌  放入到  cells 数组中。
        Brand[] brands = new Brand[layer.getCapacity()];

        //  1  从牌的种类当中随机取一个 牌名

        //  2  根据 随机去到的 牌名 创建3个 相同的牌对象

        //  3  根据 把对象存入 容量为9 的
        for (int i = 0; i < brands.length; i = i + 3) {
            Brand brand1 = new Brand(brandNames);
            Brand brand2 = new Brand(brandNames);
            Brand brand3 = new Brand(brandNames);
            brands[i] = brand1;
            brands[i + 1] = brand2;
            brands[i + 2] = brand3;
        }

        //   4   把一位数组当中的牌  打乱顺序
        for (int i = 0; i < brands.length; i++) {
            Brand brand = brands[i];
            int rand = new Random().nextInt(brands.length);
            brands[i] = brands[rand];
            brands[rand] = brand;
        }

        int count = 0;

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Brand brand = brands[count];
                Cell cell = new Cell(brand);
                brand.setCell(cell);
                cells[i][j] = cell;
                count++;
            }
        }
        layer.setSize(count);
        layer.show();
        return layer;
    }



    public static void main(String[] args) {

        Layer layer = new Layer(3, 5);
//
        Cell[][] cells = layer.getCells();

        //  下一步  要把 9个 brand 牌  放入到  cells 数组中。
        Brand[] brands = new Brand[layer.getCapacity()];

        //  1  从牌的种类当中随机取一个 牌名

        //  2  根据 随机去到的 牌名 创建3个 相同的牌对象

        //  3  根据 把对象存入 容量为9 的
        for (int i = 0; i < brands.length; i = i + 3) {
            int rand = new Random().nextInt(brandNames.length);
            String brandName = brandNames[rand];
            System.out.println(brandName);
            Brand brand1 = new Brand(brandName);
            Brand brand2 = new Brand(brandName);
            Brand brand3 = new Brand(brandName);

            brands[i] = brand1;
            brands[i + 1] = brand1;
            brands[i + 2] = brand1;
        }
        System.out.println("存入一维数组的牌：");
        for (Brand brand : brands) {
            System.out.print(brand.getName()+"  ");
        }
        System.out.println();

        //   4   把一位数组当中的牌  打乱顺序
        for (int i = 0; i < brands.length; i++) {
            Brand brand = brands[i];

            int  rand =new  Random().nextInt(brands.length);
            brands[i]= brands[rand];
            brands[rand]=brand;

        }
        //  5   输出 打乱顺序后的 一维数组
        System.out.println("--------------------");
        System.out.println(" 输出 打乱顺序后的 一维数组的牌：");
        for (Brand brand : brands) {
            System.out.print(brand.getName()+"  ");
        }
        System.out.println();

        //   6  把一维数组当中的数据 ， 存入 二维数组 cells当中。
        int count =0;

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j]=new Cell(brands[count++]);
            }
        }
        layer.setSize(count);
        //   7  遍历 当前图层的 二维数据
        System.out.println("------------------------");

        for (int i = 0; i < layer.getCapacity(); i++) {
            Cell cell= layer.getIndex(i);
            System.out.print(cell.getBrand().getName());

        }



    }


}
