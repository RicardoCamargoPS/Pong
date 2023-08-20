package com.pong.entidades;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObjects extends Rectangle {

    protected int px, py, width, height;
    

    abstract public void update();

    abstract public void render(Graphics g);
   

    public int ladoDir(){
        return px + width;
    }
    public int ladoEsq(){
        return px;
    }
    public int ladoCima(){
        return py;
    }
    public int ladoBaixo(){
        return py + height;
    }
    
}
