package world.ucode.controller;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import world.ucode.scenes.NewGameScene;

public class ControllerMainMenu extends Controller{
    public ControllerMainMenu(Stage stage) {
        super(stage);
    }
    //OnHoverEvents
    @FXML
    private Button newGame;
    @FXML
    private Button loadGame;
    @FXML
    private Button exitGame;
    @FXML
    private void buttonNewGameEnter() {
        newGame.setStyle(onHoverEnter);
    }
    @FXML
    private void buttonNewGameExit() {
        newGame.setStyle(onHoverExit);
    }

    @FXML
    private void buttonLoadGameEnter() {
        loadGame.setStyle(onHoverEnter);
    }
    @FXML
    private void buttonLoadGameExit() {
        loadGame.setStyle(onHoverExit);
    }

    @FXML
    private void buttonExitGameEnter() {
        exitGame.setStyle(onHoverEnter);
    }
    @FXML
    private void buttonExitGameExit() {
        exitGame.setStyle(onHoverExit);
    }
    @FXML
    public void newGameScene() throws IOException {

        NewGameScene newGameScene = new NewGameScene("/NewGameScene.fxml", new ControllerNewGame(primaryStage) ,primaryStage);
        newGameScene.setScene();
    }
    public void loadGame() {

    }
    @FXML
    public void exitGame() {
        System.exit(0);
    }


}
