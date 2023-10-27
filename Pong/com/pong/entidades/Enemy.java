package com.pong.entidades;

import java.awt.Color;
import java.awt.Graphics;

import com.pong.game.Pong;

public class Enemy extends GameObjects {

    private Color back, front;

    public Enemy(int px, int py) {
        this.px = px;
        this.py = py;
        back = new Color(139, 54, 38, 255);
        front = new Color(255, 99, 71, 255);      
       
        this.vel = 3;

        this.width = 10;
        this.height = 50;
    }

    @Override
    public void update(){


        if(ladoCima() <= Pong.campo.getPy() + 3){
            py = Pong.campo.getPy() + 3 ;
        }
        else if(ladoBaixo()  > Pong.campo.getHeight() + 10){
            py = Pong.campo.getHeight() - height + 10;
        }

        int dy = Pong.ball.getDy();

        py += dy * vel;


    }
    @Override
    public void render(Graphics g){
    
        g.setColor(back);
        g.fillRect(px, py, width, height);

        g.setColor(front);
        g.fillRect(px + 2, py + 2, width - 4, height - 4);
        
    }
    
    public int getPx(){
        return px;
    }

    public int getPy(){
        return py;
    }
}
