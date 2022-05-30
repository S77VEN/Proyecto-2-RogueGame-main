package View;
//import java.lang.reflect.Field;
import javax.swing.*;
import java.awt.GridLayout;
import Common.Box;
import Common.*;



public class GameFieldView extends JFrame implements Constants{
    public JPanel Field;
    public Box[][] ArrayField;
    

    public GameFieldView(){

        Field = new JPanel();
        ArrayField = new Box[FIELD_SIZE][FIELD_SIZE];

        Field.setLayout(new GridLayout(FIELD_SIZE,FIELD_SIZE));

        for (int i = 0; i < FIELD_SIZE; i++){
            for (int j = 0; j < FIELD_SIZE; j++){
                ArrayField[i][j] = new Box(i, j);
                Field.add(ArrayField[i][j]);
            }
        }
        this.ArrayField[0][0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hero2.png")));
        this.add(Field);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
    // Funciones para obtener las coordenadas de los labels que se van a utilizar...
    
}
