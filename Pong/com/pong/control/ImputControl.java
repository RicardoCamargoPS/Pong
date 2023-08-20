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
			Pong.setGameStatos("dalay");	
			if(Pong.getGameStatos().equals("menu")){
				Pong.menu.enter = true;
			}			
		}
		
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {			
			Pong.setGameStatos("menu");
			Pong.menu.paused = true;
		}		

		if(e.getKeyCode() == KeyEvent.VK_UP) {
			if(Pong.getGameStatos().equals("menu")){
				Pong.menu.up = true;
			}	
		}

		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(Pong.getGameStatos().equals("menu")){
				Pong.menu.down = true;				
			}		
		}

		if(e.getKeyCode() == KeyEvent.VK_D) {	
			Pong.player.setMuving(true);
			Pong.player.mudaDir(1);				
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {	
			Pong.player.setMuving(true);
			Pong.player.mudaDir(-1);		
				 
		}
		if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			
		}
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_D) {
			Pong.player.setMuving(false);
			Pong.player.mudaDir(0);			
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			Pong.player.setMuving(false);
			Pong.player.mudaDir(0);
			
				 
		}	
	}
    
}
