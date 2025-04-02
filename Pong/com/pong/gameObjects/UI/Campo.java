package com.pong.gameObjects.UI;

import java.awt.Color;
import java.awt.Graphics;

import com.pong.game.Pong;

public class Campo {

    private static int Largura;
    private static int altura;
    private static int px = 5, py = 15;

    public Campo() {

        Largura = Pong.getWhidth() - 10;
        altura = Pong.getHeight() - 20;
    

    }
    public void render(Graphics g){

        g.setColor(Color.black);
        g.fillRect(px, py, Largura, altura);

        g.setColor(new Color(255, 150, 50, 100));
        g.drawLine(Largura / 2, py, Largura / 2, altura + py - 1);
               
    }
    public static int getPx() {
        return px;
    }
    public static int getPy() {
        return py;
    }
    public static int getLargura() {
        return Largura;
    }
    public static int getAltura() {
        return altura;
    }
    
}
