package world.ucode;

import javafx.stage.Stage;
import javafx.application.Application;
import world.ucode.controller.ControllerMainMenu;


public class Tamagotchi extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
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
