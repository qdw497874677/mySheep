package com.org.model;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 消除区域
 */
public class Eliminatebox {


    private Integer step = 5;
    private Level level;


    private static final List<Brand> SLOT = new ArrayList<>();


    /**
     * 清空集合
     * 使用迭代器清空集合
     * @param name
     */
    public void deleteByBrandName(String name) {
       Iterator<Brand> iterator = SLOT.iterator();
       while(iterator.hasNext()){
           Brand brand = iterator.next();
           if(brand.getName().equals(name)) {
               brand.getParent().remove(brand);
               iterator.remove();
           }
        }
    }

    /**
     * 鼠标无法点击已经点过的图片
     * @param brand
     */
    private void noMouseListener(Brand brand) {
        // 把这个brand的监听器全部移除
        MouseListener[] mouseListeners = brand.getMouseListeners();
        // 消除区域框里图形无法点击
        if (mouseListeners != null) {
            for (MouseListener mouseListener : mouseListeners) {
                brand.removeMouseListener(mouseListener);
            }
        }
    }


    public void addSlot(Brand brand) {
        SLOT.add(brand);
        noMouseListener(brand);
        // 消除区域图形排序
        SLOT.sort(Comparator.comparing(Brand::getName));
        // 消除
        Map<String, List<Brand>> map = SLOT.stream().collect(Collectors.groupingBy(Brand::getName));
        Set<String> keys = map.keySet();
        for (String key : keys) {
            List<Brand> brands = map.get(key);
            //System.out.println(brands.size()+"key");
            if (brands.size() == 3) {
                deleteByBrandName(key);
                break;
            }
        }
        // 绘制消除区域
        paint();
        // 游戏结束判定
        over(brand);
    }

    /**
     * 绘制到消除区域
     */
    public void paint(){
        for (int i = 0; i < SLOT.size(); i++) {
            Brand brand = SLOT.get(i);
//            System.out.println(brand.getName()+"----"+slot.size()+"-------列表的长度");
            int x = step + i * brand.getWidth() + 5 / 2 + 10;
            brand.setBounds(x, 600, 50, 50);
        }
    }

    /**
     * 游戏结束判定
     * @param brand
     */
    private void over(Brand brand) {
        int count = 7;
        if (SLOT.size() >= count){
            JOptionPane.showMessageDialog(brand, "over");
            System.exit(0);
        }
    }


}
