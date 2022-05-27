package Common;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Box extends JPanel implements Constants {
    private int[] coords;
    public JLabel saludHeroe;

    public Box(int posX,int posY){
        saludHeroe = new JLabel();
        coords = new int[2];
        coords[X] = posX;
        coords[Y] = posY;
        setBackground(BG_COLOR);
        setPreferredSize(new Dimension(BOX_WIDTH,BOX_HEIGHT));
        
    }

    public void setAsHero (int saludH){
        this.add(saludHeroe);
        saludHeroe.setText(String.valueOf(saludH));
        setBackground(HERO_COLOR);
        
        
    }

    public void setAsEnemy(){
        setBackground(ENEMY_COLOR);
    }

    public void setAsAlly(){
        setBackground(ALLY_COLOR);
    }

    public void clearBox(){
        this.remove(saludHeroe);
        setBackground(BG_COLOR);
    }
}
