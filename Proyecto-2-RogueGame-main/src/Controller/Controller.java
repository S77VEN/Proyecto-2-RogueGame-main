package Controller;
import View.*;
import Model.*;
import java.awt.event.*;

import Common.Enemigo;
import Common.Hero;

public class Controller implements KeyListener{
    GameFieldView fieldView;
    GameModel gameModel;
    Hero personaje;
    int count;

    public Controller (){
        count = 0;
        fieldView = new GameFieldView();
        fieldView.addKeyListener(this);
        fieldView.setFocusable(true);

        gameModel = new GameModel();
        personaje = new Hero();
    }

    public void moveHero(){
        fieldView.ArrayField[personaje.getLastX()][personaje.getLastY()].clearBox();
        fieldView.ArrayField[personaje.getPosX()][personaje.getPosY()].setAsHero();
    }

    public void moveEnemy(Enemigo enemy){
        fieldView.ArrayField[enemy.getLastX()][enemy.getLastY()].clearBox();
        fieldView.ArrayField[enemy.getPosX()][enemy.getPosY()].setAsEnemy();
    }

    public void desaparecerEnemigo(Enemigo enemy){
        fieldView.ArrayField[enemy.getLastX()][enemy.getLastY()].clearBox();
        gameModel.eliminarEnemigo(enemy);
    }

    public boolean enemigoCerca (Enemigo enemy){
        int minX = personaje.getPosX() - 1;
        int minY = personaje.getPosY() - 1;
        int maxX = personaje.getPosX() + 1;
        int maxY = personaje.getPosY() + 1;

        if (enemy.getPosX() <= minX && enemy.getPosX() >= maxX && enemy.getPosY() <= minY && enemy.getPosY() >= maxY){
            return true;
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (personaje.getSalud() <= 0){
            System.exit(0);
        }
            

        System.out.println(e.getKeyChar());

        switch(e.getKeyChar()){
            case 'w':
                personaje.cambiarXY(-1, 0);
                moveHero();
                personaje.notificar();
                for (Enemigo enemy: gameModel.getEnemigos()){
                    enemy.cambiarXY();
                    moveEnemy(enemy);
                }
                count++;
                break;

            case 'a':
                personaje.cambiarXY(0, -1);
                moveHero();
                personaje.notificar();
                for (Enemigo enemy: gameModel.getEnemigos()){
                    enemy.cambiarXY(); 
                    moveEnemy(enemy);
                }
                count++;
                break;

            case 's':
                personaje.cambiarXY(1, 0);
                moveHero();
                personaje.notificar();
                for (Enemigo enemy: gameModel.getEnemigos()){
                    enemy.cambiarXY(); 
                    moveEnemy(enemy);
                }
                count++;
                break;

            case 'd':
                personaje.cambiarXY(0, 1);
                moveHero();
                personaje.notificar();
                for (Enemigo enemy: gameModel.getEnemigos()){
                    enemy.cambiarXY(); 
                    moveEnemy(enemy);
                }
                count++;
                break;

            case ' ':
                for (Enemigo enemy: gameModel.getEnemigos()){
                    if (enemigoCerca(enemy)){
                        System.out.println("Enemigo Cerca");
                        desaparecerEnemigo(enemy);
                    }
                }
                break;
            }

        for (Enemigo enemy: gameModel.getEnemigos()){
            if (enemy.getPosX() == personaje.getPosX() && enemy.getPosY() == personaje.getPosY() ){
                desaparecerEnemigo(enemy);
                personaje.disminuirSalud();
                moveHero();
            }
        }
            
        if (count >= 10){
            count = 0;
            for (int i = 0; i < 1; i++)
                personaje.anadirObservador(gameModel.enemyFactory());
                    
            for (Enemigo enemy: gameModel.getEnemigos()){
                moveEnemy(enemy);
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //Presionada
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Levantada
        
    }

}
