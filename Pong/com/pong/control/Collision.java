package com.pong.control;

import java.util.Random;

import com.pong.entidades.Ball;
import com.pong.entidades.GameObjects;

public class Collision {
     Random random = new Random();

    boolean isIntersecting(GameObjects obj1, GameObjects obj2){
        return obj1.ladoDir() >= obj2.ladoEsq() &&
               obj1.ladoEsq() <= obj2.ladoDir() &&
               obj1.ladoBaixo() >= obj2.ladoCima() &&
               obj1.ladoCima() <= obj2.ladoBaixo();
    }

    public void testCollision(GameObjects padle, Ball bola){

        if(isIntersecting(padle, bola)){
           
            bola.setDy((random.nextBoolean()) ? -1 : 1);

        } else
            return;     

        if(bola.getPx() <= padle.getPx()){
            bola.setDx(-1);  
        }
        if(bola.getPx() >= padle.getPx()){
            bola.setDx(1);

        }
    }
    
}
