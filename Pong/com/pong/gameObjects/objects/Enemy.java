package com.pong.gameObjects.objects;

import java.awt.Color;
import java.awt.Graphics;

import com.pong.game.Pong;
import com.pong.gameObjects.GameObjects;
import com.pong.gameObjects.UI.Campo;

public class Enemy extends GameObjects {
    
    private int campoPY, campoALtura;


    private Color back, front;
    private int vel = 3;

    public Enemy(int px, int py) {
        
        campoPY = Campo.getPy();
        campoALtura = Campo.getAltura();


        this.px = px;
        this.py = py;
        back = new Color(139, 54, 38, 255);
        front = new Color(255, 99, 71, 255);        
        this.vel = 3;

        this.width = 10;
        this.height = 60;
    }

    @Override
    public void update(){


        if(ladoCima() <= campoPY + 3){
            py = campoPY + 3 ;
        }
        else if(ladoBaixo()  > campoALtura + 10){
            py = campoALtura - height + 10;
        }

        int dy = Pong.bola.getDy();

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
