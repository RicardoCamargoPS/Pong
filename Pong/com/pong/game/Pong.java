package com.pong.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.pong.control.Collision;
import com.pong.control.Menu;
import com.pong.control.Window;
import com.pong.entidades.Ball;
import com.pong.entidades.Enemy;
import com.pong.entidades.Player;
import com.pong.ui.UIField;

public class Pong implements Runnable {

    private Window window;
    private Thread thread;
    private BufferedImage layer;
    private boolean isRunning = false;
    private static int whidth = 200, height = 300;
    private static String gameStatos = "menu";

    private Collision collision;

  
    public static Menu menu;
    public static UIField campo;

    public static Ball ball;
    public static Player player;
    private Enemy enemy;
    


    public Pong() {
        Color playerBackColor = new Color(0, 0, 128, 255);
        Color playerFronColor = new Color(65, 105, 225, 255);

        Color enemyBackColor = new Color(139, 54, 38, 255);
        Color enemyFronColor = new Color(255, 99, 71, 255);

        window = new Window("Pong", whidth, height);
        layer = new BufferedImage(whidth, height, BufferedImage.TYPE_INT_RGB);

       collision = new Collision();

        menu = new Menu();
        campo = new UIField();       
        player = new Player(whidth / 2 - 20 , height - 20, playerBackColor, playerFronColor);
        enemy = new Enemy(campo.getWidth() / 2 - 20, campo.getPy() + 4, enemyBackColor, enemyFronColor);
        ball = new Ball();
    }

    
    
    public void update(){      

        if(gameStatos.equals("running")){

            enemy.update();
            player.update();
            ball.update();            
            collision.testCollision(player, ball);
            collision.testCollision(enemy, ball);
        
        }
        else if(gameStatos.equals("menu")){
            menu.update();           
            //todo update dos game objects aqui
        }
        else if(gameStatos.equals("gameOver")){

        }
        else if(gameStatos.equals("dalay")){                      
            delay(1000);
            gameStatos = "running";
           
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
           
            ball.render(g);
            player.render(g);
            enemy.render(g);
            

        if(gameStatos.equals("gameOver")){

        }
        else if(gameStatos.equals("menu")){
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
