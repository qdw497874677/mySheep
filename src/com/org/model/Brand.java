package com.org.model;


/**
 * 对于游戏当中  牌 的抽象。  比如 胡萝卜，玉米， 青草，
 */

import com.org.Start;
import com.org.util.ImageUtil;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.UUID;


/**
 * @author qdw
 */
public class Brand extends Component {
    // 对当前的图案进行命名  可以用来定位  图片的文件
    private String name;
    private String id;
    private Integer x = 0;
    private Integer y = 0;
    private int width = 50;
    private int height = 50;
    private Image image;
    private Image grayImage;
    /**
     * 是否置灰
     */
    private boolean isGray = false;
    private Cell cell;

    public Brand() {
    }

    /**
     * 从集合中随意一个名字
     * @param names
     */
    public Brand(String[] names) {
        this(names[new Random().nextInt(names.length)]);
    }

    public Brand(String name) {
        this.name = name;
        this.image = ImageUtil.get(name + ".png");
        this.grayImage = ImageUtil.get(name + "_gray.png");
        this.id = UUID.randomUUID().toString();
        Brand self = this;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Brand brand = (Brand) e.getSource();
                if (Boolean.TRUE.equals(brand.getGray()) || "消除区域".equals(brand.getName()) || "背景草地".equals(brand.getName())) {
                    // 灰色、消除区域、背景草地：无操作
                } else {
                    System.out.println(brand.getName() + "被点击啦.....");
                    //                    self.getParent().remove(self);
                    eliminatebox.addSlot(brand);
                    self.getCell().setState(1);
                    self.getCell().setBrand(null);
                    self.setCell(null);
                    // 触发全局置灰判定
                    Start.map.grayDecide();
                }
            }
        });
    }

    Eliminatebox eliminatebox = new Eliminatebox();

    @Override
    public void paint(Graphics g) {
//        super.paint(g);
        if(isGray){
            g.drawImage(this.getGrayImage(), x, y, null);
        }else{
            g.drawImage(this.getImage(), x, y, null);
        }
    }

    /**
     * 递归比较是否与上层有遮盖
     * @param layer
     * @return
     */
    public boolean brand2layer(Layer layer) {
        // 遍历上层所有cell，查看是否有被遮盖的情况
        for (int j = 0; j < layer.getCapacity(); j++) {
            Cell cell = layer.getIndex(j);
            // 如果cell不是空，则
            if(cell.getState() == 2) {
                Brand temp = cell.getBrand();
                // 判断brand是否被上层对应cell上的brand遮盖
                boolean flag = this.getBounds().intersects(temp.getBounds());
                if (flag) {
                    // 说明被遮盖了。只要有一个元素相交就是被遮盖啦。
                    return true;
                }
            }
        }

        // 当整个for循环都结束。 说明 当前的牌和 上层的图层没有相交
        //  应该和 上层图层的 上层图层继续 比较
        if(layer.getParentLayer() == null) {
            // 说明没有上层图层啦， 都比较完毕啦。  没有被遮盖
            return false;
        }else{
            return brand2layer(layer.getParentLayer());
        }
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public boolean getGray() {
        return isGray;
    }

    public void setGray(boolean gray) {
        isGray = gray;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }



    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getGrayImage() {
        return grayImage;
    }

    public void setGrayImage(Image grayImage) {
        this.grayImage = grayImage;
    }


}
