package com.pong.ui;

import java.awt.Color;
import java.awt.Graphics;

import com.pong.game.Pong;

public class UIField {

    private int width, height;
    private int px = 5, py = 15;

    public UIField() {

        width = Pong.getWhidth() - 10;
        height = Pong.getHeight() - 20;

    }
    public void render(Graphics g){

        g.setColor(Color.black);
        g.fillRect(px, py, width, height);

        g.setColor(new Color(255, 150, 50, 200));
        g.drawLine(px, height / 2 + py, width + px - 1, height / 2 + py);

        g.setColor(new Color(0, 150, 0, 200));
        g.drawLine(width / 2 + px, py, width / 2 + px, height + py);

    }
    public int getPx() {
        return px;
    }
    public int getPy() {
        return py;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    
}
