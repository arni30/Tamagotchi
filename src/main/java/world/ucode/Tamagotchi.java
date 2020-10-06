package world.ucode;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.util.Duration;
import world.ucode.controller.ControllerMainMenu;
import world.ucode.view.MainMenuScene;

public class Tamagotchi extends Application {
    public static Database db = new Database();
    @Override
    public void start(Stage primaryStage) {
        try {
            db.createDB();
            db.createTable();
            MainMenuScene mainMenuScene = new MainMenuScene("/Tamagotchi.fxml", new ControllerMainMenu(primaryStage), primaryStage);
            mainMenuScene.setScene();
            primaryStage.show();
        }
        catch (Exception e) {
            System.err.println("error");
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
