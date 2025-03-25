package com.pong.gameObjects.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.pong.game.Pong;

public class PauseMenu {

    private int px =  (Pong.getWhidth() - 10) / 2;
    private int py = 200;

    private int[] options = {0, 1, 2, 3};

    // 0 = Continuar 
    // 1 = Reiniciar  
    // 2 = Opições 
    // 3 = Voltar menu principal 

    private int currentOpitions = 0;
    private int maxOptions = options.length - 1;
    public boolean up, down, enter;

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
                Pong.setGameStatos("normal");
                //Pong.setDelay();               
            }
            else if(options[currentOpitions] == 1){
                
                
            }
            else if(options[currentOpitions] == 2){
                Pong.setGameStatos("menu");
                Pong.menu.setMenu(1);
                
            }
            else if(options[currentOpitions] == 3){
                
            }

        }
    }

    public void render(Graphics g){

        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.ITALIC, 14));          
        g.drawString("> Pause <", px - 29, py - 160);

        g.setFont(new Font("Courier New", Font.PLAIN, 12));      

        
        g.drawString("Continuar", px - 31, py - 120);
        g.drawString("Reiniciar", px - 31, py - 100);
        g.drawString("Opções", px - 31, py - 80);
        g.drawString("Sair", px - 31, py - 60);

        g.setColor(new Color(50, 200, 50, 255));

        if(options[currentOpitions]  == 0){
            g.drawString(">", px - 50, py - 120);
        }
        else if(options[currentOpitions] == 1){
             g.drawString(">", px - 50, py - 100);
        }
        else if(options[currentOpitions] == 2){
             g.drawString(">", px - 50, py - 80);
        }
         else if(options[currentOpitions] == 3){
             g.drawString(">", px - 50, py - 60);
        }

        
    }


}
