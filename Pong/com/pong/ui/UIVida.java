package com.pong.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class UIVida {

    private String text = "Vidas: ";
    private int vida = 3;
    private int px, py;
    private Font font;

    public UIVida(int px, int py) {
        this.px = px;
        this.py = py;
        font = new Font("Courier New", Font.PLAIN, 12);

    }

    public void updateVida(){
        text = "Vidas: " + vida;
    }

    public void icrementaVida(int quant){

        vida += quant;
        updateVida();

    }

    public void declementaVida(){
        vida--;
    }

    public void resetVidas(){
        vida = 3;
    }

    public void render(Graphics g){

        g.setColor(Color.white);
        g.setFont(font);

        g.drawString(text, px, py);
    }

    

}