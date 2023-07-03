package test;


import com.org.config.LayerBuilder;
import com.org.model.Brand;
import com.org.model.Cell;
import com.org.model.Layer;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

/**
 * @author quandawei
 */
public class TestRenderLayer extends JFrame {

    private Integer  width = 450;

    private Integer  height =800;

    private Layer layer = LayerBuilder.buildLayer(3, 3);

    public TestRenderLayer() throws HeadlessException, InterruptedException, InvocationTargetException {

        this.setVisible(true);
        this.setSize(width, height);
        this.setTitle("羊了个羊");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);
        this.setBounds(0, 0, 450, 800);

        TestRenderLayer frame = this;

//        brand1.setBounds(100,100,50,50);
//        this.getContentPane().add(brand1);
        Cell[][] cells = layer.getCells();


        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Cell cell = cells[i][j];

                if(cell.getState()==2){
                    Brand brand = cell.getBrand();
                    int brandx = j * 50 + layer.getOffset();
                    int brandy = i * 50 + layer.getOffset();

                    brand.setBounds(brandx, brandy, 50, 50);
                    this.getContentPane().add(brand);
                }
            }
        }

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

    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        new TestRenderLayer();
    }
}
