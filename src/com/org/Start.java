package com.org;


import com.org.model.Brand;
import com.org.model.Cell;
import com.org.model.Layer;
import com.org.model.Map;
import com.org.model.Music;
import javazoom.jl.decoder.JavaLayerException;
import com.org.config.MapBuilder;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author qdw
 */
public class Start extends JFrame {


    private Integer width = 450;
    private Integer height = 800;

    public static Map map = MapBuilder.buildMap();

    private Brand bj = new Brand("背景草地");
    private Brand xc = new Brand("消除区域");

    public Start() throws HeadlessException {
        // 窗口初始化
        init();
        // 渲染map
        renderMap();
        // 消除区域和选择区域背景绘制
        xc.setBounds(0,575,450,800);
        this.getContentPane().add(xc);
        bj.setBounds(0,0,450,800);
        this.getContentPane().add(bj);
        refresh();
        try {
            new Music();
        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }


    /**
     * 窗口绘制
     */
    public void init(){
        this.setVisible(true);
        this.setSize(width, height);
        this.setTitle("羊了个羊");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(0, 0, 450, 800);
        this.setLocationRelativeTo(null);
    }

    /**
     * 渲染地图
     */
    public void renderMap(){
        List<Layer> list = map.getLayers();
        for (Layer layer : list) {
            renderLayer(this.getContentPane(), layer);
        }
        // 置灰判定
        map.grayDecide();
    }

    /**
     * 渲染布局
     * @param container
     * @param layer
     */
    private void  renderLayer(Container container, Layer layer){
        Cell[][] cells = layer.getCells();
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Cell cell = cells[i][j];
                if(cell.getState() == 2){
                    Brand brand = cell.getBrand();
                    int brandx = j * 50 + layer.getOffset();
                    int brandy = i * 50 + layer.getOffset();
                    brand.setBounds(brandx, brandy, 50, 50);
                    this.getContentPane().add(brand);
                }
            }
        }
    }

    public void refresh(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            }
        }).start();
    }


    public static void main(String[] args) {
        new Start();
    }
}
