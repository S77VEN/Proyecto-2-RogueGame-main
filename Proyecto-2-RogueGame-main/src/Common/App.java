package Common;
import Controller.*;
import View.*;
import Model.*;

public class App {
    public static void main(String[] args) throws Exception {
        GameFieldView view = new GameFieldView();
        GameModel model = new GameModel();

        Controller RogueGame = new Controller(view, model);
    }
}
