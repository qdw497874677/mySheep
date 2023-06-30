package com.bjsxt.model;

import com.bjsxt.util.ImageUtil;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 音乐
 */
public class Music {
    public Music() throws FileNotFoundException, JavaLayerException {
        Player player;
        String str = System.getProperty("user.dir") + "/Music/music.mp3";
        BufferedInputStream name = new BufferedInputStream(new FileInputStream(str));
        player = new Player(name);

        player.play();
    }
}
