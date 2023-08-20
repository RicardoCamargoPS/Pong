package com.pong.control;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

public class Window {

    private JFrame janela;
    private Canvas canvas;
    private ImputControl controle;
    private final int escala = 3;


    public Window(String titulo, int whidth, int height) {
        canvas = new Canvas();
        controle = new ImputControl();

        canvas.setSize(new Dimension(whidth * escala, height * escala));
        canvas.setFocusable(false);

        janela = new JFrame(titulo);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        
        
        janela.addKeyListener(controle);
        janela.add(canvas);
        janela.pack();
        
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);

    }


    public BufferStrategy getBufferStrategy(){  
        return canvas.getBufferStrategy();
    }

    public void createBufferStrategy(){
        canvas.createBufferStrategy(3);
    }

    public int getEscala() {
        return escala;
    }
    
}
