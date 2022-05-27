package Common;

public class Aliado extends Agent{

    public Aliado (int posX, int posY){
        LastPos = new int[2];
        LastPos[X] = posX;
        LastPos[Y] = posY;

        Position = new int[2];
        Position[X] = posX;
        Position[Y] = posY;
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

    

    @Override
    public void update(int posHX, int posHY) {
        
    }
    
}
