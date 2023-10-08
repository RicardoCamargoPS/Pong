package com.pong.entidades;

import java.awt.Color;
import java.awt.Graphics;

public class Padle extends GameObjects {

    protected Color back, front;
    protected int dx = 0;
    protected boolean isMuving = false;
    protected double vel = 2;

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

    @Override
    public void setColor(Color back, Color front) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setColor'");
    }
    
}
