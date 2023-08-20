package com.pong.entidades;

import java.awt.Color;
import java.awt.Graphics;

import com.pong.game.Pong;

public class Player extends Padle {


public Player(int px, int py, Color back, Color front) {
    this.px = px;
    this.py = py;
    this.back = back;
    this.front = front;
    this.width = 50;
    this.height = 10;
}

    @Override
    public void update() {

        if(ladoEsq() <= Pong.campo.getPx() + 3){
            px = Pong.campo.getPx() + 3 ;
        }
        else if(ladoDir() - 3  >= Pong.campo.getWidth()){
            px = Pong.campo.getWidth() - width + 3;
        }
        if(isMuving){
            px += (int) dx * vel ;
        }
    }

    @Override
    public void render(Graphics g) {

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
