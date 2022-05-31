package Common;
import java.awt.Dimension;

import javax.swing.JLabel;

public class Box extends JLabel implements Constants {
    private int[] coords;
    public JLabel saludHeroe;

    public Box(int posX,int posY){
        saludHeroe = new JLabel();
        coords = new int[2];
        coords[X] = posX;
        coords[Y] = posY;
        setPreferredSize(new Dimension(BOX_WIDTH,BOX_HEIGHT));
        
    }

    public void setAsHero (int saludH){
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hero2.png")));
    }

    public void setAsEnemy(){
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/enemy2.png")));
    }

    public void setAsAlly(){
        setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ally2.png")));
    }

    public void clearBox(){
        setIcon(null);
    }
}
