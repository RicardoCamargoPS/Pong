package com.pong.gameObjects.objects;

import java.awt.Color;
import java.awt.Graphics;
import com.pong.game.Pong;
import com.pong.gameObjects.GameObjects;
import com.pong.gameObjects.UI.Campo;

public class Raquete extends GameObjects {

    private Color cor;
    private boolean isMuving = false;
    private int dy = 0;
    private int vel = 3;
    private boolean movi_IA;
    private int campoPY, campoALtura;
    private Color playerBack, playerFront;
    private Color enemyBack, enemyFront;


    public Raquete(int px, int py, Color cor, boolean movi_IA) {

        playerBack = new Color(0, 0, 128, 255);
        playerFront = new Color(65, 105, 225, 255); 
        enemyBack  = new Color(139, 54, 38, 255);
        enemyFront = new Color(255, 99, 71, 255); 
        
        campoPY = Campo.getPy();
        campoALtura = Campo.getAltura();

        this.px = px;
        this.py = py;
        this.cor = cor;
        this.width = 7;
        this.height = 60;
        this.movi_IA = movi_IA;
    }

    @Override
    public void update() {

        if (ladoCima() <= campoPY + 3) {
            py = campoPY + 3;
        } else if (ladoBaixo() > campoALtura + 10) {
            py = campoALtura - height + 10;
        }

        if (movi_IA) {
            int dy = Pong.bola.getDy();
            py += dy * vel;
            
        }

        else {
            if (isMuving) {
                py += (int) dy * vel;
            }            

        }
        

    }

    @Override
    public void render(Graphics g) {

        if (movi_IA) {
            g.setColor(enemyBack);
            g.fillRect(px, py, width, height);

            g.setColor(enemyFront);
            g.fillRect(px + 2, py + 2, width - 4, height - 4);
            
        }

        else {
            g.setColor(playerBack);
            g.fillRect(px, py, width, height);

            g.setColor(playerFront);
            g.fillRect(px + 2, py + 2, width - 4, height - 4);       

        }

    }

    public void setMuving(boolean isMuving) {
        this.isMuving = isMuving;
    }

    public void mudaDir(int dir) {
        this.dy = dir;
    }

    public int getPx() {
        return px;
    }

    public int getPy() {
        return py;
    }
}
