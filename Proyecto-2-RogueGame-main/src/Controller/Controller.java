package Controller;
import View.*;
//import Common.*;
import Model.*;

public class Controller {
    GameFieldView fieldView;
    GameModel gameModel;

    public Controller (GameFieldView View, GameModel Model){
        fieldView = View;
        gameModel = Model;
    }

}
