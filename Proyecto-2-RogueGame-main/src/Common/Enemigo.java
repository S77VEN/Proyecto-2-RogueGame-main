package Common;

public class Enemigo extends Agent{

    public Enemigo (int posX, int posY){
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
    
        if(HeroPos[X] != Position[X]){
            Position[X] += (HeroPos[X]-Position[X])/Math.abs(HeroPos[X]-Position[X]);
        }
        if(HeroPos[Y] != Position[Y]){
            Position[Y] += (HeroPos[Y]-Position[Y])/Math.abs(HeroPos[Y]-Position[Y]);
        }
    }

    @Override
    public void update(int posHX, int posHY) {
        HeroPos[X] = posHX;
        HeroPos[Y] = posHY;
    }
    
}
