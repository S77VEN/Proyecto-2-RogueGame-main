package Controller;
import View.*;
import Model.*;
import java.awt.event.*;

import Common.Aliado;
import Common.Enemigo;
import Common.Hero;

public class Controller implements KeyListener{
    GameFieldView fieldView;
    GameModel gameModel;
    Hero personaje;
    int countAlly;
    int ultimaDireccion;
    int count;
    int turno;


    public Controller (){
        count = 0;
        turno = 0;
        countAlly = 0;
        ultimaDireccion = 0;

        fieldView = new GameFieldView();
        fieldView.addKeyListener(this);
        fieldView.setFocusable(true);

        gameModel = new GameModel();
        personaje = new Hero();
    }

    public boolean comprobarCasilla (int newX, int newY){
        if (newX == personaje.getPosX() && newY == personaje.getPosY()){
            return false;
        }
        for (Enemigo enemy: gameModel.getEnemigos()){
            if (newX == enemy.getPosX() && newY == enemy.getPosY()){
                return false;
            }
        }
        for (Aliado ally: gameModel.getAliados()){
            if (newX == ally.getPosX() && newY == ally.getPosY()){
                return false;
            }
        }
        return true;
    }

    public void enemigoEncima (){
        for (Enemigo enemy: gameModel.getEnemigos()){
            if (enemy.getPosX() == personaje.getPosX() && enemy.getPosY() == personaje.getPosY() ){
                desaparecerEnemigo(enemy);
                personaje.disminuirSalud();
                moveHero();
            }
        }
    }

    public void aliadoEncima (){
        for (Aliado ally: gameModel.getAliados()){
            if (ally.getPosX() == personaje.getPosX() && ally.getPosY() == personaje.getPosY()){
                desaparecerAliado(ally);
                personaje.aumentarSalud();
                moveHero();
            }
        }
    }

    public int RandomCoords (){
        return (int) Math.round(Math.random()*15 + 5);
    }

    public void moveHero(){
        fieldView.ArrayField[personaje.getLastX()][personaje.getLastY()].clearBox();
        fieldView.ArrayField[personaje.getPosX()][personaje.getPosY()].setAsHero(personaje.getSalud());
        personaje.notificar();
    }

    public void moveEnemy(Enemigo enemy){
        fieldView.ArrayField[enemy.getLastX()][enemy.getLastY()].clearBox();
        fieldView.ArrayField[enemy.getPosX()][enemy.getPosY()].setAsEnemy();
    }

    public void drawAlly(Aliado ally){
        fieldView.ArrayField[ally.getPosX()][ally.getPosY()].setAsAlly();
    }

    public void desaparecerEnemigo(Enemigo enemy){
        fieldView.ArrayField[enemy.getPosX()][enemy.getPosY()].clearBox();
        gameModel.eliminarEnemigo(enemy);
    }

    public void desaparecerAliado(Aliado ally){
        fieldView.ArrayField[ally.getPosX()][ally.getPosY()].clearBox();
        gameModel.eliminarAliado(ally);
    }

    public boolean enemigoCerca (Enemigo enemy){
        if (ultimaDireccion == 0){
            if (enemy.getPosX() == personaje.getPosX() - 1 && enemy.getPosY() == personaje.getPosY() ) {
                return true;
            }
            else{return false;}
        }
        else if (ultimaDireccion == 1){
            if (enemy.getPosY() == personaje.getPosY() - 1 && enemy.getPosX() == personaje.getPosX()){
                return true;
            }
            else{return false;}
        }
        else if (ultimaDireccion == 2){
            if (enemy.getPosX() == personaje.getPosX() + 1 && enemy.getPosY() == personaje.getPosY()){
                return true;
            }
            else{return false;}
        }
        else if (ultimaDireccion == 3){
            if (enemy.getPosY() == personaje.getPosY() + 1 && enemy.getPosX() == personaje.getPosX()){
                return true;
            }
            else{return false;}
        }
        else{return false;}

    }

    public boolean aliadoCerca (Aliado ally){
        int diferenciaX = Math.abs(personaje.getPosX() - ally.getPosX());
        int diferenciaY = Math.abs(personaje.getPosY() - ally.getPosY());

        if ((diferenciaX == 2  || diferenciaX == 1 || diferenciaX == 0) && ( diferenciaY == 2 || diferenciaY == 1  || diferenciaY == 0)){
            return true;
        }
        return false;
        
    }

    public void crearEnemigo (){
        int newX = RandomCoords();
        int newY = RandomCoords();
        while(comprobarCasilla(newX, newY) == false){
            newX = RandomCoords();
            newY = RandomCoords();
        }

        Enemigo newEnemy = gameModel.enemyFactory(newX, newY);
        personaje.anadirObservador(newEnemy);
    
    }

    public void crearAliado(){
        int newX = RandomCoords();
        int newY = RandomCoords();
        while (comprobarCasilla(newX, newY) == false){
            newX = RandomCoords();
            newY = RandomCoords();
        }
        gameModel.allyFactory(newX, newY);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());

        switch(e.getKeyChar()){
            case 'w':
                personaje.cambiarXY(-1, 0);
                moveHero();
                for (Enemigo enemy: gameModel.getEnemigos()){
                    enemy.cambiarXY(); 
                    moveEnemy(enemy);
                }
                ultimaDireccion = 0;
                count++;
                break;

            case 'a':
                personaje.cambiarXY(0, -1);
                moveHero();
                for (Enemigo enemy: gameModel.getEnemigos()){
                    enemy.cambiarXY(); 
                    moveEnemy(enemy);
                }
                ultimaDireccion = 1;
                count++;
                break;

            case 's':
                personaje.cambiarXY(1, 0);
                moveHero();
                for (Enemigo enemy: gameModel.getEnemigos()){
                    enemy.cambiarXY(); 
                    moveEnemy(enemy);
                }
                ultimaDireccion = 2;
                count++;
                break;

            case 'd':
                personaje.cambiarXY(0, 1);
                moveHero();
                for (Enemigo enemy: gameModel.getEnemigos()){
                    enemy.cambiarXY(); 
                    moveEnemy(enemy);
                }
                ultimaDireccion = 3;
                count++;
                break;

            case ' ':
                for (Enemigo enemy: gameModel.getEnemigos()) {
                    if (enemigoCerca(enemy)){
                        desaparecerEnemigo(enemy);
                    }
                }
                break;
            }

        

        enemigoEncima();
        aliadoEncima();

        for (Aliado ally: gameModel.getAliados()){
            if (aliadoCerca(ally)){
                drawAlly(ally);
            }
        }
            
        if (count >= 10){
            count = 0;
            crearEnemigo();
            if (countAlly < 10){
                crearAliado();
                countAlly++;
            }
            for (Enemigo enemy: gameModel.getEnemigos()){
                moveEnemy(enemy);
            }
        }
        if (personaje.getSalud() <= 0){
            System.exit(0);
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
