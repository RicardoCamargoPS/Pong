package com.pong.gameObjects.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class UIScore{

    private String text = "";
    private int score = 0;
    private int px, py;
    private char orientacao;

    private Font font;

    public UIScore(int px, int py, char orientacao){
        this.px = px;
        this.py = py;
        this.text = "0";
        this.orientacao = orientacao;

        font = new Font("Courier New", Font.PLAIN, 16);
    }

    public void increaseScore(){
        this.score++;
    }

    public void update(){
        text = "" + score;      
        
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.setFont(font);

        if(orientacao == 'd'){
            g.drawString(text, px, py);
        }
        else{   
            int digitos = score / 10;
            if(digitos < 1){
                g.drawString(text, px, py);
            }
            else if(digitos >= 1 & digitos < 10 ){
                g.drawString(text, px - 10, py);
            }
            else if(digitos >= 10 & digitos < 100 ){
                g.drawString(text, px - 20, py);
            }
            else if(digitos >= 100 & digitos < 1000 ){
                g.drawString(text, px - 30, py);
            }
            else if(digitos >= 1000 & digitos < 10000 ){
                g.drawString(text, px - 40, py);
            }
            else if(digitos >= 10000 & digitos < 100000 ){
                g.drawString(text, px - 50, py);
            }
        }
        
    }
}