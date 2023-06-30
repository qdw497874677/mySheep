package com.org.util;


import java.awt.*;

/**
 * @author quandawei
 */
public class ImageUtil {

    public  static Image get(String fileName){
        return  Toolkit.getDefaultToolkit().getImage("imgs\\" + fileName);
    }

}
