package Model;
import Common.*;

import java.util.ArrayList;

public class GameModel {
    ArrayList<Enemigo> listaEnemigos = new ArrayList<Enemigo>();
    ArrayList<Aliado> listaAliados = new ArrayList<Aliado>();

    public void addEnemigo (Enemigo newEnemy){
        listaEnemigos.add(newEnemy);
    }

    public void addAliado(Aliado newAlly){
        listaAliados.add(newAlly);
    }

    public ArrayList<Enemigo> getEnemigos(){
        return listaEnemigos;
    }

    public ArrayList<Aliado> getAliados(){
        return listaAliados;
    }

    public Enemigo enemyFactory (int posX, int posY){
        Enemigo newEnemy = new Enemigo(posX,posY);
        this.addEnemigo(newEnemy);
        return newEnemy;
    }

    public Aliado allyFactory(int posX, int posY){
        Aliado newAlly = new Aliado(posX, posY);
        this.addAliado(newAlly);
        return newAlly;
    }

    public void eliminarEnemigo(Enemigo enemy){
        listaEnemigos.remove(enemy);
    }

    public void eliminarAliado (Aliado ally){
        listaAliados.remove(ally);
    }
    
}
