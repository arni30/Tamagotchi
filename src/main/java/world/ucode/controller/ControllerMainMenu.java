package world.ucode.controller;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import world.ucode.Tamagotchi;
import world.ucode.view.LoadGameScene;
import world.ucode.view.NewGameScene;

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
