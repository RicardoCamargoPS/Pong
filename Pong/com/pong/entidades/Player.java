package com.pong.entidades;

import java.awt.Color;
import java.awt.Graphics;

import com.pong.game.Pong;

public class Player extends GameObjects {

    private Color back, front;
    private boolean isMuving = false;
    private int dx = 0;
    private int vel = 2;


public Player(int px, int py) {
    this.px = px;
    this.py = py;
    back = new Color(0, 0, 128, 255);
    front = new Color(65, 105, 225, 255);    
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
    public void setMuving(boolean isMuving) {
        this.isMuving = isMuving;
    }    
    public void mudaDir(int dir){
        this.dx =  dir;
    }
    public int getPx(){
        return px;
    }
    public int getPy(){
        return py;
    }

    @Override
    public void setColor(Color back, Color front) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setColor'");
    }
    
}
