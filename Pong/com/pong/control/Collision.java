package com.pong.control;

import com.pong.entidades.Bola;
import com.pong.entidades.GameObjects;
public class Collision {

    boolean isIntersecting(GameObjects obj1, GameObjects obj2) {
        return obj1.ladoDir() >= obj2.ladoEsq() &
                obj1.ladoEsq() <= obj2.ladoDir() &
                obj1.ladoBaixo() >= obj2.ladoCima() &
                obj1.ladoCima() <= obj2.ladoBaixo();
    }

    public void testCollision(GameObjects padle, Bola bola) {

        if (isIntersecting(padle, bola)) {
            bola.dy *= 1;

        } else
            return;

        if (bola.getPx() <= padle.getPx()) {
            bola.setDx(-1);
        }
        if (bola.getPx() >= padle.getPx()) {
            bola.setDx(1);

        }
    }

}
