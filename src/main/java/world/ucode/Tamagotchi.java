package world.ucode;

import javafx.stage.Stage;
import javafx.application.Application;
import world.ucode.controller.ControllerMainMenu;
import world.ucode.scenes.MainMenuScene;

import java.sql.*;


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
