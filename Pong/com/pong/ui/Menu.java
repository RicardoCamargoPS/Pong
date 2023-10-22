package com.pong.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.pong.game.Pong;

public class Menu {

    private int px =  Pong.getWhidth() / 2;
    private int py = 200;
    
    

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
        
        g.drawString("> Pong <", px - 29, py - 180);

        g.setColor(Color.white);
        g.setFont(new Font("Courier New", Font.BOLD, 12));      

        if(paused == false)
            g.drawString("Novo Jogo", px - 31, py - 150);
        
        else
            g.drawString("Continuar", px - 31, py * 150);

        g.drawString("Carregar Jogo", px - 44, py - 130);
        g.drawString("Opções", px - 20, py - 110);
        g.drawString("Sair", px - 13, py - 90);

        g.setColor(new Color(50, 200, 50, 255));

        if(options[currentOpitions]  == 0){
            g.drawString(">", px - 50, py - 150);
        }
        else if(options[currentOpitions] == 1){
             g.drawString(">", px - 60, py - 130);
        }
        else if(options[currentOpitions] == 2){
             g.drawString(">", px - 44, py - 110);
        }
         else if(options[currentOpitions] == 3){
             g.drawString(">", px - 35, py - 90);
        }

        
    }


}