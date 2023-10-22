package com.pong.entidades;

import java.awt.Color;
import java.awt.Graphics;

public class Padle extends GameObjects {

    protected Color back, front;
    protected int dx = 0;
    protected boolean isMuving = false;
    
    
    public Padle(){
        this.width = 10;
        this.height = 50;
    }

    @Override
    public void update() {
        
    }

    @Override
    public void render(Graphics g) {
        
    }
    public void setVel(double vel) {
        this.vel = vel;
    }
    public void setMuving(boolean isMuving) {
        this.isMuving = isMuving;
    }

    public void mudaDir(int dx){
        this.dx =  dx;
    }

    public int getWhidth(){
        return width;
    }
}
