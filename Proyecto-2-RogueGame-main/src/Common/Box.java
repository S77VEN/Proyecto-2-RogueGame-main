package Common;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Box extends JPanel implements Constants {
    private int[] coords;

    public Box(int posX,int posY){
        coords = new int[2];
        coords[X] = posX;
        coords[Y] = posY;
        setBackground(BG_COLOR);
        setPreferredSize(new Dimension(BOX_WIDTH,BOX_HEIGHT));
        
    }

    public void setAsHero (){
        setBackground(HERO_COLOR);
    }

    public void setAsEnemy(){
        setBackground(ENEMY_COLOR);
    }

    public void setAsAlly(){
        setBackground(ALLY_COLOR);
    }

    public void clearBox(){
        setBackground(BG_COLOR);
    }
}
