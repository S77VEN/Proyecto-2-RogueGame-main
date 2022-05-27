package Common;

import java.util.ArrayList;

public class Hero implements Constants, SujetoObservado{

    private ArrayList<Observador> observadores;
    int[] Position;
    int[] LastPos;
    int salud;

    public Hero(){
        salud = 5;
        observadores = new ArrayList<Observador>();
        LastPos = new int[2]; 
        LastPos[X] = 0;
        LastPos[Y] = 0;

        Position = new int[2];
        Position[X] = 0;
        Position[Y] = 0;
        
    }

    public int getPosY(){
        return Position[Y];
    }

    public int getPosX(){
        return Position[X];
    }

    public int getLastY(){
        return LastPos[Y];
    }

    public int getLastX(){
        return LastPos[X];
    }

    public int getSalud(){
        return salud;
    }

    public void disminuirSalud(){
        this.salud--;
        System.out.println("SALUD: " + this.salud);
    }

    public void cambiarXY(int posX, int posY){
        LastPos[X] = Position[X];
        LastPos[Y] = Position[Y];
        Position[X] += posX;
        Position[Y] += posY;
    }

    public void anadirObservador(Observador o){
        observadores.add(o);
    }

    @Override
    public void notificar() {
        for(Observador o: observadores){
            o.update(this.Position[X], this.Position[Y]);
        }
    }
}
