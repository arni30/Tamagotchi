package world.ucode.controller;

import javafx.stage.Stage;

public abstract class Controller {
    public Stage primaryStage;
    public Controller(Stage stage) {
        primaryStage = stage;
    }
}
