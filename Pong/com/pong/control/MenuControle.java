package com.pong.control;

import java.awt.Graphics;

import com.pong.gameObjects.UI.Menu;
import com.pong.gameObjects.UI.OpcaoMenu;
import com.pong.gameObjects.UI.PauseMenu;

public class MenuControle {

    public Menu menu;
    public OpcaoMenu opcao;
    public PauseMenu pause;

    private int status = 0;

    // Status
    //0 -- Menu principal
    //1 -- Menu de opções
    //2 -- Menu de pause

    public MenuControle() {
        menu = new Menu();
        opcao = new OpcaoMenu();
        pause = new PauseMenu();

    }

    public void setMenuStatus(int status){
        this.status = status;

    }
    public int getStatus(){
        return status;
    }

    public void update(){

        if(status == 0){
            menu.update();
        }
        else if (status == 1){
            opcao.update();
        }
        else{
            pause.update();
        }
    }


    public void render(Graphics g){

        if(status == 0){
            menu.render(g);
        }
        else if (status == 1){
            opcao.render(g);
        }
        else{
            pause.render(g);
        }

    }

   
}
