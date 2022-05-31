package View;
import javax.swing.*;
import java.awt.GridLayout;
import Common.Box;
import Common.*;



public class GameFieldView extends JFrame implements Constants{
    public CustomPanel Field;
    public Box[][] ArrayField;

    public GameFieldView(){
        setTitle("Rogue Game");

        Field = new CustomPanel();
        ArrayField = new Box[FIELD_SIZE][FIELD_SIZE];

        Field.setLayout(new GridLayout(FIELD_SIZE,FIELD_SIZE));

        for (int i = 0; i < FIELD_SIZE; i++){
            for (int j = 0; j < FIELD_SIZE; j++){
                ArrayField[i][j] = new Box(i, j);
                Field.add(ArrayField[i][j]);
            }
        }
        this.ArrayField[0][0].setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hero2.png")));

        this.setContentPane(Field);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
