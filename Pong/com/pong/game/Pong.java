package com.pong.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import com.pong.control.GameInitComponent;
import com.pong.control.MenuControle;
import com.pong.gameObjects.objects.Bola;
import com.pong.gameObjects.objects.Player;

public class Pong implements Runnable {

    private Window window;
    private BufferedImage layer;
    private int whidth, height;
    private boolean isRunning = true;
    private Thread thread;
    private static String status = "menu";

    public static MenuControle menu;
    public static Player player;
    public static Bola bola;
    


    public Pong() { 
        setInitComponentValue();
        window = new Window("Pong", whidth, height);
        //menu = new MenuControle();

        layer = new BufferedImage(whidth, height, BufferedImage.TYPE_INT_RGB);

        
        
    }

    public void update(){    
        
       
    }
    
    public void render(){

        BufferStrategy bs = window.getBufferStrategy();
        if(bs == null){
            window.createBufferStrategy();
            bs = window.getBufferStrategy();
        }

        Graphics g = layer.getGraphics();
        g.setColor(new Color(80, 80, 100, 255));
        g.fillRect(0, 0, whidth, height);


                
        g = bs.getDrawGraphics();
        g.drawImage(layer, 0, 0, whidth * window.getEscala(), height * window.getEscala(), null);

        g.dispose();
        bs.show();

    }

    @Override
    public void run() {


        int fps = 60;
		double timePerTick = 1000000000 / fps;
		double deltaTime = 0;

		long nowTime;
		long lastTime = System.nanoTime();

        while(isRunning){
            nowTime = System.nanoTime();
			deltaTime += (nowTime - lastTime) / timePerTick;
			lastTime = nowTime;

			if(deltaTime >= 1) {
                render(); 
                update();

               	deltaTime = 0;
            }
        }
        
    }

    public synchronized void start(){
        if(thread != null) return;
        else{
            thread = new Thread(this);   
            isRunning = true;         
        }
        thread.start();
        isRunning = true;
        
    }

    public void delay(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setDelay(){
        delay(1000);
    }

    private void setInitComponentValue(){
        whidth = GameInitComponent.getGameLargura();
        height = GameInitComponent.getGameAltura();
    }

    public static String getGameStatos() {
        return status;
    }

    public static void setGameStatos(String status) {
        Pong.status = status;    }
}
