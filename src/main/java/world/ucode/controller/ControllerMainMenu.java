package world.ucode.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import world.ucode.scenes.LoadGameScene;
import world.ucode.scenes.NewGameScene;

public class ControllerMainMenu extends Controller{
    @FXML
    private Button newGame;
    @FXML
    private Button loadGame;
    @FXML
    private Button exitGame;
    public ControllerMainMenu(Stage stage) {
        super(stage);
    }
    //OnHoverEvents
    @Override
    public void buttonsSetStyle() {
        buttonSetStyleHover(newGame);
        buttonSetStyleHover(loadGame);
        buttonSetStyleHover(exitGame);
    }
    @FXML
    public void newGameScene() throws IOException {
        NewGameScene newGameScene = new NewGameScene("/NewGameScene.fxml", new ControllerNewGame(primaryStage) ,primaryStage);
        newGameScene.setScene();
    }
    public void loadGame() throws IOException {
        LoadGameScene loadGameScene = new LoadGameScene("/loadGame.fxml", new ControllerLoadGame(primaryStage), primaryStage);
        loadGameScene.setScene();
    }
    @FXML
    public void exitGame() {
        System.exit(0);
    }

}
