package com.pong.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class UIScore{

    private String text = "";
    private int score = 0;
    private int px, py;

    private Font font;

    public UIScore(int px, int py, String text){
        this.px = px;
        this.py = py;
        this.text = text + " Score: ";

        font = new Font("Courier New", Font.PLAIN, 10);
    }

    public void increaseScore(){
        this.score++;
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(text, px, py);
    }
}