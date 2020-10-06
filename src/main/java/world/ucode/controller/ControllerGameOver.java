package world.ucode.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import world.ucode.view.MainMenuScene;
import world.ucode.view.NewGameScene;

import java.io.IOException;

public class ControllerGameOver extends Controller{
    @FXML
    private Button newGame;
    @FXML
    private Button exit;
    @FXML
    private Button mainMenu;

    public ControllerGameOver(Stage stage) {
        super(stage);
    }

    @FXML
    private void exit(){
        System.exit(0);
    }
    @FXML
    private void mainMenu() throws IOException {
        MainMenuScene mainMenuScene = new MainMenuScene("/Tamagotchi.fxml", new ControllerMainMenu(primaryStage), primaryStage);
        mainMenuScene.setScene();
    }
    @FXML
    private void newGame() throws IOException {
        NewGameScene newGameScene = new NewGameScene("/NewGameScene.fxml", new ControllerNewGame(primaryStage) ,primaryStage);
        newGameScene.setScene();
    }
    @Override
    public void buttonsSetStyle() {
        buttonSetStyleHover(newGame);
        buttonSetStyleHover(exit);
        buttonSetStyleHover(mainMenu);
    }
}
