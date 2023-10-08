package com.pong.control;

import com.pong.entidades.Ball;
import com.pong.entidades.GameObjects;

public class Collision {

    boolean isIntersecting(GameObjects obj1, GameObjects obj2){
        return obj1.ladoDir() >= obj2.ladoEsq() &&
               obj1.ladoEsq() <= obj2.ladoDir() &&
               obj1.ladoBaixo() >= obj2.ladoCima() &&
               obj1.ladoCima() <= obj2.ladoBaixo();
    }

    public void testCollision(GameObjects padle, Ball bola){

        if(!isIntersecting(padle, bola)) return;

        double overLapLeft = bola.ladoDir() - padle.ladoEsq();
        double overLapRigth = padle.ladoDir() - bola.ladoEsq();
        //double overlapTop = bola.ladoBaixo() - padle.ladoCima();
		//double overlapBottom = padle.ladoBaixo() - bola.ladoCima();

        boolean ballFromLeft = overLapLeft < overLapRigth;
        //boolean ballFromTop = overlapTop < overlapBottom;

        bola.setDx(ballFromLeft ? -1 : 1);

        bola.setDy(-1);
        /*
        if(ballFromTop)
            bola.setDy(ballFromTop ? -1 : 1);
        else
            bola.setDy(ballFromTop ? 1 : -1);
        */

    }




    
}
