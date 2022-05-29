package Common;

public class Enemigo extends Agent{
    int direccion;

    public Enemigo (int posX, int posY){
        direccion = 0;
        LastPos = new int[2];
        LastPos[X] = posX;
        LastPos[Y] = posY;

        Position = new int[2];
        Position[X] = posX;
        Position[Y] = posY;

        HeroPos = new int[2];
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

    public void cambiarXY(){
        LastPos[X] = Position[X];
        LastPos[Y] = Position[Y];


        if (direccion == 0){
            if(HeroPos[X] != Position[X]){
                Position[X] += (HeroPos[X]-Position[X])/Math.abs(HeroPos[X]-Position[X]);
            }
            else if(HeroPos[Y] != Position[Y]){
                Position[Y] += (HeroPos[Y]-Position[Y])/Math.abs(HeroPos[Y]-Position[Y]);
            }
            direccion = 1;
        }
        else if (direccion == 1){
            if(HeroPos[Y] != Position[Y]){
                Position[Y] += (HeroPos[Y]-Position[Y])/Math.abs(HeroPos[Y]-Position[Y]);
            }
            else if(HeroPos[X] != Position[X]){
                Position[X] += (HeroPos[X]-Position[X])/Math.abs(HeroPos[X]-Position[X]);
            }
            direccion = 0;
        }
    }

    @Override
    public void update(int posHX, int posHY) {
        HeroPos[X] = posHX;
        HeroPos[Y] = posHY;
    }
    
}
