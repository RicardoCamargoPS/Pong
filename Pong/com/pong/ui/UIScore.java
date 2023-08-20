package com.pong.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class UIScore{

    private String text = "Score: ";
    private int score = 0;
    private int px, py;

    private Font font;

    public UIScore(int px, int py){
        this.px = px;
        this.py = py;

        font = new Font("Courier New", Font.PLAIN, 12);
    }

    public void updateScore(){
        text = "Score: " + score;
    }

    public void increaseScore(int score){
        this.score += score;
        updateScore();
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.setFont(font);
        g.drawString(text, px, py);
    }
}