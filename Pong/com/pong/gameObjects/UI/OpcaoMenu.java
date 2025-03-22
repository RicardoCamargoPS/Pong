package com.pong.gameObjects.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.pong.game.Pong;

public class OpcaoMenu {
    private int px =  (Pong.getWhidth() - 10) / 2;
    private int py = 200;
    private int volume = 50, partidas = 1, tempo = 2;
   
    
    

    private int[] options = {0, 1, 2, 3 };

    // 0 = Numero de partidas
    // 1 = Tempo das partidas
    // 2 = Volume do jogo 
    // 3 = Voltar

    private int currentOpitions = 0;
    private int maxOptions = options.length - 1;
    public boolean up, down, left, rigth, enter;

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
        if(rigth){
            rigth = false;
            switch (currentOpitions) {
                case 0:
                if(partidas < 5){
                    partidas++;                    
                }                
                break;

                case 1:
                if(tempo < 20){
                    tempo += 2;
                }
                break;

                case 2:
                if (volume < 100) {
                    volume++;                    
                }
                break;
                default:
                break;

            
            }

        }
        if(left){
            left = false;
            switch (currentOpitions) {
                case 0:
                if(partidas > 1){
                    partidas--;                    
                }                
                break;

                case 1:
                if(tempo > 2){
                    tempo -= 2;
                }
                break;

                case 2:
                if (volume > 1) {
                    volume--;                    
                }
                break;
                default:
                break;

            }

            
        }

        if(enter){
            enter = false;
            if(options[currentOpitions] == 0) {
                Pong.setGameStatos("normal");                
                paused = false;
               
            }
            else if(options[currentOpitions] == 3){
                Pong.menu.setMenu(0);
            }

        }
    }

    public void render(Graphics g){

        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.ITALIC, 14));          
        g.drawString("> Configuração <", px - 55, py - 160);

        g.setFont(new Font("Courier New", Font.PLAIN, 12)); 
        
        g.drawString("Partidas", px - 55, py - 120);        
        g.drawString("" + partidas, px + 35, py - 120);

        g.drawString("Tempo", px - 55, py - 100);
        if (tempo < 10) {
            g.drawString("" + tempo, px + 35, py - 100);
        }else if (tempo >= 10) {
            g.drawString("" + tempo, px + 31, py - 100);
        }
        g.drawString("Volume", px - 55, py - 80);
        if (volume < 10) {
            g.drawString("" + volume, px + 35, py - 80);
        }else if (volume >= 10 & volume <= 99) {
            g.drawString("" + volume, px + 31, py - 80);
        }
        else if (volume == 100 ) {
            g.drawString("" + volume, px + 28, py - 80);
        }
        
        g.drawString("Voltar", px - 30, py - 40);

        g.setColor(new Color(50, 200, 50, 255));

        if(options[currentOpitions]  == 0){
            g.drawString("<", px + 20, py - 120);
            g.drawString(">", px + 50, py - 120);
        }
        else if(options[currentOpitions] == 1){
            g.drawString("<", px + 20, py - 100);
            g.drawString(">", px + 50, py - 100);
        }
        else if(options[currentOpitions] == 2){
            g.drawString("<", px + 20, py - 80);
            g.drawString(">", px + 50, py - 80);
        }        
         else if(options[currentOpitions] == 3){
            g.drawString("<", px - 45, py - 40);
            g.drawString(">", px + 20, py - 40);
        }

        
    }

}
