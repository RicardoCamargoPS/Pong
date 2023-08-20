package com.pong.control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.pong.game.Pong;

public class Menu {
    

    private int[] options = {0, 1, 2, 3 };

    // 0 = Novo Jogo  ou   Continuar  * se o jogo estiver pausado *
    // 1 = Carregar Jogo
    // 2 = Opições 
    // 3 = Sair

    private int currentOpitions = 0;
    private int maxOptions = options.length - 1;
    public boolean up, down, enter;

    public boolean paused = false;

    public void update(){
        if(up){
            up = false;
            currentOpitions--;
            if(currentOpitions < 0)
                currentOpitions = maxOptions;

        }
        if(down){
            down = false;
            currentOpitions++;
            if(currentOpitions > maxOptions)
                currentOpitions = 0;

        }

        if(enter){
            enter = false;
            if(options[currentOpitions] == 0) {
                Pong.setGameStatos("running");                
                paused = false;
               
            }
            else if(options[currentOpitions] == 3){
                System.exit(1);
            }

        }
    }

    public void render(Graphics g){

        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.ITALIC, 14));

        g.drawString("> Pong <", Pong.getWhidth() / 2 - 30, Pong.getHeight() - 200);

        g.setColor(Color.white);
        g.setFont(new Font("Courier New", Font.BOLD, 12));

        if(paused == false)

            g.drawString("Novo Jogo", Pong.getWhidth() / 2 - 25, 150);
        
        else
            g.drawString("Continuar", Pong.getWhidth() / 2 - 25, 150);

        g.drawString("Carregar Jogo", Pong.getWhidth() / 2 - 34, 170);
        g.drawString("Opções", Pong.getWhidth() / 2 - 20, 190);
        g.drawString("Sair", Pong.getWhidth() / 2 - 10, 210);

        g.setColor(new Color(50, 200, 50, 255));

        if(options[currentOpitions]  == 0){
            g.drawString(">", Pong.getWhidth() / 2 - 50, 150);
        }
        else if(options[currentOpitions] == 1){
             g.drawString(">", Pong.getWhidth() / 2 - 60, 170);
        }
        else if(options[currentOpitions] == 2){
             g.drawString(">", Pong.getWhidth() / 2 - 44, 190);
        }
         else if(options[currentOpitions] == 3){
             g.drawString(">", Pong.getWhidth() / 2 - 35, 210);
        }

        
    }


}
