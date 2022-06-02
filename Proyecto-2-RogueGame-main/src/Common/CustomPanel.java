package Common;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;

public class CustomPanel extends JPanel {
    Image imagen = new ImageIcon(getClass().getResource("/Images/BGImage.png")).getImage();
    
    @Override
    public void paint(Graphics g){
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}
