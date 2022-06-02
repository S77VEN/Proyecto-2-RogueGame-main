package Model;
import Common.*;
import java.util.ArrayList;

public class GameModel {
    ArrayList<Enemigo> listaEnemigos = new ArrayList<Enemigo>();
    ArrayList<Aliado> listaAliados = new ArrayList<Aliado>();
    ArrayList<Enemigo> listaEliminarEnemigos = new ArrayList<Enemigo>();
    ArrayList<Aliado> listaEliminarAliados = new ArrayList<Aliado>();
    Hero personaje = new Hero();

    public Hero getHeroe (){
        return personaje;
    }

    public void addEnemigo (Enemigo newEnemy){
        listaEnemigos.add(newEnemy);
    }

    public void addAliado(Aliado newAlly){
        listaAliados.add(newAlly);
    }

    public void addEliminarEnemigo(Enemigo enemy){
        listaEliminarEnemigos.add(enemy);
    }

    public void addEliminarAliado(Aliado ally){
        listaEliminarAliados.add(ally);
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

    public void eliminarEnemigos(){
        for (Enemigo enemy: listaEliminarEnemigos){
            listaEnemigos.remove(enemy);
        }
        
    }

    public void eliminarAliados (){
        for (Aliado ally: listaEliminarAliados){
            listaAliados.remove(ally);
        }
    }
    
}
