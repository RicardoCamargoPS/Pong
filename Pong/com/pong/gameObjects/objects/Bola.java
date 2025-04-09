package com.pong.gameObjects.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import com.pong.gameObjects.GameObjects;
import com.pong.gameObjects.UI.Campo;

public class Bola extends GameObjects{

    public int dx, dy;
    private double vel = 6;
    private int ray = 9;
    private int campoLargura, campoPX, campoPY, campoALtura;

    public Bola() {

        campoLargura = Campo.getLargura();
        campoPX = Campo.getPx();
        campoPY = Campo.getPy();
        campoALtura = Campo.getAltura();

        Random random = new Random();
        dx = (random.nextBoolean()) ? 1 : -1;
        dy = (random.nextBoolean()) ? 1 : -1;
        
        setPosition(); 

        width = ray;
        height = ray;       

    }

    @Override
    public void update() {

        px += (int) dx * vel;
        py += (int) dy * vel;
        

        if(ladoDir()>= campoLargura){
            dx *= - 1;            
        }
        else if(ladoEsq() <= campoPX){
            dx *= - 1;
        }        
        
        if(ladoCima()  <= campoPY ){
            dy *= - 1;
        }        
        else if(ladoBaixo() > campoALtura + campoPY){
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
    public int getDy() {
        return dy;
    }

    public void setPosition(){       
        int y = campoPY;
        int width = campoLargura;
        int height = campoALtura;

        this.px = width / 2 - 3;
        this.py = y + height / 2 - 4;
    }

    public void rotacionar(){
        
        
         
    }

}
