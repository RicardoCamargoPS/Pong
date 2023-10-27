package com.pong.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.pong.control.Collision;
import com.pong.control.Window;
import com.pong.entidades.Ball;
import com.pong.entidades.Enemy;
import com.pong.entidades.Player;
import com.pong.ui.Menu;
import com.pong.ui.UIField;
import com.pong.ui.UIScore;

public class Pong implements Runnable {

    private Window window;
    private Thread thread;
    private BufferedImage layer;
    private boolean isRunning = false;
    private static int whidth = 400, height = 200;
    private static String gameStatos = "menu";

    private Collision collision;

  
    public static Menu menu;
    public static UIField campo;
    public UIScore playerScore, enemyScore;

    public static Ball ball;
    public static Player player;
    private Enemy enemy;
    


    public Pong() {       

        window = new Window("Pong", whidth, height);
        layer = new BufferedImage(whidth, height, BufferedImage.TYPE_INT_RGB); 
                
        menu = new Menu();
        campo = new UIField();
        player = new Player(6, height / 2 - 20);
        enemy = new Enemy(whidth - 16, height / 2 - 20);
        ball = new Ball();

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
