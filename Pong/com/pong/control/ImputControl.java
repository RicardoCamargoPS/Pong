package com.pong.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.pong.game.Pong;

public class ImputControl implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
		
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			
			if(Pong.getGameStatos().equals("menu")){
				if (Pong.menu.getStatus() == 1) {
					Pong.menu.opcao.enter = true;					
				}
				else{
					Pong.menu.menu.enter = true;
				}
				
			}
			else if(Pong.getGameStatos().equals("paused")){
				Pong.menu.pause.enter = true;	
			}
			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {			
			Pong.setGameStatos("paused");
			
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {			
			Pong.menu.opcao.left = true;
			
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {			
			Pong.menu.opcao.rigth = true;
			
		}			

		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(Pong.getGameStatos().equals("menu")){

				if (Pong.menu.getStatus() == 0) {
					Pong.menu.menu.up = true;
				}
				else if (Pong.menu.getStatus() == 1){
					Pong.menu.opcao.up = true;	
					
				}
				
			}
			else if( Pong.getGameStatos().equals("paused")){
				Pong.menu.pause.up = true;
			
			}
		}

		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(Pong.getGameStatos().equals("menu")){
				if (Pong.menu.getStatus() == 0) {
					Pong.menu.menu.down = true;
				}
				else if (Pong.menu.getStatus() == 1){
					Pong.menu.opcao.down = true;	
					
				}
				
			}
			else if( Pong.getGameStatos().equals("paused")){
				Pong.menu.pause.down = true;
			
			}		
		}

		if(e.getKeyCode() == KeyEvent.VK_S) {	
			Pong.player.setMuving(true);
			Pong.player.mudaDir(1);				
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {	
			Pong.player.setMuving(true);
			Pong.player.mudaDir(-1);		
				 
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			
		}
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_S) {
			Pong.player.setMuving(false);
			Pong.player.mudaDir(0);			
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			Pong.player.setMuving(false);
			Pong.player.mudaDir(0);			 
		}	
	}
    
}
