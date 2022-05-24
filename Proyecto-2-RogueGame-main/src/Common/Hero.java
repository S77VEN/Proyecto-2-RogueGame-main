package Common;

import java.util.ArrayList;

public class Hero implements Constants, SujetoObservado{

    private ArrayList<Observador> observadores;

    int[] Position;

    public Hero(){

        observadores = new ArrayList<Observador>();
        Position = new int[2];
        Position[X] = 0;
        Position[Y] = 0;
        
    }

    public void cambiarXY(int posX, int posY){
        Position[X] += posX;
        Position[Y] += posY;
    }

    public void anadirObservador(Observador o){
        observadores.add(o);
    }

    @Override
    public void notificar() {
        for(Observador o: observadores){
            o.update();
        }
    }
}
