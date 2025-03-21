package com.pong.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.pong.control.Collision;
import com.pong.control.MenuControle;
import com.pong.control.Window;
import com.pong.gameObjects.UI.UIField;
import com.pong.gameObjects.UI.UIScore;
import com.pong.gameObjects.objects.Bola;
import com.pong.gameObjects.objects.Raquete;

public class Pong implements Runnable {

    private Window window;
    private Thread thread;
    private BufferedImage layer;
    private boolean isRunning = false;
    private static int whidth = 400, height = 200;
    private static String gameStatos = "menu";

    private Collision collision;

  
    public static MenuControle menu;
    public static UIField campo;
    public UIScore playerScore, enemyScore;
    public static Raquete player;
    public Raquete enemy;
    public static Bola ball;  
    


    public Pong() {       

        window = new Window("Pong", whidth, height);
        layer = new BufferedImage(whidth, height, BufferedImage.TYPE_INT_RGB); 
                
        menu = new MenuControle();
        campo = new UIField();
        player = new Raquete(6, height / 2 - 30, Color.blue, false);
        enemy = new Raquete(whidth - 13, height / 2 - 30, Color.red, true);
        ball = new Bola();

        playerScore = new UIScore((whidth - 10) / 2 - 20, 13, 'e');
        enemyScore = new UIScore((whidth - 10) / 2 + 10, 13, 'd');
        collision = new Collision();
    
    }

    public void update(){    
        
        if(gameStatos == "normal"){

            player.update(); 
            enemy.update();           
            ball.update();
            playerScore.update();
            enemyScore.update();
            collision.testCollision(enemy, ball);
            collision.testCollision(player, ball);       
        }

        if(gameStatos =="menu"){
            menu.update();
        }
        if(gameStatos =="paused"){
            menu.setMenu(2);
            menu.update();
        }

        if(gameStatos == "dalay"){
            delay(1000);
            gameStatos = "normal";
        }
        
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

        
        campo.render(g);
        player.render(g);
        enemy.render(g);
        ball.render(g);
        playerScore.render(g);
        enemyScore.render(g);


        if(gameStatos == "menu"){
            menu.render(g);
        }
        if(gameStatos =="paused"){
            menu.render(g);
        }

                
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

    public static int getHeight() {
        return height;
    }
    public static int getWhidth() {
        return whidth;
    }

    public static String getGameStatos() {
        return gameStatos;
    }
    public static void setGameStatos(String gameStatos) {
        Pong.gameStatos = gameStatos;
    }
    
}
