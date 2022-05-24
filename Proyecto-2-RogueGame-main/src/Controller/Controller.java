package Controller;
import View.*;
//import Common.*;
import Model.*;
import java.awt.event.*;

import Common.Hero;

public class Controller implements KeyListener{
    GameFieldView fieldView;
    GameModel gameModel;
    Hero personaje;
    int count;

    public Controller (){
        count = 0;
        fieldView = new GameFieldView();
        gameModel = new GameModel();
        personaje = new Hero();
        
        fieldView.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());

        switch(e.getKeyChar()){
            case 'w':
                personaje.cambiarXY(0, -1);
                count++;
                break;
            case 'a':
                personaje.cambiarXY(-1, 0);
                count++;
                break;
            case 's':
                personaje.cambiarXY(0, 1);
                count++;
                break;
            case 'd':
                personaje.cambiarXY(1, 0);
                count++;
                break;
        }

        if (count >= 5) {
            count = 0;
        }
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Presionada
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Levantada
        
    }

}
