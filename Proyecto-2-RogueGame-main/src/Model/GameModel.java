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

    public Enemigo enemyFactory (){
        Enemigo newEnemy = new Enemigo(7,7);
        this.addEnemigo(newEnemy);
        return newEnemy;
    }

    public void allyFactory(){
        Aliado newAlly = new Aliado(6,6);
        this.addAliado(newAlly);
    }

    public void eliminarEnemigo(Enemigo enemy){
        listaEnemigos.remove(enemy);
    }

    // ArrayList<> de enemigos y aliados
}
