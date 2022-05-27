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
    int count;
    int turno;


    public Controller (){
        count = 0;
        turno = 0;

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
            if (ally.getPosX() == personaje.getPosX() && ally.getPosY() == personaje.getPosY() ){
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
        int diferenciaX = Math.abs(personaje.getPosX() - enemy.getPosX());
        int diferenciaY = Math.abs(personaje.getPosY() - enemy.getPosY());

        if ((diferenciaX == 1  || diferenciaX == 0) && (diferenciaY == 1  || diferenciaY == 0)){
            return true;
        }
        return false;
    }

    public boolean aliadoCerca (Aliado ally){
        int diferenciaX = Math.abs(personaje.getPosX() - ally.getPosX());
        int diferenciaY = Math.abs(personaje.getPosY() - ally.getPosY());

        if ((diferenciaX == 1  || diferenciaX == 0) && (diferenciaY == 1  || diferenciaY == 0)){
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
        System.out.print("\033[H\033[2J");
        System.out.println(e.getKeyChar());

        switch(e.getKeyChar()){
            case 'w':
                if (turno == 0){
                    personaje.cambiarXY(-1, 0);
                    moveHero();
                    personaje.notificar();
                    turno = 1;
                    count++;
                }
                else if (turno == 1){
                    personaje.notificar();
                    for (Enemigo enemy: gameModel.getEnemigos()){
                        enemy.cambiarXY();
                        moveEnemy(enemy);

                    }
                    turno = 0;
                }
                break;

            case 'a':
                if (turno == 0){
                    personaje.cambiarXY(0, -1);
                    moveHero();
                    personaje.notificar();
                    turno = 1;
                    count++;
                }else if (turno == 1){
                    personaje.notificar();
                    for (Enemigo enemy: gameModel.getEnemigos()){
                        enemy.cambiarXY(); 
                        moveEnemy(enemy);
                    }
                    turno = 0;
                }
                break;

            case 's':
                if(turno == 0){
                    personaje.cambiarXY(1, 0);
                    moveHero();
                    personaje.notificar();
                    turno = 1;
                    count++;
                }
                else if (turno == 1){
                    personaje.notificar();
                    for (Enemigo enemy: gameModel.getEnemigos()){
                        enemy.cambiarXY(); 
                        moveEnemy(enemy);
                    }
                    turno = 0;
                }
                break;

            case 'd':
                if (turno == 0){
                    personaje.cambiarXY(0, 1);
                    moveHero();
                    personaje.notificar();
                    turno = 1;
                    count++;
                }
                else if (turno == 1){
                    personaje.notificar();
                    for (Enemigo enemy: gameModel.getEnemigos()){
                        enemy.cambiarXY(); 
                        moveEnemy(enemy);
                    }
                    turno = 0;
                }
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

        enemigoEncima();
        aliadoEncima();

        for (Aliado ally: gameModel.getAliados()){
            if (aliadoCerca(ally)){
                drawAlly(ally);
            }
        }
            
        if (count >= 10){
            count = 0;
            for (int i = 0; i < 1; i++){
                crearEnemigo();
                crearAliado();
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
