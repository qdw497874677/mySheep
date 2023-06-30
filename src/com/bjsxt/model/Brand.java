package com.bjsxt.model;


/**
 * 对于游戏当中  牌 的抽象。  比如 胡萝卜，玉米， 青草，
 */

import com.bjsxt.Start;
import com.bjsxt.util.ImageUtil;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.UUID;


public class Brand extends Component{
    // 对当前的图案进行命名  可以用来定位  图片的文件
    private String  name;
    private String  id;
    private Integer x=0;
    private Integer y=0;
    private int width=50;
    private int height=50;
    private Image image;
    private Image grayImage;
    // 是否置灰
    private Boolean isGray=false;
    private Cell cell;

    public Brand() {
    }

    public Brand(String name) {
        this.name = name;
        this.image = ImageUtil.get(name+".png");
        this.grayImage = ImageUtil.get(name+"_gray.png");
        this.id= UUID.randomUUID().toString();
        Brand self = this;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Brand brand = (Brand) e.getSource();
                if(brand.getGray() || brand.getName().equals("消除区域") || brand.getName().equals("背景草地")){
                    // 无操作
                }else{
                    System.out.println(brand.getName()+"被点击啦.....");
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

    Eliminatebox eliminatebox  =new Eliminatebox();

    @Override
    public void paint(Graphics g) {
//        super.paint(g);
        if(isGray){
            g.drawImage(this.getGrayImage(),x,y,null);
        }else{
            g.drawImage(this.getImage(),x,y,null);
        }
    }


    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Boolean getGray() {
        return isGray;
    }

    public void setGray(Boolean gray) {
        isGray = gray;
    }

    public String getName() {
        return name;
    }

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
