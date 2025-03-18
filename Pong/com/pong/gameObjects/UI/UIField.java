package com.pong.gameObjects.UI;

import java.awt.Color;
import java.awt.Graphics;

import com.pong.game.Pong;

public class UIField {

    private int whidth, height;
    private int px = 5, py = 15;

    public UIField() {

        whidth = Pong.getWhidth() - 10;
        height = Pong.getHeight() - 20;
    

    }
    public void render(Graphics g){

        g.setColor(Color.black);
        g.fillRect(px, py, whidth, height);

        g.setColor(new Color(255, 150, 50, 100));
        g.drawLine(whidth / 2, py, whidth / 2, height + py - 1);
               
    }
    public int getPx() {
        return px;
    }
    public int getPy() {
        return py;
    }
    public int getWidth() {
        return whidth;
    }
    public int getHeight() {
        return height;
    }
    
}
