package Common;
import java.awt.Dimension;
//import javax.swing.JLabel;
import javax.swing.JButton;

public class Box extends JButton implements Constants {
    private int[] coords;
    public Box(int posX,int posY){

        coords = new int[2];
        coords[X] = posX;
        coords[Y] = posY;
        setBackground(BG_COLOR);
        setPreferredSize(new Dimension(BOX_WIDTH,BOX_HEIGHT));
        
    }
}
