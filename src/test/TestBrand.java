package test;

import com.org.model.Brand;
import com.org.model.Music;
import javazoom.jl.decoder.JavaLayerException;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class TestBrand extends JFrame{

    private Integer  width = 450;
    private Integer  height =800;
    private Brand brand0 =new Brand("背景草地");
    private Brand brand00 = new Brand("消除区域");

    private Brand brand1 =new Brand("胡萝卜");
    private Brand brand11 =new Brand("胡萝卜");
    private Brand brand111 =new Brand("胡萝卜");
    private Brand brand1111 =new Brand("胡萝卜");
    private Brand brand2 =new Brand("玉米");

    private Brand brand3 =new Brand("青草");






    public TestBrand() throws HeadlessException {



        this.setVisible(true);
        this.setSize(width,height);
        this.setLocationRelativeTo(null);
        this.setTitle("羊了个羊");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        GridLayout gl = new GridLayout(3, 3);
        this.setLayout(null);
        this.setBounds(0,0,450,800);

//        JLabel  label =new JLabel("这是一个label111");
//        JLabel  label2 =new JLabel("这是一个label222");
//        this.getContentPane().add(label);
//        this.getContentPane().add(label2);
//        panel.add(label);



        brand1.setBounds(100,100,50,50);
        this.getContentPane().add(brand1);

        brand2.setBounds(80,80,50,50);
        brand2.setGray(true);
        this.getContentPane().add(brand2);

        brand11.setBounds(170,170,50,50);
        brand11.setGray(false);
        this.getContentPane().add(brand11);

        brand111.setBounds(50,270,50,50);
        brand111.setGray(false);
        this.getContentPane().add(brand111);
        brand1111.setBounds(60,140,50,50);
        this.getContentPane().add(brand1111);
        brand3.setBounds(80,40,50,50);
        this.getContentPane().add(brand3);


        brand00.setBounds(0,575,450,800);
        this.getContentPane().add(brand00);

        brand0.setBounds(0,0,450,800);
        this.getContentPane().add(brand0);


        this.setVisible(true);







        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(40);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();

                }
            }
        }).start();

        try {
            new Music();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }

    }

//    @Override
//    public void paint(Graphics g) {
//
//
//       g.drawImage(brand0.getImage(),0,0,width,height,null);
//       g.drawImage(brand00.getImage(),11,650,null);
//       g.clearRect(0,0,width,height);
//
//
//    }



//    public static void main(String[] args) {
//        new TestBrand();
//    }

}
