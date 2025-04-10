package com.pong.gameObjects.objects;

import java.awt.Color;
import java.awt.Graphics;
import com.pong.gameObjects.GameObjects;
import com.pong.gameObjects.UI.Campo;

public class Player extends GameObjects {

    private Color back, front;
    private boolean isMuving = false;
    private int dy = 0;
    private int vel = 3;
    private int campoPY, campoALtura;


public Player(int px, int py) {

    campoPY = Campo.getPy();
    campoALtura = Campo.getAltura();

    this.px = px;
    this.py = py;
    back = new Color(0, 0, 128, 255);
    front = new Color(65, 105, 225, 255);    
    this.width = 10;
    this.height = 90;
}

    @Override
    public void update() {

        if(ladoCima() <= campoPY + 3){
            py = campoPY + 3 ;
        }
        else if(ladoBaixo()  > campoALtura + 10){
            py = campoALtura - height + 10;
        }
        if(isMuving){
            py += (int) dy * vel ;
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
        this.dy =  dir;
    }
    public int getPx(){
        return px;
    }
    public int getPy(){
        return py;
    }
     
}
