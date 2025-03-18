package com.pong.gameObjects.objects;

import java.awt.Color;
import java.awt.Graphics;
import com.pong.game.Pong;
import com.pong.gameObjects.GameObjects;

public class Raquete extends GameObjects {

    private Color cor;
    private boolean isMuving = false;
    private int dy = 0;
    private int vel = 3;
    private boolean movi_IA;

    public Raquete(int px, int py, Color cor, boolean movi_IA) {
        this.px = px;
        this.py = py;
        this.cor = cor;
        // back = new Color(0, 0, 128, 255);
        // front = new Color(65, 105, 225, 255);
        this.width = 7;
        this.height = 60;
        this.movi_IA = movi_IA;
    }

    @Override
    public void update() {

        if (ladoCima() <= Pong.campo.getPy() + 3) {
            py = Pong.campo.getPy() + 3;
        } else if (ladoBaixo() > Pong.campo.getHeight() + 10) {
            py = Pong.campo.getHeight() - height + 10;
        }

        if (!movi_IA) {

            if (isMuving) {
                py += (int) dy * vel;
            }
        }

        else {
            int dy = Pong.ball.getDy();
            py += dy * vel;

        }

    }

    @Override
    public void render(Graphics g) {

        g.setColor(cor);
        g.fillRect(px, py, width, height);

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
