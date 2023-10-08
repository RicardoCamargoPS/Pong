package com.pong.entidades;

import java.awt.Color;
import java.awt.Graphics;

import com.pong.game.Pong;

public class Ball extends GameObjects{

    private int dx = 1, dy = -1;
    private double vel = 3;
    private int ray = 7;

    public Ball() {
        setPosition();

        width = ray;
        height = ray;       

    }

    @Override
    public void update() {

        px += (int) dx * vel;
        py += (int) dy * vel;

        

        if(ladoDir()>= Pong.campo.getWidth()){
            dx *= - 1;
            
        }
        else if(ladoEsq() <= Pong.campo.getPx()){
            dx *= - 1;
           
        } 

        if(px <= 3){
            px = Pong.campo.getPx() + 1;
        }
        if(px + width > Pong.campo.getWidth()){
             px = Pong.campo.getPx() - width;

        }
        
        if(ladoCima()  <= Pong.campo.getPy() ){
            dy *= - 1;
        }        
        else if(ladoBaixo() > Pong.campo.getHeight() + Pong.campo.getPy()){
            dy *= -1;
        }
        
    }

    @Override
    public void render(Graphics g) {

        g.setColor(new Color(255, 215, 0, 255));
        g.fillOval(px, py, ray, ray);

        g.setColor(new Color(255, 255, 224, 255));
        g.fillOval(px + 2, py, ray - 3, ray - 3);

        
       
    }
    public void setDx(int dx) {
        this.dx = dx;
    }
    public void setDy(int dx) {
        this.dy *= dx;
    }

    public int getPx(){
        return px;
    }
    public int getDx() {
        return dx;
    }

    public void setPosition(){


        int x = Pong.campo.getPx();
        int y = Pong.campo.getPy();
        int width = Pong.campo.getWidth();
        int height = Pong.campo.getHeight();

        this.px = x + width / 2 - 4;
        this.py = y + height / 2 - 4;

        System.out.println(x +  "\n" + y);
    }

    @Override
    public void setColor(Color back, Color front) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setColor'");
    }
    
}
