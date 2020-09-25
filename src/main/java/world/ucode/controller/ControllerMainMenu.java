package world.ucode.controller;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import world.ucode.NewGameScene;

public class ControllerMainMenu extends Controller{
    public ControllerMainMenu(Stage stage) {
        super(stage);
        buttonStyles();
    }

    @FXML
    // The reference of inputText will be injected by the FXML loader
    private Button newGame;
    @FXML
    // The reference of inputText will be injected by the FXML loader
    private Button loadGame;
    @FXML
    // The reference of inputText will be injected by the FXML loader
    private Button exitGame;
    private void buttonStyles() {
//        newGame.setOnMouseEntered(e -> newGame.setStyle("-fx-background-color: black"));
//        newGame.setOnMouseExited(e -> newGame.setStyle("-fx-effect: dropshadow( gaussian , red , 1,1,1,1 )"));
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
